package gui.scenes;

import gui.panes.DashBoardPane;
import gui.utils.GUIDimensions;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import tournament.data.AgentData;
import tournament.data.RoundData;

public class DashBoardScene extends Scene {
	private DashBoardPane dashBoardPane;
	
	public DashBoardScene(DashBoardPane dashBoardPane) {
		super(dashBoardPane, GUIDimensions.MAIN_WINDOW_WIDTH, GUIDimensions.MAIN_WINDOW_HEIGHT);
		this.dashBoardPane = dashBoardPane;
	}
	
	public Button getPlayButton() {
		return this.dashBoardPane.getPlayButton();
	}
	
	public ListView<AgentData> getAgentListView() {
		return this.dashBoardPane.getAgentListView();
	}
	
	public ListView<RoundData> getRoundListView() {
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
	
	public Button getClearAgentsButton() {
		return this.dashBoardPane.getClearAgentsButton();
	}
	
	public Button getRemoveSelectedAgentButton() {
		return this.dashBoardPane.getRemoveSelectedAgentButton();
	}
	
	public Button getAddRoundButton() {
		return this.dashBoardPane.getAddRoundButton();
	}
	
	public Button getClearRoundsButton() {
		return this.dashBoardPane.getClearRoundsButton();
	}

	public Button getRemoveSelectedRoundButton() {
		return this.dashBoardPane.getRemoveSelectedRoundButton();
	}
}
