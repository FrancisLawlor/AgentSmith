package tournament.core;

import java.util.ArrayList;

import agents.info.AgentInfo;
import tournament.rounds.Round;

public class Tournament {
	private ArrayList<AgentInfo> agents;
	private ArrayList<Round> rounds;
	
	public Tournament(ArrayList<AgentInfo> agents, ArrayList<Round> rounds) {
		this.agents = agents;
		this.rounds = rounds;
	}
	
	public ArrayList<AgentInfo> getAgents() {
		return this.agents;
	}
	
	public ArrayList<Round> getRounds() {
		return this.rounds;
	}

}
