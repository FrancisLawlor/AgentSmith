package statemachine.core;

import java.util.HashMap;
import java.util.Map;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import statemachine.states.AgentCreationState;
import statemachine.states.DashboardState;
import statemachine.states.RoundCreationState;
import statemachine.states.StartState;
import statemachine.states.State;
import statemachine.states.TournamentPlayingState;

public class StateMachine {
	private StateName currentState;
	private Map<StateName, State> stateMap = new HashMap<StateName, State>();
	private SceneContainerStage containerStage = new SceneContainerStage();
	private GUI gui = new GUI(containerStage);
	
	public StateMachine() {
		stateMap.put(StateName.START, new StartState(this, containerStage, gui));
		stateMap.put(StateName.DASHBOARD, new DashboardState(this, containerStage, gui));
		stateMap.put(StateName.AGENT_CREATION, new AgentCreationState(this, containerStage, gui));
		stateMap.put(StateName.ROUND_CREATION, new RoundCreationState(this, containerStage, gui));
		stateMap.put(StateName.TOURNAMENT_PLAYING, new TournamentPlayingState(this, containerStage, gui));
	}
	
	public void setCurrentState(StateName newState) {
		currentState = newState;
	}
	
	public void execute(StateParameters param) {
		stateMap.get(currentState).execute(param);
	}
}
