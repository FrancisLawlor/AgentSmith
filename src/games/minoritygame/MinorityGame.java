package games.minoritygame;

import java.util.HashMap;
import java.util.Map;

import games.core.Game;

public class MinorityGame extends Game {
	private static final int NUMBER_OF_OPTIONS = 2;
	private static final String WINNING_CHOICE = "winning_choice";
	
	public MinorityGame() {
		
	}
	
	public Map<String, Float> play(Map<String, Integer> playerGuesses) {
		if (playerGuesses == null) {
			return null;
		}
				
		Map<String, Float> resultMap = new HashMap<String, Float>();
		int totalAction = getTotalAction(playerGuesses);
				
		for (String playerId: playerGuesses.keySet()) {
			resultMap.put(playerId, getIndividualPayoff(playerGuesses.get(playerId), totalAction, playerGuesses.size()));
		}
		
		return resultMap;
	}
	
	public int getWinningChoice(Map<String, Integer> playerGuesses) {
		int plusOnes = 0;
		int minusOnes = 0;
		
		for (String playerId: playerGuesses.keySet()) {
			if (playerGuesses.get(playerId) == -1) {
				minusOnes++;
			} else {
				plusOnes++;
			}
		}
		
		return plusOnes < minusOnes ? 1 : -1;
	}
	
	private static int getTotalAction(Map<String, Integer> playerGuesses) {
        int totalAction = 0;

        for (String playerId: playerGuesses.keySet()) {
			totalAction += playerGuesses.get(playerId);
		}

        return totalAction;
    }
	
	/*
	 * Payoff = -a_i * g[A(t)]
	 * g(x) = x / N
	 */
	private static float getIndividualPayoff(int playerAction, int totalAction, int numberOfPlayers) {
		return (-playerAction) * ((float) totalAction / numberOfPlayers);
	}

	@Override
	public int getNumberOfOptions() {
		return NUMBER_OF_OPTIONS;
	}

	@Override
	public Map<String, Integer> getUpdateStrategyData(Map<String, Integer> inputData) {
		Map<String, Integer> updateStrategyData = new HashMap<String, Integer>();
		updateStrategyData.put(WINNING_CHOICE, getWinningChoice(inputData));
		
		return updateStrategyData;
	}
}
