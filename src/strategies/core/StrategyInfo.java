package strategies.core;

import java.util.HashMap;

public class StrategyInfo {
	private String name;
	//private HashMap<String, Integer> additionalParameters;
	
	public StrategyInfo(String name) {
		this.name = name;
	}
//	"name": "strategies.bestplay.BestPlay",
//	"additional_parameters": [
//		{
//			"history_length":8
//		}
//	]

	public String getName() {
		return this.name;
	}
}
