package gui.scenes;

import gui.panes.AgentCreationPane;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AgentCreationScene extends Scene {
	AgentCreationPane agentCreationPane;
	
	public AgentCreationScene(AgentCreationPane agentCreationPane) {
		super(agentCreationPane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
		this.agentCreationPane = agentCreationPane;
	}
	
	public Button getBackButton() {
		return this.agentCreationPane.getBackButton();
	}
	
	public Button getCreateAgentButton() {
		return this.agentCreationPane.getCreateAgentButton();
	}
	
	public TextField getStrategyTextField() {
		return this.agentCreationPane.getStrategyTextField();
	}
	
	public ObservableList<AdditionalParameter> getAdditionalParameters() {
		return this.agentCreationPane.getAdditionalParameters();
	}
	
	public Button getBrowseStrategyButton() {
		return this.agentCreationPane.getBrowseStrategyButton();
	}
	
	public TextField getAmountTextField() {
		return this.agentCreationPane.getAmountTextField();
	}
	
	public void updateAdditionalParameterTextFields() {
		this.agentCreationPane.updateAdditionalParameterTextFields();;
	}

	public VBox getCenterPane() {
		return this.agentCreationPane.getCenterPane();
	}
}
