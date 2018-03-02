package statemachine.states;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import filemanagement.jarloader.JarLoader;
import filemanagement.utils.FileSelectionUtility;
import games.core.IGame;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import gui.utils.InputValidator;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		this.sceneContainerStage.setTitle(GUIText.SELECT_FILE);
		
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
		
		try {
			IGame game = (IGame) JarLoader.loadGame(path);
			this.gui.getRoundCreationScene().getAdditionalGameParameters().clear();
			
			for (int i = 0; i < game.getAdditionalParameterNames().length; i++) {
				this.gui.getRoundCreationScene().getAdditionalGameParameters().add(
						new AdditionalParameter(new Label(game.getAdditionalParameterNames()[i]), new TextField()));
			}
			
			if (this.gui.getRoundCreationScene().getCenterPane().getChildren().size() > GUIDimensions.CENTER_PANE_LENGTH) {
				this.gui.getRoundCreationScene().getCenterPane().getChildren().remove(this.gui.getRoundCreationScene().getCenterPane().getChildren().size() - 1);
			}
			this.gui.getRoundCreationScene().updateAdditionalParameterTextFields();
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.stateMachine.setCurrentState(StateName.ROUND_CREATION);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void clickCreateRound() {
		ArrayList<AdditionalParameterData> additionalParameters = new ArrayList<AdditionalParameterData>();
		String gameName = gui.getRoundCreationScene().getGameTextField().getText();
		GameData newGameData = new GameData(gameName, additionalParameters);
		
		for (AdditionalParameter additionalParameter: this.gui.getRoundCreationScene().getAdditionalGameParameters()) {
			newGameData.getAdditionalParameters().add(new AdditionalParameterData(
					additionalParameter.getLabel().getText(), additionalParameter.getTextField().getText()));
		}
		
		int amount = 0;
		
		if (!InputValidator.isEmptyString(gui.getRoundCreationScene().getAmountTextField().getText())) {
			if (InputValidator.isValidInteger(gui.getRoundCreationScene().getAmountTextField().getText())) {
				amount = Integer.parseInt(gui.getRoundCreationScene().getAmountTextField().getText());
			}
		}
		
		this.GUITournamentData.getTournamentData().getRounds().add(new RoundData(newGameData, amount));
		
		try {
			
			this.gui.updateTournamentData(this.GUITournamentData.getTournamentData());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		clearRoundInputData();

		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void clickBack() {
		clearRoundInputData();

		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void init() {
		this.sceneContainerStage.changeScene(gui.getRoundCreationScene());
		this.sceneContainerStage.setTitle(GUIText.CREATE_ROUND_HEADING);	
	}
	
	private void clearRoundInputData() {
		this.gui.getRoundCreationScene().getAmountTextField().setText("");
		this.gui.getRoundCreationScene().getGameTextField().setText("");
		
		if (this.gui.getRoundCreationScene().getCenterPane().getChildren().size() > GUIDimensions.CENTER_PANE_LENGTH) {
			this.gui.getRoundCreationScene().getCenterPane().getChildren().remove(this.gui.getRoundCreationScene().getCenterPane().getChildren().size() - 1);
		}		
	}
}
