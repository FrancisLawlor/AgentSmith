package statemachine.states;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import agents.AgentSystemInitialiser;
import filemanagement.utils.FileResources;
import filemanagement.utils.FileSelectionUtility;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
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
		this.sceneContainerStage.setTitle(GUIText.SELECT_FILE);
		
		File resultFile = chooseSaveLocation();
		
		if (resultFile != null) {
			fileSelected(resultFile.getPath());
		} else {
			cancelledFileSelection();
		}
	}
	
	private File chooseSaveLocation() {		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(FileResources.SAVE_FILE_DESCRIPTION, FileResources.JSON_EXTENSION));
		fileChooser.setTitle(GUIText.SELECT_FILE);
		File file = fileChooser.showSaveDialog(this.sceneContainerStage);
		
        if (file != null) {
            return file;
        }
		
        return null;		
	}
	
	private void fileSelected(String path) {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		String[] params = {gsonUtility.toJson(this.GUITournamentData.getTournamentData()), path};
		
		stateMachine.setCurrentState(StateName.TOURNAMENT_PLAYING);
		stateMachine.execute(StateParameters.INIT);
		
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				AgentSystemInitialiser.main(params);
				return null;
			}
		};
		task.setOnSucceeded(e -> {
			this.stateMachine.setCurrentState(StateName.DASHBOARD);
			this.stateMachine.execute(StateParameters.INIT);
			System.out.println("These are results");
		});
		new Thread(task).start();
		
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.RETURN);
	}

	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.RETURN);	
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
