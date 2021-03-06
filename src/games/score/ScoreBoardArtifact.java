package games.score;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cartago.Artifact;
import cartago.OPERATION;
import filemanagement.fileloader.FileSaver;
import games.core.GamesResources;
import tournament.core.TournamentResources;

public class ScoreBoardArtifact extends Artifact {
	private Object lock = new Object();
	private Map<Integer, RoundScoreRecorder> scoreHistory = new HashMap<Integer, RoundScoreRecorder>();
	private RoundScoreRecorder currentRoundScoreRecorder;
	private Map<String, Float> cumulativePayoffs = new HashMap<>();
	private int numberOfAgentsFinishedUpdatingStrategies = 0;
	private int currentRound = 0;
	private int currentNumberOfBids = 0;
	private int currentNumberOfRecordedPayoffs = 0;
	
	@OPERATION
	public void createNewRoundScoreRecorder(int numberOfAgents, int numberOfRounds) {
		synchronized (lock) {
			if (this.scoreHistory.size() < numberOfRounds) {
				this.currentRoundScoreRecorder = new RoundScoreRecorder();
			}
		}
	}
	
	@OPERATION
	public void recordBid(String agentId, int bid, int numberOfAgents) {
		synchronized (lock) {
			this.currentNumberOfBids++;
			this.currentRoundScoreRecorder.updatePlayerBids(agentId, bid);

			if (this.currentNumberOfBids == numberOfAgents) {
				for (String agentIdKey: this.currentRoundScoreRecorder.getPlayerBids().keySet()) {
					signal(GamesResources.BID_RECEIVED, agentIdKey, this.currentRoundScoreRecorder.getPlayerBids().get(agentIdKey));
				}
				
				this.currentNumberOfBids = 0;
			}		
		}
	}
	
	@OPERATION
	public void recordPayoff(String agentId, float payoff, int numberOfAgents) {
		synchronized (lock) {
			this.currentNumberOfRecordedPayoffs++;
			this.currentRoundScoreRecorder.updatePlayerPayoffs(agentId, payoff);

			if (this.currentNumberOfRecordedPayoffs == numberOfAgents) {
				updateCumulativePayoffs(this.currentRoundScoreRecorder);
				signal(GamesResources.ALL_PAYOFFS_RECORDED);
				this.currentNumberOfRecordedPayoffs = 0;
			}		
		}
	}
		
	private void updateCumulativePayoffs(RoundScoreRecorder currentRoundScoreRecorder) {
		for (String key: this.currentRoundScoreRecorder.getPlayerPayoffs().keySet()) {
			if (this.cumulativePayoffs.containsKey(key)) {
				this.cumulativePayoffs.put(key, this.cumulativePayoffs.get(key) + this.currentRoundScoreRecorder.getPlayerPayoffs().get(key));
			} else {
				this.cumulativePayoffs.put(key, this.currentRoundScoreRecorder.getPlayerPayoffs().get(key));
			}
			
			this.cumulativePayoffs.put(TournamentResources.CURRENT_ROUND, (float) this.currentRound);
		}
	}

	@OPERATION
	public void storeCurrentRound(int numberOfAgents) {
		synchronized (lock) {
			this.numberOfAgentsFinishedUpdatingStrategies++;
			if (this.numberOfAgentsFinishedUpdatingStrategies == numberOfAgents) {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.scoreHistory.put(this.currentRound, this.currentRoundScoreRecorder);
				this.numberOfAgentsFinishedUpdatingStrategies = 0;
				this.currentRound++;
				signal(GamesResources.FINISHED_STORING_CURRENT_ROUND);
			}
		}
	}
	
	@OPERATION
	public void printTournament() {
		synchronized (lock) {
			for (int i = 0; i < this.scoreHistory.size(); i++) {
				System.out.println("\nRound: " + i);
				System.out.println("Agent ID\t\t|\t\tBid");
				
				for (String key: scoreHistory.get(i).getPlayerBids().keySet()) {
					System.out.println(key + "\t\t|\t\t " + scoreHistory.get(i).getPlayerBids().get(key));
				}
				
				System.out.println("Agent ID\t\t|\t\tPayoff");
				
				for (String key: scoreHistory.get(i).getPlayerPayoffs().keySet()) {
					System.out.println(key + "\t\t|\t\t " + scoreHistory.get(i).getPlayerPayoffs().get(key));
				}
			}
			
			signal(GamesResources.TERMINATE_GAME_MASTER);
		}
	}
	
	@OPERATION
	public void progressReport() {
		synchronized (lock) {
			if (this.currentRound != 0) {
				System.out.println("\nProgress report after " + this.currentRound + " rounds:");
				System.out.println("Agent ID\t|\tPayoff");
				
				float total = 0;
				for (int i = 0; i < this.cumulativePayoffs.size() - 1; i++) {
					total += this.cumulativePayoffs.get(i + "");
					System.out.println(i + ": \t\t|\t\t" + this.cumulativePayoffs.get(i + ""));
				}
				
				System.out.println("Group payoff: " + total);
			}
		}	
	}
	
	@OPERATION
	public void saveResults(String filePath) throws IOException {
		synchronized (lock) {
			Gson gsonUtility = new GsonBuilder()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.create();
			
			FileSaver.saveJsonStringToFile(gsonUtility.toJson(this.scoreHistory), filePath);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	
	@OPERATION
	public void storePreviousPhase(String tempFilePath) throws IOException {
		synchronized (lock) {			
			Gson gsonUtility = new GsonBuilder()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.create();
			
			FileSaver.saveJsonStringToFile(gsonUtility.toJson(this.cumulativePayoffs), tempFilePath);
		}
	}
}
