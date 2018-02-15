package strategies.bestplay;

import java.util.LinkedList;

public class ChoiceHistory {
    private LinkedList<Integer> choiceHistory;
    private int choiceHistoryLength;

    public ChoiceHistory(int choiceHistoryLength) {
        this.choiceHistory = new LinkedList<>();
        this.choiceHistoryLength = choiceHistoryLength;
    }

    public void updateChoiceHistory(int i) {
        if (choiceHistory.size() < choiceHistoryLength) {
            this.choiceHistory.add(i);
        } else {
            this.choiceHistory.removeFirst();
            this.choiceHistory.add(i);
        }
    }

    public LinkedList<Integer> getPreviousMChoices() throws InsufficientHistoryException {
        if (choiceHistory.size() < choiceHistoryLength) {
            throw new InsufficientHistoryException();
        }
        return this.choiceHistory;
    }

    public boolean isShorterThanM() {
        return this.choiceHistory.size() < this.choiceHistoryLength;
    }

    public int getChoiceHistoryLength() {
        return this.choiceHistoryLength;
    }
}
