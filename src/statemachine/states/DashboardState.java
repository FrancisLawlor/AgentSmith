package statemachine.states;


import java.lang.reflect.InvocationTargetException;

import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentDataWrapper;

public class DashboardState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TournamentDataWrapper GUITournamentData;
	
	public DashboardState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUITournamentData) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.GUITournamentData = GUITournamentData;
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
			case CLICK_CLEAR_AGENTS:
				clickClearAgents();
				break;
			case CLICK_REMOVE_SELECTED_AGENT:
				clickRemoveSelectedAgent();
				break;
			case CLICK_ADD_ROUND:
				clickAddRound();
				break;
			case CLICK_CLEAR_ROUNDS:
				clickClearRounds();
				break;
			case CLICK_REMOVE_SELECTED_ROUND:
				clickRemoveSelectedRound();
				break;
			case CLICK_ROUNDS_LISTVIEW:
				clickRoundsListView();
				break;
			case CLICK_START_TOURNAMENT:
				clickStartTournament();
				break;
			default:
				break;
		}
	}
	
	private void clickRemoveSelectedRound() {
		if (gui.getDashBoardScene().getRoundListView().getSelectionModel().getSelectedItem() != null) {
			int removalIndex = gui.getDashBoardScene().getRoundListView().getSelectionModel().getSelectedIndex();
			this.GUITournamentData.getTournamentData().getRounds().remove(removalIndex);
			
			try {
				this.gui.updateTournamentData(GUITournamentData.getTournamentData());
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	private void clickRemoveSelectedAgent() {
		if (gui.getDashBoardScene().getAgentListView().getSelectionModel().getSelectedItem() != null) {
			int removalIndex = gui.getDashBoardScene().getAgentListView().getSelectionModel().getSelectedIndex();
			this.GUITournamentData.getTournamentData().getAgents().remove(removalIndex);
			
			try {
				this.gui.updateTournamentData(GUITournamentData.getTournamentData());
			} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
					| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

	private void clickRoundsListView() {
//		int removalIndex = gui.getDashBoardScene().getRoundListView().getSelectionModel().getSelectedIndex();
//		this.GUITournamentData.getTournamentData().getRounds().remove(removalIndex);
//		
//		try {
//			this.gui.updateTournamentData(GUITournamentData.getTournamentData());
//		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
//				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
	}

//    Recommendation recommendation = gui.getDashBoardScene().getListView().getSelectionModel().getSelectedItem();

	private void clickClearAgents() {
		this.GUITournamentData.getTournamentData().getAgents().clear();
		try {
			this.gui.updateTournamentData(GUITournamentData.getTournamentData());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private void clickClearRounds() {
		this.GUITournamentData.getTournamentData().getRounds().clear();
		try {
			this.gui.updateTournamentData(GUITournamentData.getTournamentData());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
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
