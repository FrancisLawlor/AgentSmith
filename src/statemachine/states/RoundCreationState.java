package statemachine.states;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import filemanagement.utils.FileSelectionUtility;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import gui.utils.InputValidator;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.AdditionalParameterData;
import tournament.data.GameData;
import tournament.data.RoundData;
import tournament.data.TournamentDataWrapper;

public class RoundCreationState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TournamentDataWrapper GUITournamentData;
	
	public RoundCreationState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUITournamentData) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.GUITournamentData = GUITournamentData;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case CLICK_BACK:
				clickBack();
				break;
			case CLICK_CREATE_ROUND:
				clickCreateRound();
				break;
			case CLICK_BROWSE_GAMES:
				clickBrowseGames();
				break;
			case RETURN:
				break;
			default:
				break;
		}
	}


	private void clickBrowseGames() {
		this.sceneContainerStage.setTitle(GUIText.LOAD_TOURNAMENT);
		
		File gameFile = FileSelectionUtility.chooseFile(this.sceneContainerStage);
		
		if (gameFile != null) {
			fileSelected(gameFile.getPath());
		} else {
			cancelledFileSelection();
		}
	}

	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.ROUND_CREATION);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void fileSelected(String path) {
		this.gui.getRoundCreationScene().getGameTextField().setText(path);
		
		this.stateMachine.setCurrentState(StateName.ROUND_CREATION);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void clickCreateRound() {
		// TODO
		// Store additional parameters in GUITournamentData
		
		ArrayList<AdditionalParameterData> additionalParameters = new ArrayList<AdditionalParameterData>();
		String gameName = gui.getRoundCreationScene().getGameTextField().getText();
		GameData newGameData = new GameData(gameName, additionalParameters);
		
		int amount = 0;
		
		if (InputValidator.isValidInteger(gui.getRoundCreationScene().getAmountTextField().getText())) {
			amount = Integer.parseInt(gui.getRoundCreationScene().getAmountTextField().getText());
		}
		
		this.GUITournamentData.getTournamentData().getRounds().add(new RoundData(newGameData, amount));
		try {
			
			this.gui.updateTournamentData(this.GUITournamentData.getTournamentData());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
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
