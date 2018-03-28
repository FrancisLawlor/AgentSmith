package tournament.data;

import java.util.HashMap;
import java.util.Map;

public class CumulativePayoffsData {
	private Map<String, Float> cumulativePayoffs;
	private int latestRound;
	
	public CumulativePayoffsData() {
		this.cumulativePayoffs = new HashMap<>();
		this.latestRound = 0;
	}
	
	public Map<String, Float> getCumulativePayoffs() {
		return this.cumulativePayoffs;
	}
	
	public int getLatestRound() {
		return this.latestRound;
	}
	
	public void setLatestRound(int latestRound) {
		this.latestRound = latestRound;
	}
}
