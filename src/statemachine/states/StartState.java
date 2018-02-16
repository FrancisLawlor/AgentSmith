package statemachine.states;

import agents.TournamentConfigurator;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;

public class StartState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public StartState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
				
		sceneContainerStage.setOnHiding(event -> {
			System.exit(0);
		});
	}

	@Override
	public void execute(StateName param) {
		String[] params = {};
		TournamentConfigurator.main(params);
		stateMachine.setCurrentState(StateName.DASHBOARD.toString());
		sceneContainerStage.setTitle(GUIText.DASHBOARD);
		stateMachine.execute(StateName.INIT);
		sceneContainerStage.show();
	}
}
