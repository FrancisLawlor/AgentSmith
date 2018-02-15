package statemachine.core;

import java.util.HashMap;
import java.util.Map;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import statemachine.utils.StateName;
import statemachine.states.DashboardState;
import statemachine.states.StartState;
import statemachine.states.State;

public class StateMachine {
	private String currentState;
	private Map<String, State> stateMap = new HashMap<String, State>();
	private SceneContainerStage containerStage = new SceneContainerStage();
	private GUI gui = new GUI(containerStage);
	
	public StateMachine() {
		stateMap.put(StateName.START.toString(), new StartState(this, containerStage, gui));
		stateMap.put(StateName.DASHBOARD.toString(), new DashboardState(this, containerStage, gui));
	}
	
	public void setCurrentState(String newState) {
		currentState = newState;
	}
	
	public void execute(StateName param) {
		stateMap.get(currentState).execute(param);
	}
}
