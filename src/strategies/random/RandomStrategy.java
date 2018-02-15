package strategies.random;

import java.util.HashMap;

import strategies.core.Strategy;

public class RandomStrategy extends Strategy {
	public RandomStrategy(int numberOfChoices) {
		super(numberOfChoices);
	}

	public int generateChoice(HashMap<String, Object> strategyResources) {
		int randomChoice = (int) (Math.random() * 2);

		if (randomChoice == 0) {
			return -1;
		} else {
			return 1;
		}
	}
}