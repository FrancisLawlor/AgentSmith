package gui.panes;

import agents.info.AgentInfo;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import tournament.rounds.Round;

public class DashBoardPane extends BorderPane {
	private Button loadTournamentButton;
	private Button saveTournamentButton;
	private Button playButton;
	private Button addAgentButton;
	private Button addRoundButton;
	private ListView<AgentInfo> agentListView;
	private ListView<Round> roundListView;
	
	public DashBoardPane(ObservableList<AgentInfo> agentData, ObservableList<Round> roundData) {
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		BorderPane centerPane = configureCenterPane(agentData, roundData);
		this.setCenter(centerPane);
		
		BorderPane rightBar = configureRightBar();
		this.setRight(rightBar);
	}

	private BorderPane configureCenterPane(ObservableList<AgentInfo> agentData, ObservableList<Round> roundData) {
		VBox leftSide = new VBox();
		leftSide.setSpacing(GUIDimensions.DASHBOARD_VBOX_SPACING);
		Label agentListViewLabel = new Label(GUIText.AGENTS_LISTVIEW_LABEL);
		agentListViewLabel.setFont(new Font(GUIDimensions.DASHBOARD_LISTVIEW_LABEL_FONT_SIZE));
		agentListViewLabel.setPadding(new Insets(GUIDimensions.LISTVIEW_LABEL_TOP_PADDING, GUIDimensions.LISTVIEW_LABEL_RIGHT_PADDING, GUIDimensions.LISTVIEW_LABEL_BOTTOM_PADDING, GUIDimensions.LISTVIEW_LABEL_LEFT_PADDING));
		ListView<AgentInfo> agentListView = configureAgentListView(agentData);
		agentListView.setMinHeight(GUIDimensions.DASHBOARD_LISTVIEW_HEIGHT);
		agentListView.setMinWidth(GUIDimensions.DASHBOARD_LISTVIEW_WIDTH);
        this.agentListView = agentListView;
        Button addAgentButton = new Button(GUIText.ADD_AGENT_BUTTON);
        this.addAgentButton = addAgentButton;
        
        leftSide.getChildren().addAll(agentListViewLabel, agentListView, addAgentButton);
        
		VBox rightSide = new VBox();
		rightSide.setSpacing(GUIDimensions.DASHBOARD_VBOX_SPACING);
		Label roundListViewLabel = new Label(GUIText.ROUND_LISTVIEW_LABEL);
		roundListViewLabel.setFont(new Font(GUIDimensions.DASHBOARD_LISTVIEW_LABEL_FONT_SIZE));
		roundListViewLabel.setPadding(new Insets(GUIDimensions.LISTVIEW_LABEL_TOP_PADDING, GUIDimensions.LISTVIEW_LABEL_RIGHT_PADDING, GUIDimensions.LISTVIEW_LABEL_BOTTOM_PADDING, GUIDimensions.LISTVIEW_LABEL_LEFT_PADDING));
		ListView<Round> roundListView = configureRoundListView(roundData);
		roundListView.setMinHeight(GUIDimensions.DASHBOARD_LISTVIEW_HEIGHT);
		roundListView.setMinWidth(GUIDimensions.DASHBOARD_LISTVIEW_WIDTH);
        this.roundListView = roundListView;
        Button addRoundButton = new Button(GUIText.ADD_ROUND_BUTTON);
        this.addRoundButton = addRoundButton;
        
        rightSide.getChildren().addAll(roundListViewLabel, roundListView, addRoundButton);
        
		BorderPane centerPane = new BorderPane();
		
		centerPane.setLeft(leftSide);
		centerPane.setRight(rightSide);
		
		return centerPane;
	}

	private VBox configureLeftBar() {
		VBox leftBarContent = new VBox();
	    leftBarContent.setPadding(new Insets(10));
	    leftBarContent.setSpacing(8);
	    
	    Button loadTournamentButton = new Button(GUIText.LOAD_TOURNAMENT);
	    Button saveTournamentButton = new Button(GUIText.SAVE_TOURNAMENT);
	    
	    this.loadTournamentButton = loadTournamentButton;
	    this.saveTournamentButton = saveTournamentButton;
	    
        leftBarContent.getChildren().add(loadTournamentButton);
        leftBarContent.getChildren().add(saveTournamentButton);
	    
	    return leftBarContent;
	}
	
	private ListView<AgentInfo> configureAgentListView(ObservableList<AgentInfo> agentData) {
		final ListView<AgentInfo> agentListView = new ListView<AgentInfo>(agentData);
		
		agentListView.setCellFactory(new Callback<ListView<AgentInfo>, ListCell<AgentInfo>>() {

			@Override
			public ListCell<AgentInfo> call(ListView<AgentInfo> arg) {
				return new ListCell<AgentInfo>() {
					
					@Override
					protected void updateItem(AgentInfo item, boolean emptyCell) {
						super.updateItem(item, emptyCell);
						
						if (emptyCell) {
							setText(null);
							setGraphic(null);
						}
						if (item != null) {
							VBox vBox = new VBox(new Text(item.getId()), new Text(item.getStrategy()));
							HBox hBox = new HBox(new Label("[Graphic]"), vBox);
							hBox.setSpacing(10);
							setGraphic(hBox);
						}
					}
				};
			}
		});
		
		return agentListView;
	}
	
	private ListView<Round> configureRoundListView(ObservableList<Round> roundData) {
		final ListView<Round> roundListView = new ListView<Round>(roundData);
		
		roundListView.setCellFactory(new Callback<ListView<Round>, ListCell<Round>>() {

			@Override
			public ListCell<Round> call(ListView<Round> arg) {
				return new ListCell<Round>() {
					
					@Override
					protected void updateItem(Round item, boolean emptyCell) {
						super.updateItem(item, emptyCell);
						
						if (emptyCell) {
							setText(null);
							setGraphic(null);
						}
						if (item != null) {
							VBox vBox = new VBox(new Text(item.getGame().getId()), new Text(item.getGame().getId()));
							HBox hBox = new HBox(new Label("[Graphic]"), vBox);
							hBox.setSpacing(10);
							setGraphic(hBox);
						}
					}
				};
			}
		});
		
		return roundListView;
	}
	
	private BorderPane configureRightBar() {
		BorderPane rightBarContent = new BorderPane();
		rightBarContent.setPadding(new Insets(GUIDimensions.START_TOURNAMENT_BUTTON_INSETS));
	    
	    Button playButton = new Button(GUIText.START_TOURNAMENT_BUTTON);
	    rightBarContent.setBottom(playButton);
	    this.playButton = playButton;
        
		return rightBarContent;
	}

	public Button getLoadTournamentButton() {
		return loadTournamentButton;
	}

	public Button getSaveTournamentButton() {
		return saveTournamentButton;
	}

	public Button getPlayButton() {
		return playButton;
	}
	
	public Button getAddAgentButton() {
		return addAgentButton;
	}
	
	public Button getAddRoundButton() {
		return addRoundButton;
	}

	public ListView<AgentInfo> getAgentListView() {
		return agentListView;
	}
	
	public ListView<Round> getRoundListView() {
		return this.roundListView;
	}
}
