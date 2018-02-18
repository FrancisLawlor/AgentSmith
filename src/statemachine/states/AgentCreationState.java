package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;

public class AgentCreationState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public AgentCreationState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
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
		// Extract agent info from fields
		// Add new agent to agent listview.
	}

	private void clickBack() {
		stateMachine.setCurrentState(StateName.DASHBOARD);
		stateMachine.execute(StateParameters.INIT);
	}

	private void init() {
		sceneContainerStage.changeScene(gui.getAgentCreationScene());
		sceneContainerStage.setTitle(GUIText.CREATE_AGENT_HEADING);	
	}
}
