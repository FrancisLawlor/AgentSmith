package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.concurrent.Task;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Text;
import statemachine.core.StateMachine;
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
			default:
				break;
		}
	}

	private void clicksContinue() {
		System.out.println("continue");
	}

	private void init() {
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);
		
		// TODO Put current phase data in ScrollPane Text
		// Placeholder code:
		
		this.gui.getTournamentPhaseScene().getPhaseDataText().setText("Current round data goes here.");
	}
}
