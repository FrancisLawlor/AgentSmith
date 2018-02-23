package games.score;

import java.util.HashMap;
import java.util.Map;

import cartago.Artifact;
import cartago.OPERATION;

public class ScoreBoardArtifact extends Artifact {
	private Map<String, Float> payoffs = new HashMap<String, Float>();
	private Object lock;
	
	@OPERATION
	public void updatePayoffs(String agentId, float payoff) {
		synchronized (lock) {
			if (payoffs.containsKey(agentId)) {
				payoffs.put(agentId, payoffs.get(agentId + payoff));
			} else {
				payoffs.put(agentId, payoff);
			}
		}
	}
}
