package gui.panes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import filemanagement.utils.FileResources;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import tournament.data.AdditionalParameterData;
import tournament.data.AgentData;
import tournament.data.RoundData;

public class DashBoardPane extends BorderPane {
	private Button loadTournamentButton;
	private Button saveTournamentButton;
	private Button playButton;
	private Button addAgentButton;
	private Button addRoundButton;
	private ListView<AgentData> agentListView;
	private ListView<RoundData> roundListView;
	
	public DashBoardPane(ObservableList<AgentData> agentData, ObservableList<RoundData> roundData) {
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		BorderPane centerPane = configureCenterPane(agentData, roundData);
		this.setCenter(centerPane);
		
		BorderPane rightBar = configureRightBar();
		this.setRight(rightBar);
	}

	private BorderPane configureCenterPane(ObservableList<AgentData> agentData, ObservableList<RoundData> roundData) {
		VBox leftSide = new VBox();
		leftSide.setSpacing(GUIDimensions.DASHBOARD_VBOX_SPACING);
		Label agentListViewLabel = new Label(GUIText.AGENTS_LISTVIEW_LABEL);
		agentListViewLabel.setFont(new Font(GUIDimensions.DASHBOARD_LISTVIEW_LABEL_FONT_SIZE));
		agentListViewLabel.setPadding(new Insets(GUIDimensions.LISTVIEW_LABEL_TOP_PADDING, GUIDimensions.LISTVIEW_LABEL_RIGHT_PADDING, GUIDimensions.LISTVIEW_LABEL_BOTTOM_PADDING, GUIDimensions.LISTVIEW_LABEL_LEFT_PADDING));
		ListView<AgentData> agentListView = configureAgentListView(agentData);
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
		ListView<RoundData> roundListView = configureRoundListView(roundData);
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
	
	private ListView<AgentData> configureAgentListView(ObservableList<AgentData> agentData) {
		final ListView<AgentData> agentListView = new ListView<AgentData>(agentData);
		
		agentListView.setCellFactory(new Callback<ListView<AgentData>, ListCell<AgentData>>() {

			@Override
			public ListCell<AgentData> call(ListView<AgentData> arg) {
				return new ListCell<AgentData>() {
					
					@Override
					protected void updateItem(AgentData item, boolean emptyCell) {
						super.updateItem(item, emptyCell);
						
						if (emptyCell) {
							setText(null);
							setGraphic(null);
						}
						if (item != null) {
							VBox additionalParametersVBox = new VBox();
							
							if (item.getStrategyData().getAdditionalParameters().size() > 0) {
								additionalParametersVBox.getChildren().add(new Text(GUIText.ADDITIONAL_PARAMETERS_LISTVIEW + ":"));

								for (AdditionalParameterData additionalParameterData: item.getStrategyData().getAdditionalParameters()) {
									additionalParametersVBox.getChildren().add(new Text("\t" + additionalParameterData.getName() + ": " + additionalParameterData.getValue()));
								}
							}
							
							VBox vBox = new VBox(new Text(GUIText.STRATEGY_NAME_LISTVIEW + ":\t" + item.getStrategyData().getName()), new Text(GUIText.AMOUNT_LISTVIEW + ":\tx" + item.getAmount()), additionalParametersVBox);
							
							BufferedImage bufferedImage = null;
							try {
								File imageFile = new File(FileResources.AGENT_ICON_PATH);
								bufferedImage = ImageIO.read(imageFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							Image image = SwingFXUtils.toFXImage(bufferedImage, null);
							ImageView agentIcon = new ImageView();
							agentIcon.setImage(image);
							agentIcon.setFitHeight(40);
							agentIcon.setFitWidth(40);
							agentIcon.preserveRatioProperty();
					
							HBox hBox = new HBox(agentIcon, vBox);
							hBox.setSpacing(10);
							setGraphic(hBox);
						}
					}
				};
			}
		});
		
		return agentListView;
	}
	
	private ListView<RoundData> configureRoundListView(ObservableList<RoundData> roundData) {
		final ListView<RoundData> roundListView = new ListView<RoundData>(roundData);
		
		roundListView.setCellFactory(new Callback<ListView<RoundData>, ListCell<RoundData>>() {

			@Override
			public ListCell<RoundData> call(ListView<RoundData> arg) {
				return new ListCell<RoundData>() {
					
					@Override
					protected void updateItem(RoundData item, boolean emptyCell) {
						super.updateItem(item, emptyCell);
						
						if (emptyCell) {
							setText(null);
							setGraphic(null);
						}
						if (item != null) {
							VBox additionalParametersVBox = new VBox();
							
							if (item.getGame().getAdditionalParameters().size() > 0) {
								additionalParametersVBox.getChildren().add(new Text(GUIText.ADDITIONAL_PARAMETERS_LISTVIEW + ":"));
								
								for (AdditionalParameterData additionalParameterData: item.getGame().getAdditionalParameters()) {
									additionalParametersVBox.getChildren().add(new Text("\t" + additionalParameterData.getName() + ": " + additionalParameterData.getValue()));
								}
							}
							
							VBox vBox = new VBox(new Text(GUIText.GAME_NAME_LISTVIEW + ":\t" + item.getGame().getName()), new Text(GUIText.AMOUNT_LISTVIEW + ":\tx" + item.getAmount()), additionalParametersVBox);
							
							BufferedImage bufferedImage = null;
							try {
								File imageFile = new File(FileResources.TROPHY_ICON_PATH);
								bufferedImage = ImageIO.read(imageFile);
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							Image image = SwingFXUtils.toFXImage(bufferedImage, null);
							ImageView agentIcon = new ImageView();
							agentIcon.setImage(image);
							agentIcon.setFitHeight(40);
							agentIcon.setFitWidth(40);
							agentIcon.preserveRatioProperty();
					
							HBox hBox = new HBox(agentIcon, vBox);
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

	public ListView<AgentData> getAgentListView() {
		return agentListView;
	}
	
	public ListView<RoundData> getRoundListView() {
		return this.roundListView;
	}
}
