package tournament.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cartago.Artifact;
import cartago.OPERATION;

public class TournamentArtifact extends Artifact{
	private Tournament tournament;
	private static Object lock = new Object();
	private int currentRound = 0;
	private Map<String, Integer> currentGuesses = new HashMap<String, Integer>();
	private Map<String, Float> currentPayoffs = new HashMap<String, Float>();
	private int numberOfReceivedPayoffs = 0;
	private int numberOfAgentsFinishedUpdatingStrategies = 0;
	private int currentNumberOfGuesses = 0;

	@OPERATION
	public void configureTournament(String configFilePath) throws IOException {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(configFilePath));
		String tournamentJsonString = bufferedReader.readLine();		
		bufferedReader.close();
		
		this.tournament =  gsonUtility.fromJson(tournamentJsonString, Tournament.class);
		
		try {
			for (int i = 0; i < this.tournament.getRounds().size(); i++) {
				this.tournament.getRounds().get(i).init();
			}
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	@OPERATION
	public void createAgents() {
		synchronized (lock) {
			for (int i = 0; i < tournament.getAgents().size(); i++) {
				signal("createAgent", tournament.getAgents().get(i).getId(), tournament.getAgents().get(i).getStrategy());
			}
		}
	}
	
	@OPERATION
	public void newRound() {
		synchronized (lock) {
			if (this.currentRound < this.tournament.getRounds().size()) {
				if (this.currentRound == 0) {
					signal(TournamentResources.START_NEW_ROUND, this.tournament.getAgents().size());
				} else {
					numberOfAgentsFinishedUpdatingStrategies++;
					if (numberOfAgentsFinishedUpdatingStrategies == this.tournament.getAgents().size()) {
						signal(TournamentResources.START_NEW_ROUND, this.tournament.getAgents().size());
						numberOfAgentsFinishedUpdatingStrategies = 0;
					}
				}
			} else {
				numberOfAgentsFinishedUpdatingStrategies++;
				if (numberOfAgentsFinishedUpdatingStrategies == this.tournament.getAgents().size()) {
					signal(TournamentResources.END_TOURNAMENT);
					numberOfAgentsFinishedUpdatingStrategies = 0;
				}
			}
		}
	}
	
	@OPERATION
	public void getNumberOfOptions(String agentId) {
		synchronized (lock) {
			signal(TournamentResources.NUMBER_OF_OPTIONS, agentId, tournament.getRounds().get(currentRound).getGame().getNumberOfOptions());
		}
	}
	
	@OPERATION
	public void playGame(String agentId, int bid) {
		synchronized (lock) {
			this.currentGuesses.put(agentId, bid);
			this.currentNumberOfGuesses++;
			
			if (currentNumberOfGuesses == tournament.getAgents().size()) {
				this.currentPayoffs = tournament.getRounds().get(currentRound).getGame().play(currentGuesses);
				
				for (String id: currentPayoffs.keySet()) {
					signal(TournamentResources.GAME_FINISHED, id, this.currentPayoffs.get(id));
				}
				
				this.currentNumberOfGuesses = 0;
			}		
		}
	}
	
	@OPERATION void receivedPayoff() {
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
}
