package statemachine.states;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.eventhandlers.ListViewEventHandler;
import statemachine.eventhandlers.StateMachineEventHandler;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;

public class StartState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public StartState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		
		configureButtons();
				
		sceneContainerStage.setOnHiding(event -> {
			System.exit(0);
		});
	}
	
	private void configureButtons() {
		gui.getDashBoardScene().getLoadTournamentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_LOAD, stateMachine));
		gui.getDashBoardScene().getSaveTournamentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_SAVE, stateMachine));
		gui.getDashBoardScene().getAddAgentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_CREATE_AGENT, stateMachine));
		gui.getDashBoardScene().getAddRoundButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_ADD_ROUND, stateMachine));
		gui.getDashBoardScene().getPlayButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_START_TOURNAMENT, stateMachine));
		gui.getDashBoardScene().getAgentListView().setOnMousePressed(new ListViewEventHandler(StateParameters.CLICK_AGENTS_LISTVIEW, stateMachine));
		gui.getDashBoardScene().getRoundListView().setOnMousePressed(new ListViewEventHandler(StateParameters.CLICK_ROUNDS_LISTVIEW, stateMachine));
		gui.getAgentCreationScene().getBackButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_BACK, stateMachine));
		gui.getAgentCreationScene().getCreateAgentButton().setOnAction(new StateMachineEventHandler(StateParameters.CREATE_AGENT, stateMachine));
		gui.getRoundCreationScene().getBackButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_BACK, stateMachine));
		gui.getRoundCreationScene().getCreateRoundButton().setOnAction(new StateMachineEventHandler(StateParameters.CREATE_ROUND, stateMachine));
	}

	@Override
	public void execute(StateParameters param) {
//		String[] params = {};
//		TournamentConfigurator.main(params);
		stateMachine.setCurrentState(StateName.DASHBOARD);
		sceneContainerStage.setTitle(GUIText.DASHBOARD);
		stateMachine.execute(StateParameters.INIT);
		sceneContainerStage.show();
	}
}
