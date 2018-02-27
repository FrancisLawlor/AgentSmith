package strategies.bestplay;

import java.util.HashMap;
import java.util.LinkedList;

import strategies.core.Strategy;

public class BestPlay extends Strategy {
	private static final String WINNING_CHOICE = "winning_choice";
	private static final String NUMBER_OF_CHOICES = "number_of_choices";
	private static final String HISTORY_LENGTH = "history_length";
	
	private ChoiceHistory choiceHistory;
	private int[] strategyVector;
	private int numberOfChoices;

	public BestPlay(HashMap<String, String> additionalParameters) {
		super(additionalParameters);
		this.numberOfChoices = Integer.parseInt(additionalParameters.get(NUMBER_OF_CHOICES));
		this.choiceHistory = new ChoiceHistory(Integer.parseInt(additionalParameters.get(HISTORY_LENGTH)));
		this.strategyVector = generateStrategyVector(choiceHistory.getChoiceHistoryLength());
	}

	private int[] generateStrategyVector(int m) {
		int sizeOfStrategyVector = (int) Math.pow(this.numberOfChoices, m);
		int[] strategyVector = new int[sizeOfStrategyVector];

		for (int i = 0; i < sizeOfStrategyVector; i++) {
			int randomChoice = (int) (Math.random() * this.numberOfChoices);

			strategyVector[i] = randomChoice;
		}

		return strategyVector;
	}

	@Override
	public int generateChoice(HashMap<String, Object> strategyResources) {
		if (this.choiceHistory.isShorterThanM()) {
			int randomChoice = (int) (Math.random() * this.numberOfChoices);
			
			return randomChoice;
		} else {
			LinkedList<Integer> previousMChoices = null;
			
			try {
				previousMChoices = choiceHistory.getPreviousMChoices();
			} catch (InsufficientHistoryException e) {
				e.printStackTrace();
			}

			int strategyIndex = 0;
			
			// n-ary mapping to array index
			for (int i = 0; i < this.choiceHistory.getChoiceHistoryLength(); i++) {
				strategyIndex += this.strategyVector[this.choiceHistory.getChoiceHistoryLength() - 1 - i] * Math.pow(this.numberOfChoices, i);
			}
			
			return this.strategyVector[strategyIndex];
		}
	}
	
	public void updateStrategy(String key, int value) {
		if (key.equals(WINNING_CHOICE)) {
			this.choiceHistory.updateChoiceHistory(value);
		}
	}
}
