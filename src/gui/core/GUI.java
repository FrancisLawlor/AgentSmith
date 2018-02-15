package gui.core;

import agents.info.AgentInfo;
import gui.panes.DashBoardPane;
import gui.scenes.DashBoardScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GUI {
	private DashBoardScene dashBoardScene;
	private DashBoardPane dashBoardPane;
	
	public GUI(SceneContainerStage containerStage) {
	    ObservableList<AgentInfo> agentData = FXCollections.observableArrayList();
		
		this.dashBoardPane = new DashBoardPane(agentData);

		this.dashBoardScene = new DashBoardScene(this.dashBoardPane);
	}
	
	public DashBoardScene getDashBoardScene() {
		return this.dashBoardScene;
	}
}
