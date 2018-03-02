package gui.scenes;

import gui.panes.RoundCreationPane;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class RoundCreationScene extends Scene {
	RoundCreationPane roundCreationPane;
	
	public RoundCreationScene(RoundCreationPane roundCreationPane) {
		super(roundCreationPane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
		this.roundCreationPane = roundCreationPane;
	}
	
	public Button getBackButton() {
		return this.roundCreationPane.getBackButton();
	}
	
	public Button getCreateRoundButton() {
		return this.roundCreationPane.getCreateRoundButton();
	}
	
	public ObservableList<AdditionalParameter> getAdditionalGameParameters() {
		return this.roundCreationPane.getAdditionalGameParameters();
	}
	
	public TextField getGameTextField() {
		return this.roundCreationPane.getGameTextField();
	}

	public Button getBrowseGameButton() {
		return this.roundCreationPane.getBrowseGameButton();
	}

	public TextField getAmountTextField() {
		return this.roundCreationPane.getAmountTextField();
	}

	public VBox getCenterPane() {
		return this.roundCreationPane.getCenterPane();
	}

	public void updateAdditionalParameterTextFields() {
		this.roundCreationPane.updateAdditionalParameterTextFields();
	}
}
