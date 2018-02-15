package strategies.core;

import java.util.HashMap;

public abstract class Strategy {
	protected int numberOfChoices;
	
	public Strategy(int numberOfChoices) {
		this.numberOfChoices = numberOfChoices;
	}
	
	public abstract int generateChoice(HashMap<String, Object> strategyResources);
}
