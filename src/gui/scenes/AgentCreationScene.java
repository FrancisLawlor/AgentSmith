package gui.scenes;

import gui.panes.AgentCreationPane;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

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
	
	public MenuButton getStrategyMenuButton() {
		return this.agentCreationPane.getStrategyMenuButton();
	}
	
	public TextField getNameTextField() {
		return this.agentCreationPane.getNameTextField();
	}
	
	public ObservableList<AdditionalParameter> getAdditionalParameters() {
		return this.agentCreationPane.getAdditionalParameters();
	}
}
