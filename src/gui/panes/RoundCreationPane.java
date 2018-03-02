package gui.panes;

import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RoundCreationPane extends BorderPane {
	private Button backButton;
	private Button createRoundButton;
	private ObservableList<AdditionalParameter> additionalGameParameters;
	private TextField gameTextField;
	private Button browseGameButton;
	private TextField amountTextField;
	private VBox centerPane;
	
	public RoundCreationPane(ObservableList<AdditionalParameter> additionalGameParameters) {
		this.additionalGameParameters = additionalGameParameters;
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		this.centerPane = configureCenterPane(additionalGameParameters);
		this.setCenter(this.centerPane);
		
		BorderPane rightBar = configureRightBar();
		this.setRight(rightBar);
	}
	
	private VBox configureLeftBar() {
		VBox leftBarContent = new VBox();
	    leftBarContent.setPadding(new Insets(10));
	    leftBarContent.setSpacing(8);
	    
	    Button backButton = new Button(GUIText.BACK_BUTTON);
	    this.backButton = backButton;
	    
        leftBarContent.getChildren().add(backButton);
	    
	    return leftBarContent;
	}
	
	private VBox configureCenterPane(ObservableList<AdditionalParameter> additionalGameParameters) {
		VBox centerVBox = new VBox();
		centerVBox.setSpacing(10);
		centerVBox.setPadding(new Insets(10));
		
		// Strategy info
		HBox nameHBox = new HBox();
		nameHBox.setSpacing(10);
		TextField gameTextField = new TextField();
		this.gameTextField = gameTextField;
		Button browseGameButton = new Button(GUIText.BROWSE_GAME_BUTTON_LABEL);
		this.browseGameButton = browseGameButton;
		TextField amountTextField = new TextField();
		this.amountTextField = amountTextField;
		nameHBox.getChildren().addAll(new Label(GUIText.GAME_TEXT_FIELD_LABEL), gameTextField, 
				browseGameButton, new Label(GUIText.AMOUNT_LABEL), amountTextField);
		centerVBox.getChildren().add(nameHBox);
		
		// Horizontal Separator
		Separator horizontalSeparator = new Separator();
		centerVBox.getChildren().add(horizontalSeparator);
		
		return centerVBox;
	}
	
	private BorderPane configureRightBar() {
		BorderPane rightBarContent = new BorderPane();
		rightBarContent.setPadding(new Insets(GUIDimensions.CREATE_ROUND_BUTTON_INSETS));
	    
	    Button createRoundButton = new Button(GUIText.CREATE_ROUND_BUTTON);
	    rightBarContent.setBottom(createRoundButton);
	    this.createRoundButton = createRoundButton;
        
		return rightBarContent;
	}
	
	public Button getBackButton() {
		return this.backButton;
	}
	
	public Button getCreateRoundButton() {
		return this.createRoundButton;
	}
	
	public ObservableList<AdditionalParameter> getAdditionalGameParameters() {
		return this.additionalGameParameters;
	}

	public TextField getGameTextField() {
		return this.gameTextField;
	}

	public Button getBrowseGameButton() {
		return this.browseGameButton;
	}

	public TextField getAmountTextField() {
		return amountTextField;
	}

	public void updateAdditionalParameterTextFields() {
		for (AdditionalParameter additionalParameter: this.additionalGameParameters) {
			HBox additionalParameterHBox = new HBox();
			additionalParameterHBox.setSpacing(10);
			additionalParameterHBox.getChildren().addAll(additionalParameter.getLabel(), additionalParameter.getTextField());
			this.centerPane.getChildren().add(additionalParameterHBox);
		}
	}
	
	public VBox getCenterPane() {
		return this.centerPane;
	}
}
