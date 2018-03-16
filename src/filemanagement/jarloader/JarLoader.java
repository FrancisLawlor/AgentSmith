package filemanagement.jarloader;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

import games.core.GamesResources;
import games.core.IGame;
import strategies.core.IStrategy;
import strategies.core.StrategiesResources;

public class JarLoader {
	public static IStrategy loadStrategy(String jarPath, HashMap<String, String> additionalParameters) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		File jarFile = new File(jarPath);   
		String className = StrategiesResources.JAR_CLASS_NAME;   
		URL jarfile = new URL("jar", "","file:" + jarFile.getAbsolutePath()+"!/");    
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {jarfile });   
		Class<?> loadedClass = classLoader.loadClass(className);
		Object[] parameters = {additionalParameters};
		Class<?>[] types = {new HashMap<String, String>().getClass()};
		Constructor<?> constructor = loadedClass.getConstructor(types);
		IStrategy strategy = (IStrategy) constructor.newInstance(parameters);
		
		return strategy;
	}
	
	public static IGame loadGame(String jarPath, HashMap<String, String> additionalParameters) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		File jarFile = new File(jarPath);   
		String className = GamesResources.JAR_CLASS_NAME;   
		URL jarfile = new URL("jar", "","file:" + jarFile.getAbsolutePath()+"!/");    
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] {jarfile });   
		Class<?> loadedClass = classLoader.loadClass(className);
		Object[] parameters = {additionalParameters};
		Class<?>[] types = {new HashMap<String, String>().getClass()};
		Constructor<?> constructor = loadedClass.getConstructor(types);
		IGame game = (IGame) constructor.newInstance(parameters);
		
		return game;
	}
}
