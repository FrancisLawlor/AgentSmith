package gui.scenes;

import gui.panes.RoundCreationPane;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;

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
	
	public MenuButton getGameyMenuButton() {
		return this.roundCreationPane.getGameMenuButton();
	}
	
	public ObservableList<AdditionalParameter> getAdditionalGameParameters() {
		return this.roundCreationPane.getAdditionalGameParameters();
	}
}
