package statemachine.states;


import java.lang.reflect.InvocationTargetException;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.player.Player;
import tournament.round.Round;

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
				try {
					init();
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
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
		this.stateMachine.setCurrentState(StateName.TOURNAMENT_PLAYING);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void clickAddRound() {
		this.stateMachine.setCurrentState(StateName.ROUND_CREATION);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void clickCreateAgent() {
		this.stateMachine.setCurrentState(StateName.AGENT_CREATION);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void init() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.sceneContainerStage.changeScene(gui.getDashBoardScene());
		this.sceneContainerStage.setTitle(GUIText.DASHBOARD);	
		
		this.gui.getDashBoardScene().getAgentListView().getItems().add(new Player(null, null, null));
		this.gui.getDashBoardScene().getRoundListView().getItems().add(new Round(null, null));
	}

	private void clickLoad() {
		this.stateMachine.setCurrentState(StateName.LOADING_TOURNAMENT);
		this.stateMachine.execute(StateParameters.INIT);
	}
	
	private void clickSave() {
		this.stateMachine.setCurrentState(StateName.SAVING_TOURNAMENT);
		this.stateMachine.execute(StateParameters.INIT);
	}
}
