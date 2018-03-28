package gui.panes;

import java.util.Map;

import games.score.RoundScoreRecorder;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import tournament.core.TournamentResources;
import tournament.data.CumulativePayoffsData;

public class TournamentPhasePane extends BorderPane {
	private Button continueButton;
	private Text phaseDataText;
	private ScrollPane centerPane;
	
	public TournamentPhasePane() {		
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		ScrollPane centerPane = configureCenterPane();
		this.setCenter(centerPane);
		
		BorderPane rightBar = configureRightBar();
		this.setRight(rightBar);
	}
	
	public static class RowData {
		private final SimpleStringProperty id;
		private final SimpleStringProperty payoff;
		
		public RowData(String id, String payoff) {
			this.id = new SimpleStringProperty(id);
			this.payoff = new SimpleStringProperty(payoff);
		}
		
		public String getId() {
			return this.id.get();
		}
		public void setId(String id) {
			this.id.set(id);
        }
		public String getPayoff() {
			return this.payoff.get();
		}
		public void setPayoff(String payoff) {
			this.payoff.set(payoff);
		}
	}

	private ScrollPane configureCenterPane() {
		ScrollPane scrollPane = new ScrollPane();
		this.centerPane = scrollPane;
		scrollPane.setFitToWidth(true);
		Text phaseDataText = new Text();
		this.phaseDataText = phaseDataText;
		scrollPane.setContent(phaseDataText);
		
	    	return scrollPane;
	}
	
	private VBox configureLeftBar() {
		VBox leftBarContent = new VBox();
	    leftBarContent.setPadding(new Insets(10));
	    leftBarContent.setSpacing(8);
	    
	    return leftBarContent;
	}
	
	private BorderPane configureRightBar() {
		BorderPane rightBarContent = new BorderPane();
		rightBarContent.setPadding(new Insets(GUIDimensions.START_TOURNAMENT_BUTTON_INSETS));
	    
	    Button continueButton = new Button(GUIText.CONTINUE);
	    rightBarContent.setBottom(continueButton);
	    this.continueButton = continueButton;
        
		return rightBarContent;
	}
	
	public Text getPhaseDataText() {
		return this.phaseDataText;
	}
	
	public Button getContinueButton() {
		return this.continueButton;
	}
	
	public void updateRoundData(Map<String, Float> displayData) {
		VBox tableVBox = new VBox();
		TableView<RowData> roundTable = new TableView<RowData>();
		ObservableList<RowData> roundData = FXCollections.observableArrayList();
				
		TableColumn idColumn = new TableColumn("ID");
		idColumn.setMinWidth(406);
		idColumn.setCellValueFactory(new PropertyValueFactory<RowData, String>("id"));
	    
	    TableColumn payoffColumn = new TableColumn("Payoff");
		payoffColumn.setMinWidth(406);
		payoffColumn.setCellValueFactory(new PropertyValueFactory<RowData , String>("payoff"));
	    		
		for (int i = 0; i < displayData.size() - 1; i++) {
			roundData.add(new RowData(i + "", displayData.get(i + "") + ""));
		}
		
		roundTable.setItems(roundData);
		roundTable.getColumns().addAll(idColumn, payoffColumn);
		tableVBox.getChildren().addAll(new Text("After " + (Math.round(displayData.get(TournamentResources.CURRENT_ROUND)) + 1) + " rounds."), roundTable);
		
		this.centerPane.setContent(tableVBox);
	}
}
