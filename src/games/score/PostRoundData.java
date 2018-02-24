package games.score;

import java.util.HashMap;
import java.util.Map;

public class PostRoundData {
	private Map<String, Float> currentPayoffs = new HashMap<String, Float>();
	private Map<String, Integer> playerSelections = new HashMap<String, Integer>();
	
	public Map<String, Float> getCurrentPayoffs() {
		return this.currentPayoffs;
	}
	
	public Map<String, Integer> getPlayerSelections() {
		return this.playerSelections;
	}
}
