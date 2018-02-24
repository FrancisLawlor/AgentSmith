package strategies.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cartago.Artifact;
import cartago.OPERATION;
import tournament.core.Tournament;

public class StrategiesArtifact extends Artifact {
	private Map<String, Strategy> playerStrategies = new HashMap<String, Strategy>();
	private static Object lock = new Object();
	private Tournament tournament;

	@OPERATION
	public void populateStrategiesMap(String configFilePath) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(configFilePath));
		String tournamentJsonString = bufferedReader.readLine();		
		bufferedReader.close();
		
		this.tournament = gsonUtility.fromJson(tournamentJsonString, Tournament.class);
		
		for (int i = 0; i < tournament.getAgents().size(); i++) {
			Class<?> strategyClass = Class.forName(tournament.getAgents().get(i).getStrategy());
			Constructor<?> strategyConstructor = strategyClass.getConstructors()[0];
		    Strategy strategy = (Strategy) strategyConstructor.newInstance(new Object[] {2, 8});
			playerStrategies.put(tournament.getAgents().get(i).getId(), strategy);
		}
	}
	
	@OPERATION
	public void getGuess(String agentId, int numberOfOptions) {
		synchronized (lock) {
			signal(StrategiesResources.GENERATED_GUESS, agentId, playerStrategies.get(agentId).generateChoice(null));
		}
	}
	
	@OPERATION
	public void updateStrategy(String agentId, String dataKey, int dataValue) {
		synchronized (lock) {
			playerStrategies.get(agentId).updateStrategy(dataKey, dataValue);
			signal(StrategiesResources.UPDATE_RECEIVED, agentId);
		}
	}
}
