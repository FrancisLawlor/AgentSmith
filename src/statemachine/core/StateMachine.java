package statemachine.core;

import java.util.HashMap;
import java.util.Map;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentData;
import tournament.data.TournamentDataWrapper;
import statemachine.states.AgentCreationState;
import statemachine.states.DashboardState;
import statemachine.states.LoadTournamentFileState;
import statemachine.states.RoundCreationState;
import statemachine.states.SaveTournamentFileState;
import statemachine.states.StartState;
import statemachine.states.State;
import statemachine.states.TournamentPhaseState;
import statemachine.states.TournamentPlayingState;

public class StateMachine {
	private StateName currentState;
	private Map<StateName, State> stateMap = new HashMap<StateName, State>();
	private SceneContainerStage containerStage = new SceneContainerStage();
	private GUI gui = new GUI(containerStage);
	private TournamentDataWrapper GUITournamentData = new TournamentDataWrapper(new TournamentData());
	
	public StateMachine() {
		stateMap.put(StateName.START, new StartState(this, this.containerStage, this.gui));
		stateMap.put(StateName.DASHBOARD, new DashboardState(this, this.containerStage, this.gui, this.GUITournamentData));
		stateMap.put(StateName.AGENT_CREATION, new AgentCreationState(this, this.containerStage, this.gui, this.GUITournamentData));
		stateMap.put(StateName.ROUND_CREATION, new RoundCreationState(this, this.containerStage, this.gui, this.GUITournamentData));
		stateMap.put(StateName.TOURNAMENT_PLAYING, new TournamentPlayingState(this, this.containerStage, this.gui));
		stateMap.put(StateName.TOURNAMENT_PHASE, new TournamentPhaseState(this, this.containerStage, this.gui));
		stateMap.put(StateName.LOADING_TOURNAMENT, new LoadTournamentFileState(this, this.containerStage, this.gui, this.GUITournamentData));
		stateMap.put(StateName.SAVING_TOURNAMENT, new SaveTournamentFileState(this, this.containerStage, this.GUITournamentData));
	}
	
	public void setCurrentState(StateName newState) {
		currentState = newState;
	}
	
	public void execute(StateParameters param) {
		stateMap.get(currentState).execute(param);
	}
}
