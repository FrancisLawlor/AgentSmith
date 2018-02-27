package tournament.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import cartago.Artifact;
import cartago.OPERATION;
import tournament.data.TournamentData;


public class TournamentLoaderArtifact extends Artifact {
	private TournamentData tournamentData;
	
	@OPERATION
	public void loadTournament(String configFilePath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(configFilePath));
		String tournamentJsonString = bufferedReader.readLine();
		bufferedReader.close();
		
		signal(TournamentResources.SEND_TOURNAMENT_DATA_AS_JSON_STRING, tournamentJsonString);
	}
	
	@OPERATION
	public void printTournament() {
		System.out.println("Rounds\n");
		for (int i = 0; i < this.tournamentData.getRounds().size(); i++) {
			for (int j = 0; j < this.tournamentData.getRounds().get(i).getAmount(); j++) {
				System.out.println("Game name: " + this.tournamentData.getRounds().get(i).getGame().getName());
				System.out.println("Additional Parameters: ");
				for (int k = 0; k < this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().size(); k++) {
					String name = this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getName();
					String value = this.tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getValue();
					System.out.println("\t" + name + ": " + value);
				}
				
				System.out.println();
			}
		}
		
		System.out.println("Agents\n");

		for (int i = 0; i < this.tournamentData.getAgents().size(); i++) {
			for (int j = 0; j < this.tournamentData.getAgents().get(i).getAmount(); j++) {
				System.out.println("Strategy name: " + this.tournamentData.getAgents().get(i).getStrategyData().getName());
				for (int k = 0; k < this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().size(); k++) {
					String name = this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getName();
					String value = this.tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getValue();
					System.out.println("\t" + name + ": " + value);
				}
				
				System.out.println();
			}
		}
	}
}
