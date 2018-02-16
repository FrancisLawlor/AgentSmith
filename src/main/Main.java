package main;

import java.io.IOException;

import tournament.core.TournamentConfigurator;

public class Main {
	public static void main(String[] args) throws IOException {
		TournamentConfigurator tournamentConfigurator = new TournamentConfigurator();
		tournamentConfigurator.configureTournament("configuration/config.json");
		
		System.out.println(tournamentConfigurator.getTournament().getAgents().get(0).getStrategy());
	}
}
