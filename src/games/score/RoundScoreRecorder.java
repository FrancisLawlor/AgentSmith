package games.score;

import java.util.HashMap;
import java.util.Map;

public class RoundScoreRecorder {
	private Map<String, Integer> playerBids = new HashMap<String, Integer>();
	private Map<String, Float> playerPayoffs = new HashMap<String, Float>();
	
	public void updatePlayerBids(String agentId, int bid) {
		this.playerBids.put(agentId, bid);
	}
	
	public void updatePlayerPayoffs(String agentId, float payoff) {
		this.playerPayoffs.put(agentId, payoff);
	}
	
	public Map<String, Integer> getPlayerBids() {
		return this.playerBids;
	}
	
	public Map<String, Float> getPlayerPayoffs() {
		return this.playerPayoffs;
	}
}
