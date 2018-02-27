package games.core;

import java.util.Map;

public abstract class Game {
	public Game(Map<String, String> additionalParameters) {}
	public abstract Map<String, Float> play(Map<String, Integer> playerGuesses);
	public abstract int getWinningChoice(Map<String, Integer> playerGuesses);
	public abstract int getNumberOfOptions();
	public abstract Map<String, Integer> getUpdateStrategyData(Map<String, Integer> input);
}

