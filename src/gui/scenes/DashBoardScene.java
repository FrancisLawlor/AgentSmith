package gui.scenes;

import agents.info.AgentInfo;
import gui.panes.DashBoardPane;
import gui.utils.GUIDimensions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tournament.rounds.Round;

public class DashBoardScene extends Scene {
	DashBoardPane dashBoardPane;
	
	public DashBoardScene(DashBoardPane dashBoardPane) {
		super(dashBoardPane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
		this.dashBoardPane = dashBoardPane;
	}
	
	public Button getPlayButton() {
		return this.dashBoardPane.getPlayButton();
	}
	
	public ListView<AgentInfo> getAgentListView() {
		return this.dashBoardPane.getAgentListView();
	}
	
	public ListView<Round> getRoundListView() {
		return this.dashBoardPane.getRoundListView();
	}
	
	public Button getLoadTournamentButton() {
		return this.dashBoardPane.getLoadTournamentButton();
	}
	
	public Button getSaveTournamentButton() {
		return this.dashBoardPane.getSaveTournamentButton();
	}
	
	public Button getAddAgentButton() {
		return this.dashBoardPane.getAddAgentButton();
	}
	
	public Button getAddRoundButton() {
		return this.dashBoardPane.getAddRoundButton();
	}
}
