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

import cartago.AgentBodyArtifact;
import cartago.AgentId;
import cartago.Artifact;
import cartago.OPERATION;
import cartago.security.AgentCredential;
import cartago.util.agent.Agent;

public class TournamentArtifact extends Artifact{
	private Tournament tournament;
	private static Object lock = new Object();
	private int currentRound = 0;
	private Map<String, Integer> currentGuesses = new HashMap<String, Integer>();
	private Map<String, Float> currentPayoffs = new HashMap<String, Float>();
	private int numberOfReceivedPayoffs = 0;
	private Map<String, Integer> updateStrategyData = new HashMap<String, Integer>();

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
	public void getNumberOfOptions(String agentId) {
		synchronized (lock) {
			signal(TournamentResources.NUMBER_OF_OPTIONS, agentId, tournament.getRounds().get(currentRound).getGame().getNumberOfOptions());
		}
	}
	
	@OPERATION
	public void playGame(String agentId, int bid) {
		synchronized (lock) {
			currentGuesses.put(agentId, bid);
			
			if (currentGuesses.size() == tournament.getAgents().size()) {
				this.currentPayoffs = tournament.getRounds().get(currentRound).getGame().play(currentGuesses);
				
				int i = 0;
				for (String id: currentPayoffs.keySet()) {
					signal(TournamentResources.GAME_FINISHED, id, this.currentPayoffs.get(id));
					System.out.println(i++ + " " + id);
				}
			}			
		}
	}
	
	@OPERATION void receivedPayoff() {
		this.numberOfReceivedPayoffs++;
		
		if (numberOfReceivedPayoffs == tournament.getAgents().size()) {
			numberOfReceivedPayoffs = 0;
			
			System.out.println("all received");
			
			Map<String, Integer> updateDataMap = this.tournament.getRounds().get(currentRound).getGame().getUpdateStrategyData(this.currentGuesses);
			
			for (String updateKey: updateDataMap.keySet()) {
				signal(TournamentResources.SEND_UPDATE_KEY_VALUE_PAIR, updateKey, updateDataMap.get(updateKey));
				System.out.println(updateKey + ": " + updateDataMap.get(updateKey));
			}
		}
	}
	
	@OPERATION
	public void getNumberOfAgents() {
		synchronized (lock) {
			signal(TournamentResources.NUMBER_OF_AGENTS, tournament.getAgents().size());
		}
	}
	
	@OPERATION
	public void getPayoff(String agentId) {
		synchronized (lock) {
			signal(TournamentResources.SEND_PAYOFF, agentId, this.currentPayoffs.get(agentId));
		}
	}
	
	@OPERATION
	public void updateStrategies() {
		synchronized (lock) {
			if (numberOfReceivedPayoffs == tournament.getAgents().size()) {
				this.updateStrategyData = tournament.getRounds().get(currentRound).getGame().getUpdateStrategyData(currentGuesses);
			}
			
			signal(TournamentResources.TOURNAMENT_MANAGER_AGENT_ID);
		}
	}
	
	@OPERATION
	public void getStrategyUpdateData() {
		synchronized (lock) {
			for (String dataId: this.updateStrategyData.keySet()) {
				signal(TournamentResources.STRATEGY_UPDATE, dataId, this.updateStrategyData.get(dataId));
			}
		}
	}
}
