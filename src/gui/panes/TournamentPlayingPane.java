package gui.panes;

import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class TournamentPlayingPane extends BorderPane {	
	public TournamentPlayingPane() {
		StackPane contentStackPane = configureStackPane();
		
		this.setCenter(contentStackPane);
	}

	private StackPane configureStackPane() {
		StackPane content = new StackPane();
		ProgressIndicator progressIndicator = new ProgressIndicator();
		progressIndicator.setMaxSize(GUIDimensions.PROGRESS_INDICATOR_MAX_DIMENSION, GUIDimensions.PROGRESS_INDICATOR_MAX_DIMENSION);
	    	content.getChildren().add(progressIndicator);
	    	content.getChildren().add(new Text(GUIText.TOURNAMENT_PLAYING_TEXT));
	    	
	    	return content;
	}
}
