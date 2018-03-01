package statemachine.states;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import filemanagement.jarloader.JarLoader;
import filemanagement.utils.FileSelectionUtility;
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
import strategies.core.IStrategy;
import tournament.data.AdditionalParameterData;
import tournament.data.AgentData;
import tournament.data.StrategyData;
import tournament.data.TournamentDataWrapper;

public class AgentCreationState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TournamentDataWrapper GUITournamentData;
	
	public AgentCreationState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUITournamentData) {
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
			case CLICK_CREATE_AGENT:
				clickCreateAgent();
				break;
			case CLICK_BROWSE_STRATEGIES:
				clickBrowseStrategies();
				break;
			case RETURN:
				break;
			default:
				break;
		}
	}

	private void clickBrowseStrategies() {
		this.sceneContainerStage.setTitle(GUIText.SELECT_FILE);
		
		File strategyFile = FileSelectionUtility.chooseFile(this.sceneContainerStage);
		
		if (strategyFile != null) {
			fileSelected(strategyFile.getPath());
		} else {
			cancelledFileSelection();
		}
	}

	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.AGENT_CREATION);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void fileSelected(String path) {
		this.gui.getAgentCreationScene().getStrategyTextField().setText(path);
		
		try {
			IStrategy strategy = (IStrategy) JarLoader.loadStrategy(path);
			this.gui.getAgentCreationScene().getAdditionalParameters().clear();
			
			for (int i = 0; i < strategy.getAdditionalParameterNames().length; i++) {
				this.gui.getAgentCreationScene().getAdditionalParameters().add(
						new AdditionalParameter(new Label(strategy.getAdditionalParameterNames()[i]), new TextField()));
			}
			
			if (this.gui.getAgentCreationScene().getCenterPane().getChildren().size() > GUIDimensions.CENTER_PANE_LENGTH) {
				this.gui.getAgentCreationScene().getCenterPane().getChildren().remove(this.gui.getAgentCreationScene().getCenterPane().getChildren().size() - 1);
			}
			this.gui.getAgentCreationScene().updateAdditionalParameterTextFields();
		} catch (MalformedURLException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		this.stateMachine.setCurrentState(StateName.AGENT_CREATION);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void clickCreateAgent() {		
		ArrayList<AdditionalParameterData> additionalParameters = new ArrayList<AdditionalParameterData>();
		String strategyName = this.gui.getAgentCreationScene().getStrategyTextField().getText();
		StrategyData newStrategyData = new StrategyData(strategyName, additionalParameters);
		
		for (AdditionalParameter additionalParameter: this.gui.getAgentCreationScene().getAdditionalParameters()) {
			newStrategyData.getAdditionalParameters().add(new AdditionalParameterData(
					additionalParameter.getLabel().getText(), additionalParameter.getTextField().getText()));
		}
		
		int amount = 0;
		
		if (!InputValidator.isEmptyString(gui.getAgentCreationScene().getAmountTextField().getText())) {
			if (InputValidator.isValidInteger(gui.getAgentCreationScene().getAmountTextField().getText())) {
				amount = Integer.parseInt(gui.getAgentCreationScene().getAmountTextField().getText());
			}
		}
		
		this.GUITournamentData.getTournamentData().getAgents().add(new AgentData(newStrategyData, amount));
		
		try {
			this.gui.updateTournamentData(this.GUITournamentData.getTournamentData());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		clearAgentInputData();
		
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void clickBack() {
		clearAgentInputData();

		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private void init() {
		sceneContainerStage.changeScene(gui.getAgentCreationScene());
		sceneContainerStage.setTitle(GUIText.CREATE_AGENT_HEADING);	
	}
	
	private void clearAgentInputData() {
		this.gui.getAgentCreationScene().getAmountTextField().setText("");
		this.gui.getAgentCreationScene().getStrategyTextField().setText("");
		
		if (this.gui.getAgentCreationScene().getCenterPane().getChildren().size() > GUIDimensions.CENTER_PANE_LENGTH) {
			this.gui.getAgentCreationScene().getCenterPane().getChildren().remove(this.gui.getAgentCreationScene().getCenterPane().getChildren().size() - 1);
		}		
	}
}
