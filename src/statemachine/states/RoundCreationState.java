package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;

public class RoundCreationState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public RoundCreationState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case CLICK_BACK:
				clickBack();
				break;
			case CLICK_CREATE_AGENT:
				clickCreateAgent();
				break;
			default:
				break;
		}
	}

	private void clickCreateAgent() {
		// TODO Auto-generated method stub
		// Extract round info from fields
		// Add new round to round listview.
	}

	private void clickBack() {
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void init() {
		this.sceneContainerStage.changeScene(gui.getRoundCreationScene());
		this.sceneContainerStage.setTitle(GUIText.CREATE_ROUND_HEADING);	
	}
}
