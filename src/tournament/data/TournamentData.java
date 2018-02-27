package tournament.data;

import java.util.ArrayList;

public class TournamentData {
	private ArrayList<RoundData> rounds = new ArrayList<RoundData>();
	private ArrayList<AgentData> agents = new ArrayList<AgentData>();
	
	public ArrayList<RoundData> getRounds() {
		return this.rounds;
	}
	
	public ArrayList<AgentData> getAgents() {
		return this.agents;
	}
}
