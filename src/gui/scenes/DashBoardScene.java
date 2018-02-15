package gui.scenes;

import agents.info.AgentInfo;
import gui.panes.DashBoardPane;
import gui.utils.GUIDimensions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class DashBoardScene extends Scene {
	DashBoardPane dashBoardPane;
	
	public DashBoardScene(DashBoardPane dashBoardPane) {
		super(dashBoardPane, GUIDimensions.mainWindowWidth, GUIDimensions.mainWindowHeight);
		this.dashBoardPane = dashBoardPane;
	}
	
	public Button getRefreshButton() {
		return this.dashBoardPane.getRefreshButton();
	}
	
	public ListView<AgentInfo> getListView() {
		return this.dashBoardPane.getListView();
	}
}
