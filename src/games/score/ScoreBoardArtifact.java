package games.score;

import java.util.ArrayList;

import cartago.Artifact;
import cartago.OPERATION;

public class ScoreBoardArtifact extends Artifact {
	private Object lock = new Object();
	private ArrayList<RoundScoreRecorder> scoreHistory = new ArrayList<RoundScoreRecorder>();
	private RoundScoreRecorder currentRoundScoreRecorder;
	private int numberOfAgentsFinishedUpdatingStrategies = 0;
	
	@OPERATION
	public void createNewRoundScoreRecorder(int numberOfAgents, int numberOfRounds) {
		synchronized (lock) {			
			if (this.scoreHistory.size() < numberOfRounds) {
				if (this.scoreHistory.size() == 0) {
					this.currentRoundScoreRecorder = new RoundScoreRecorder();
				} else {
					this.numberOfAgentsFinishedUpdatingStrategies++;
					if (this.numberOfAgentsFinishedUpdatingStrategies == numberOfAgents) {
						this.currentRoundScoreRecorder = new RoundScoreRecorder();
						this.numberOfAgentsFinishedUpdatingStrategies = 0;
					}
				}
			}
		}
	}
	
	@OPERATION
	public void recordBid(String agentId, int bid) {
		synchronized (lock) {
			currentRoundScoreRecorder.updatePlayerBids(agentId, bid);
		}
	}
	
	@OPERATION
	public void recordPayoff(String agentId, float payoff) {
		synchronized (lock) {
			currentRoundScoreRecorder.updatePlayerPayoffs(agentId, payoff);
		}
	}
	
	@OPERATION
	public void storeCurrentRound(int numberOfAgents) {
		synchronized (lock) {
			this.numberOfAgentsFinishedUpdatingStrategies++;
			if (this.numberOfAgentsFinishedUpdatingStrategies == numberOfAgents) {
				this.scoreHistory.add(currentRoundScoreRecorder);
				this.numberOfAgentsFinishedUpdatingStrategies = 0;
			}
		}
	}
	
	@OPERATION
	public void printTournament() {
		synchronized (lock) {
			int i = 0;
			for (RoundScoreRecorder scoreRecorder: scoreHistory) {
				System.out.println("\nRound: " + i);
				System.out.println("Agent ID\t\t|\t\tBid");
				for (String key: scoreRecorder.getPlayerBids().keySet()) {
					System.out.println(key + "\t\t|\t\t " + scoreRecorder.getPlayerBids().get(key));
				}
				
				System.out.println("Agent ID\t\t|\t\tPayoff");
				
				for (String key: scoreRecorder.getPlayerPayoffs().keySet()) {
					System.out.println(key + "\t\t|\t\t " + scoreRecorder.getPlayerPayoffs().get(key));
				}
				i++;
			}
			
		}
	}
}
