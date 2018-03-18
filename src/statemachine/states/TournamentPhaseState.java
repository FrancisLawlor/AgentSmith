package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;

public class TournamentPhaseState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public TournamentPhaseState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case CLICK_CONTINUE:
				clicksContinue();
				break;
			case RETURN:
				phaseFinished();
				break;
			default:
				break;
		}
	}

	private void phaseFinished() {
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);		
	}

	private void clicksContinue() {
		stateMachine.setCurrentState(StateName.TOURNAMENT_PLAYING);
		stateMachine.execute(StateParameters.RETURN);
	}

	private void init() {
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);
		
		// TODO Put current phase data in ScrollPane Text
		// Placeholder code:
		
		this.gui.getTournamentPhaseScene().getPhaseDataText().setText("Current round data goes here.");
	}
}
