package tournament.rounds;

import games.Game;

public class Round {
	private Game game;
	
	public Round(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}
}
