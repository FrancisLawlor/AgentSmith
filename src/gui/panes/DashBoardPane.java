package gui.panes;

import agents.info.AgentInfo;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class DashBoardPane extends BorderPane {
	private Button refreshButton;
	private ListView<AgentInfo> listView;
	
	public DashBoardPane(ObservableList<AgentInfo> data) {
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		ListView<AgentInfo> listView = configureListView(data);
		this.setCenter(listView);
        this.listView = listView;
		
		BorderPane rightBar = configureRightBar(data);
		this.setRight(rightBar);
	}
	
	private VBox configureLeftBar() {
		VBox content = new VBox();
	    content.setPadding(new Insets(10));
	    content.setSpacing(8);
	    	    
	    return content;
	}
	
	private ListView<AgentInfo> configureListView(ObservableList<AgentInfo> data) {
		final ListView<AgentInfo> listView = new ListView<AgentInfo>(data);
		
		listView.setCellFactory(new Callback<ListView<AgentInfo>, ListCell<AgentInfo>>() {

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
		
		return listView;
	}
	
	private BorderPane configureRightBar(ObservableList<AgentInfo> data) {
		BorderPane content = new BorderPane();
		content.setPadding(new Insets(10));
	    
	    content.setBottom(refreshButton);
        
		return content;
	}

	public Button getRefreshButton() {
		return refreshButton;
	}

	public ListView<AgentInfo> getListView() {
		return listView;
	}
}
