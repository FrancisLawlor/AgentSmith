package tournament.core;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cartago.Artifact;
import cartago.OPERATION;
import strategies.core.StrategiesResources;
import tournament.data.TournamentData;
import tournament.player.Player;
import tournament.round.Round;

public class TournamentArtifact extends Artifact{
	private TournamentData tournamentData;
	private Tournament tournament;
	private static Object lock = new Object();
	private int currentRound = 0;
	private Map<String, Integer> currentGuesses = new HashMap<String, Integer>();
	private Map<String, Float> currentPayoffs = new HashMap<String, Float>();
	private int numberOfReceivedPayoffs = 0;
	private int currentNumberOfGuesses = 0;
	private int roundsPerRun = 5;
	private int roundsCompleted = 0;

	@OPERATION
	public void createTournament(String tournamentDataJsonString) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		this.tournamentData = gsonUtility.fromJson(tournamentDataJsonString, TournamentData.class);
		
		this.tournament = configureTournament(this.tournamentData);		
	}
	
	private Tournament configureTournament(TournamentData tournamentData) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
		Tournament newTournament = new Tournament();
		
		// Configure rounds.
		for (int i = 0; i < this.tournamentData.getRounds().size(); i++) {
			for (int j = 0; j < this.tournamentData.getRounds().get(i).getAmount(); j++) {
				HashMap<String, String> additionalParameters = new HashMap<String, String>();
				
				for (int k = 0; k < this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().size(); k++) {
					String name = this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getName();
					String value = this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getValue();
					additionalParameters.put(name, value);
				}
				Round newRound = new Round(this.tournamentData.getRounds().get(i).getGame().getName(), additionalParameters);

				newTournament.getRounds().add(newRound);
			}
		}

		// Configure players.
		int currentId = 0;
		for (int i = 0; i < this.tournamentData.getAgents().size(); i++) {
			for (int j = 0; j < this.tournamentData.getAgents().get(i).getAmount(); j++) {
				HashMap<String, String> additionalParameters = new HashMap<String, String>();
				for (int k = 0; k < this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().size(); k++) {
					String name = this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getName();
					String value = this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getValue();
					additionalParameters.put(name, value);
				}
				
				Player newPlayer = new Player(currentId + "", this.tournamentData.getAgents().get(i).getStrategyData().getName() , additionalParameters);
				newTournament.getAgents().add(newPlayer);
				currentId++;
			}
		}
		
		return newTournament;
	}
	
	@OPERATION
	public void createAgents() {
		synchronized (lock) {
			for (int i = 0; i < this.tournament.getAgents().size(); i++) {
				signal(TournamentResources.CREATE_AGENT, this.tournament.getAgents().get(i).getId());
			}
		}
	}
	
	@OPERATION
	public void getNumberOfAgents() {
		synchronized (lock) {
			signal(TournamentResources.STORE_NUMBER_OF_AGENTS, this.tournament.getAgents().size());
		}
	}
	
	@OPERATION
	public void getNumberOfRounds() {
		synchronized (lock) {
			signal(TournamentResources.STORE_NUMBER_OF_ROUNDS, this.tournament.getRounds().size());
		}
	}
	
	@OPERATION
	public void newRound() {
		synchronized (lock) {
			if (this.roundsCompleted < this.roundsPerRun) {
				this.roundsCompleted++;
				if (this.currentRound < this.tournament.getRounds().size()) {
					signal(TournamentResources.START_NEW_ROUND);
				} else {
					signal(TournamentResources.END_TOURNAMENT);
				}
			} else {
				this.roundsCompleted = 0;
			}
		}
	}
	
	@OPERATION
	public void getNumberOfOptions(String agentId) {
		synchronized (lock) {
			signal(TournamentResources.NUMBER_OF_OPTIONS, agentId, this.tournament.getRounds().get(this.currentRound).getGame().getNumberOfOptions());
		}
	}
	
	@OPERATION
	public void playGame(String agentId, int bid) {
		synchronized (lock) {
			this.currentGuesses.put(agentId, bid);
			this.currentNumberOfGuesses++;
			
			if (this.currentNumberOfGuesses == this.tournament.getAgents().size()) {		
				this.currentPayoffs = this.tournament.getRounds().get(this.currentRound).getGame().play(this.currentGuesses);

				for (String id: this.currentPayoffs.keySet()) {
					signal(TournamentResources.GAME_FINISHED, id, this.currentPayoffs.get(id));
				}
				
				this.currentNumberOfGuesses = 0;
			}		
		}
	}
	
	@OPERATION 
	public void receivedPayoff() {
		synchronized (lock) {
			this.numberOfReceivedPayoffs++;
			if (this.numberOfReceivedPayoffs == this.tournament.getAgents().size()) {
				Map<String, Integer> updateDataMap = this.tournament.getRounds().get(this.currentRound).getGame().getUpdateStrategyData(this.currentGuesses);
				
				for (String updateKey: updateDataMap.keySet()) {
					signal(TournamentResources.SEND_UPDATE_KEY_VALUE_PAIR, updateKey, updateDataMap.get(updateKey));
				}
				
				this.numberOfReceivedPayoffs = 0;
				this.currentRound++;
			}
		}
	}
	
	@OPERATION
	public void getGuess(String agentId, int numberOfOptions) {
		synchronized (lock) {
			signal(StrategiesResources.GENERATED_GUESS, agentId, 
					this.tournament.getAgents().get(Integer.parseInt(agentId)).getStrategy().generateChoice(null), this.tournament.getAgents().size());
		}
	}
	
	@OPERATION
	public void updateStrategy(String agentId, String dataKey, int dataValue) {
		synchronized (lock) {
			this.tournament.getAgents().get(Integer.parseInt(agentId)).getStrategy().updateStrategy(dataKey, dataValue);
			signal(StrategiesResources.UPDATE_RECEIVED, agentId);
		}
	}
	
	@OPERATION
	public void startNRounds() {
		synchronized (lock) {
			signal(TournamentResources.START_NEXT_N_ROUNDS);
		}
	}	
}