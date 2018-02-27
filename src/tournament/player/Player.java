package tournament.player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import strategies.core.Strategy;

public class Player {
	private String id;
	private Strategy strategy;
	
	public Player(String id, String strategyName, HashMap<String, String> additionalParameters) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.id = id;
		
		Class<?> newStrategy = Class.forName(strategyName);
		Object[] parameters = {additionalParameters};
		Class<?>[] types = {new HashMap<String, String>().getClass()};
		Constructor<?> constructor = newStrategy.getConstructor(types);
		this.strategy = (Strategy) constructor.newInstance(parameters);
	}
	
	public Strategy getStrategy() {
		return this.strategy;
	}
	
	public String getId() {
		return this.id;
	}
}
