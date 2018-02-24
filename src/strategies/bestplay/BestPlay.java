package strategies.bestplay;

import java.util.HashMap;
import java.util.LinkedList;

import games.minoritygame.MinorityGameInputMapper;
import strategies.core.Strategy;

public class BestPlay extends Strategy {
	private static final String WINNING_CHOICE = "WINNING_CHOICE";
	
	private ChoiceHistory choiceHistory;
	private int[] strategyVector;
	private int numberOfChoices;

	public BestPlay(int numberOfChoices) {
		this.choiceHistory = new ChoiceHistory(numberOfChoices);
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
		if (choiceHistory.isShorterThanM()) {
			int randomChoice = (int) (Math.random() * this.numberOfChoices);

			return MinorityGameInputMapper.mapInput(randomChoice);
		} else {
			LinkedList<Integer> previousMChoices = null;
			
			try {
				previousMChoices = choiceHistory.getPreviousMChoices();
			} catch (InsufficientHistoryException e) {
				e.printStackTrace();
			}

			int strategyIndex = 0;
			
			// n-ary mapping to array index
			for (int i = 0; i < choiceHistory.getChoiceHistoryLength(); i++) {
				strategyIndex += strategyVector[choiceHistory.getChoiceHistoryLength() - 1 - i] * Math.pow(this.numberOfChoices, i);
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
