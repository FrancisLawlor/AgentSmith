package strategies.core;


import java.io.IOException;
import java.util.HashMap;

public interface IStrategy {
	public void init(HashMap<String, String> additionalParameters);
	public int generateChoice(HashMap<String, Object> strategyResources);
	public void updateStrategy(String key, int value);
	public byte[] getIconAsBytes() throws IOException;
	public String getStrategyName();
	public String[] getAdditionalParameterNames();
}
