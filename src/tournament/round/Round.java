package tournament.round;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import games.core.Game;

public class Round {
	private Game game;
	
	public Round(String name, HashMap<String, String> additionalParameters) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> newGame = Class.forName(name);
		Object[] parameters = {additionalParameters};
		Class<?>[] types = {new HashMap<String, String>().getClass()};
		Constructor<?> constructor = newGame.getConstructor(types);
		this.game = (Game) constructor.newInstance(parameters);
	}
	
	public Game getGame() {
		return this.game;
	}
}
