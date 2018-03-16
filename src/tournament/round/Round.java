package tournament.round;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.HashMap;

import filemanagement.jarloader.JarLoader;
import games.core.Game;
import games.core.IGame;
import strategies.core.IStrategy;

public class Round {
	private IGame game;
	
	public Round(String name, HashMap<String, String> additionalParameters) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MalformedURLException {
//		Class<?> newGame = Class.forName(name);
//		Object[] parameters = {additionalParameters};
//		Class<?>[] types = {new HashMap<String, String>().getClass()};
//		Constructor<?> constructor = newGame.getConstructor(types);
//		this.game = (Game) constructor.newInstance(parameters);
		
		this.game = (IGame) JarLoader.loadGame(name, additionalParameters);
	}
	
	public IGame getGame() {
		return this.game;
	}
}
