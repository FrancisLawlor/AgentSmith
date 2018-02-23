package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.concurrent.Task;
import statemachine.core.StateMachine;
import statemachine.utils.StateParameters;

public class TournamentPlayingState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public TournamentPlayingState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			default:
				break;
		}
	}

	private void init() {
		sceneContainerStage.changeScene(gui.getTournamentPlayingScene());
		sceneContainerStage.setTitle(GUIText.CREATE_ROUND_HEADING);
		
		// Start the agent system.
		// Wait for it to finish.
		// Change to result state when finished.
		
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				Thread.sleep(2000);
				return null;
			}
		};
		task.setOnSucceeded(e -> {
			System.out.println("These are results");
		});
		new Thread(task).start();
	}
}
