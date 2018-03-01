package tournament.data;

public class RoundData {
	private GameData game;
	private int amount;
	
	public RoundData(GameData game, int amount) {
		this.game = game;
		this.amount = amount;
	}

	public GameData getGame() {
		return this.game;
	}
	
	public int getAmount() {
		return this.amount;
	}
}
