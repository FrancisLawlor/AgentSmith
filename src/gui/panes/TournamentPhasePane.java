package gui.panes;

import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class TournamentPhasePane extends BorderPane {
	private Button continueButton;
	private Text phaseDataText;
	
	public TournamentPhasePane() {		
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		ScrollPane centerPane = configureCenterPane();
		this.setCenter(centerPane);
		
		BorderPane rightBar = configureRightBar();
		this.setRight(rightBar);
	}

	private ScrollPane configureCenterPane() {
		ScrollPane scrollPane = new ScrollPane();
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
}
