package statemachine.states;

import agents.info.AgentInfo;
import games.minoritygame.MinorityGame;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.rounds.Round;

public class DashboardState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public DashboardState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case CLICK_LOAD:
				clickLoad();
				break;
			case CLICK_SAVE:
				clickSave();
				break;
			case CLICK_CREATE_AGENT:
				clickCreateAgent();
				break;
			case CLICK_ADD_ROUND:
				clickAddRound();
				break;
			case CLICK_START_TOURNAMENT:
				clickStartTournament();
				break;
			default:
				break;
		}
	}

	private void clickStartTournament() {
		stateMachine.setCurrentState(StateName.TOURNAMENT_PLAYING);
		stateMachine.execute(StateParameters.INIT);
	}

	private void clickAddRound() {
		stateMachine.setCurrentState(StateName.ROUND_CREATION);
		stateMachine.execute(StateParameters.INIT);
	}

	private void clickCreateAgent() {
		stateMachine.setCurrentState(StateName.AGENT_CREATION);
		stateMachine.execute(StateParameters.INIT);
	}

	private void init() {
		sceneContainerStage.changeScene(gui.getDashBoardScene());
		sceneContainerStage.setTitle(GUIText.DASHBOARD);	
		
		gui.getDashBoardScene().getAgentListView().getItems().add(new AgentInfo("james", "bestplay"));
		gui.getDashBoardScene().getRoundListView().getItems().add(new Round(new MinorityGame("game")));
	}

	private void clickLoad() {
		stateMachine.setCurrentState(StateName.LOADING_TOURNAMENT);
		stateMachine.execute(StateParameters.INIT);
	}
	
	private void clickSave() {
		stateMachine.setCurrentState(StateName.SAVING_TOURNAMENT);
		stateMachine.execute(StateParameters.INIT);
	}
}
