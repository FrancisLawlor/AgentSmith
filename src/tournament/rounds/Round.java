package tournament.rounds;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import games.core.Game;

public class Round {
	private String gameName;
	private Game game;
	
	public void init() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		Class<?> newGame = Class.forName(this.gameName);
		Constructor<?> constructor = newGame.getConstructor();
		this.game = (Game) constructor.newInstance();
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public String getGameName() {
		return this.gameName;
	}
}
