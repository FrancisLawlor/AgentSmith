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
		this.gui.getDashBoardScene().getLoadTournamentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_LOAD, stateMachine));
		this.gui.getDashBoardScene().getSaveTournamentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_SAVE, stateMachine));
		this.gui.getDashBoardScene().getAddAgentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_CREATE_AGENT, stateMachine));
		this.gui.getDashBoardScene().getAddRoundButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_ADD_ROUND, stateMachine));
		this.gui.getDashBoardScene().getClearAgentsButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_CLEAR_AGENTS, stateMachine));
		this.gui.getDashBoardScene().getClearRoundsButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_CLEAR_ROUNDS, stateMachine));
		this.gui.getDashBoardScene().getPlayButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_START_TOURNAMENT, stateMachine));
		this.gui.getDashBoardScene().getRemoveSelectedAgentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_REMOVE_SELECTED_AGENT, stateMachine));
		this.gui.getDashBoardScene().getRemoveSelectedRoundButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_REMOVE_SELECTED_ROUND, stateMachine));
		this.gui.getDashBoardScene().getAgentListView().setOnMousePressed(new ListViewEventHandler(StateParameters.CLICK_AGENTS_LISTVIEW, stateMachine));
		this.gui.getDashBoardScene().getRoundListView().setOnMousePressed(new ListViewEventHandler(StateParameters.CLICK_ROUNDS_LISTVIEW, stateMachine));
		this.gui.getAgentCreationScene().getBackButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_BACK, stateMachine));
		this.gui.getAgentCreationScene().getCreateAgentButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_CREATE_AGENT, stateMachine));
		this.gui.getAgentCreationScene().getBrowseStrategyButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_BROWSE_STRATEGIES, stateMachine));
		this.gui.getRoundCreationScene().getBackButton().setOnAction(new StateMachineEventHandler(StateParameters.CLICK_BACK, stateMachine));
		this.gui.getRoundCreationScene().getCreateRoundButton().setOnAction(new StateMachineEventHandler(StateParameters.CREATE_ROUND, stateMachine));
	}

	@Override
	public void execute(StateParameters param) {
//		String[] params = {};
//		TournamentConfigurator.main(params);
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.sceneContainerStage.setTitle(GUIText.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
		this.sceneContainerStage.show();
	}
}
