package strategies.bestplay;

import java.util.HashMap;
import java.util.LinkedList;

import strategies.core.Strategy;

public class BestPlay extends Strategy {
	private static final int NUMBER_OF_CHOICES = 2;
	private static final int BID_MINUS_ONE = -1;
	private static final int BID_ONE = 1;
	
	private ChoiceHistory choiceHistory;
	private int[] strategy;

	public BestPlay(int numberOfChoices) {
		super(numberOfChoices);
		ChoiceHistory choiceHistory = new ChoiceHistory(numberOfChoices);
		this.strategy = generateStrategy(choiceHistory.getChoiceHistoryLength());
	}

	private int[] generateStrategy(int m) {
		int numberOfInputs = (int) Math.pow(NUMBER_OF_CHOICES, m);
		int[] output = new int[numberOfInputs];

		for (int i = 0; i < numberOfInputs; i++) {
			int randomChoice = (int) (Math.random() * NUMBER_OF_CHOICES);

			// TO_DO make more generalisable
			if (randomChoice == 0) {
				output[i] = -1;
			} else {
				output[i] = 1;
			}
		}

		return output;
	}

	@Override
	public int generateChoice(HashMap<String, Object> strategyResources) {
		if (choiceHistory.isShorterThanM()) {
			int randomChoice = (int) (Math.random() * this.numberOfChoices);

			if (randomChoice == 0) {
				choiceHistory.updateChoiceHistory(BID_MINUS_ONE);
				return BID_MINUS_ONE;
			} else {
				choiceHistory.updateChoiceHistory(BID_ONE);
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

			int choice = strategy[strategyIndex];

			choiceHistory.updateChoiceHistory(choice);

			return choice;
		}
	}
}
