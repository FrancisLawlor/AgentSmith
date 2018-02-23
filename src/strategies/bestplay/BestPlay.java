package strategies.bestplay;

import java.util.HashMap;
import java.util.LinkedList;

import strategies.core.Strategy;

public class BestPlay extends Strategy {
	private static final int NUMBER_OF_CHOICES = 2;
	private static final int BID_MINUS_ONE = -1;
	private static final int BID_ONE = 1;
	private static final String WINNING_CHOICE = "WINNING_CHOICE";
	
	private ChoiceHistory choiceHistory;
	private int[] strategyVector;

	public BestPlay() {
		this.choiceHistory = new ChoiceHistory(NUMBER_OF_CHOICES);
		this.strategyVector = generateStrategyVector(choiceHistory.getChoiceHistoryLength());
	}

	private int[] generateStrategyVector(int m) {
		int numberOfInputs = (int) Math.pow(NUMBER_OF_CHOICES, m);
		int[] output = new int[numberOfInputs];

		for (int i = 0; i < numberOfInputs; i++) {
			int randomChoice = (int) (Math.random() * NUMBER_OF_CHOICES);

			// TO_DO make more generalisable
			if (randomChoice == 0) {
				output[i] = BID_MINUS_ONE;
			} else {
				output[i] = BID_ONE;
			}
		}

		return output;
	}

	@Override
	public int generateChoice(HashMap<String, Object> strategyResources) {
		if (choiceHistory.isShorterThanM()) {
			int randomChoice = (int) (Math.random() * NUMBER_OF_CHOICES);

			if (randomChoice == 0) {
				return BID_MINUS_ONE;
			} else {
				return BID_ONE;
			}
		} else {
			LinkedList<Integer> previousMChoices = null;
			try {
				previousMChoices = choiceHistory.getPreviousMChoices();
			} catch (InsufficientHistoryException e) {
				e.printStackTrace();
			}

			int strategyIndex = 0;

			for (int i = 0; i < choiceHistory.getChoiceHistoryLength(); i++) {
				int choice = previousMChoices.get(i);

				if (choice == 1) {
					strategyIndex += Math.pow(NUMBER_OF_CHOICES, choiceHistory.getChoiceHistoryLength() - 1 - i);
				}
			}
			
			return strategyVector[strategyIndex];
		}
	}
	
	public void updateStrategy(String key, int value) {
		if (key.equals(WINNING_CHOICE)) {
			choiceHistory.updateChoiceHistory(value);
		}
	}
}
