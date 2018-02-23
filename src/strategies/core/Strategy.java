package strategies.core;

import java.util.HashMap;

public abstract class Strategy {	
	public abstract int generateChoice(HashMap<String, Object> strategyResources);
	public abstract void updateStrategy(String key, int value);
}
