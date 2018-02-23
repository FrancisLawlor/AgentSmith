package tournament.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cartago.Artifact;
import cartago.OPERATION;

public class TournamentConfigurator extends Artifact {
	private Tournament tournament;
	private static Object lock = new Object();
	
	@OPERATION
	public void configureTournament(String configFilePath) throws IOException {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(configFilePath));
		String tournamentJsonString = bufferedReader.readLine();		
		bufferedReader.close();
		
		this.tournament =  gsonUtility.fromJson(tournamentJsonString, Tournament.class);
	}
	
	@OPERATION
	public void getNumberOfRounds() {
		synchronized (lock) {
			signal("numberOfRounds", tournament.getRounds().size());
		}
	}
	
	@OPERATION
	public void createAgents() {
		synchronized (lock) {
			for (int i = 0; i < tournament.getAgents().size(); i++) {
				System.out.println("strategy: " + tournament.getAgents().get(i).getStrategy());
				signal("createAgent", tournament.getAgents().get(i).getId(), tournament.getAgents().get(i).getStrategy());
			}
		}
	}

	public Tournament getTournament() {
		return this.tournament;
	}
}
