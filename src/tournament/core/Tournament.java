package tournament.core;

import java.util.ArrayList;

import tournament.player.Player;
import tournament.round.Round;

public class Tournament {
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Round> rounds = new ArrayList<Round>();
	
	public ArrayList<Player> getAgents() {
		return this.players;
	}
	
	public ArrayList<Round> getRounds() {
		return this.rounds;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Players: \n\n");
		
		for (int i = 0; i < this.players.size(); i++) {
			stringBuilder.append(this.players.get(i).getId() + " " + players.get(i).getStrategy() + "\n");
		}
		
		stringBuilder.append("\nRounds: \n\n");
		
		for (int i = 0; i < this.rounds.size(); i++) {
			stringBuilder.append(i + " " + this.rounds.get(i).getGame() + "\n");
		}
		
		return stringBuilder.toString();
	}
}