package games.score;

import java.util.HashMap;
import java.util.Map;

import cartago.Artifact;
import cartago.OPERATION;

public class ScoreBoardArtifact extends Artifact {
	private Object lock = new Object();
	private Map<Integer, RoundScoreRecorder> scoreHistory = new HashMap<Integer, RoundScoreRecorder>();
	private RoundScoreRecorder currentRoundScoreRecorder;
	private int numberOfAgentsFinishedUpdatingStrategies = 0;
	private int numberOfAgentsFinishedBeforeCreatingNewRound = 0;
	private int currentRound = 0;
	
	@OPERATION
	public void createNewRoundScoreRecorder(int numberOfAgents, int numberOfRounds) {
		synchronized (lock) {
			if (this.scoreHistory.size() < numberOfRounds) {
				if (this.scoreHistory.size() == 0) {
					this.currentRoundScoreRecorder = new RoundScoreRecorder();
				} else {
					this.numberOfAgentsFinishedBeforeCreatingNewRound++;
					if (this.numberOfAgentsFinishedBeforeCreatingNewRound == numberOfAgents) {
						this.currentRoundScoreRecorder = new RoundScoreRecorder();
						this.numberOfAgentsFinishedBeforeCreatingNewRound = 0;
					}
				}
			}
		}
	}
	
	@OPERATION
	public void recordBid(String agentId, int bid) {
		synchronized (lock) {
			this.currentRoundScoreRecorder.updatePlayerBids(agentId, bid);
		}
	}
	
	@OPERATION
	public void recordPayoff(String agentId, float payoff) {
		synchronized (lock) {
			this.currentRoundScoreRecorder.updatePlayerPayoffs(agentId, payoff);
		}
	}
	
	@OPERATION
	public void storeCurrentRound(int numberOfAgents) {
		synchronized (lock) {
			this.numberOfAgentsFinishedUpdatingStrategies++;
			if (this.numberOfAgentsFinishedUpdatingStrategies == numberOfAgents) {
				this.scoreHistory.put(currentRound, currentRoundScoreRecorder);
				this.numberOfAgentsFinishedUpdatingStrategies = 0;
				this.currentRound++;
			}
		}
	}
	
	@OPERATION
	public void printTournament() {
		synchronized (lock) {
			for (int i = 0; i < scoreHistory.size(); i++) {
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
			
		}
	}
}
