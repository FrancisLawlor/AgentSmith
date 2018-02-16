package games;

public abstract class Game {
	private String id;
	
	public Game(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
}
