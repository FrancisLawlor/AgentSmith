package strategies.random;

import java.io.IOException;
import java.util.HashMap;

import strategies.core.IStrategy;
import strategies.core.Strategy;

public class RandomStrategy extends Strategy implements IStrategy {
	public RandomStrategy(HashMap<String, String> additionalParameters) {
		super(additionalParameters);
	}

	public int generateChoice(HashMap<String, Object> strategyResources) {
		int randomChoice = (int) (Math.random() * 2);

		if (randomChoice == 0) {
			return -1;
		} else {
			return 1;
		}
	}

	@Override
	public void updateStrategy(String key, int value) {
		System.out.println("Updated Random Strategy");
	}

	@Override
	public byte[] getIconAsBytes() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStrategyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getAdditionalParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
