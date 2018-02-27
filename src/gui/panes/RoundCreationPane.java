package gui.panes;

import gui.panes.additionalparameters.AdditionalParameter;
import gui.utils.GUIDimensions;
import gui.utils.GUIText;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RoundCreationPane extends BorderPane {
	private Button backButton;
	private Button createRoundButton;
	private MenuButton gameMenuButton;
	private ObservableList<AdditionalParameter> additionalGameParameters;
	
	public RoundCreationPane(ObservableList<AdditionalParameter> additionalGameParameters) {
		this.additionalGameParameters = additionalGameParameters;
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		VBox centerPane = configureCenterPane(additionalGameParameters);
		this.setCenter(centerPane);
		
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
				
		// Round drop down
		HBox gameHBox = new HBox();
		gameHBox.setSpacing(10);
		MenuButton gameMenuButton = new MenuButton(GUIText.GAME_MENU_BUTTON);
		this.gameMenuButton = gameMenuButton;
		gameMenuButton.getItems().addAll(new MenuItem("Minority Game"));
		gameHBox.getChildren().addAll(new Label(GUIText.GAME_MENU_BUTTON_LABEL), gameMenuButton);
		centerVBox.getChildren().add(gameHBox);
		
		// Horizontal Separator
		Separator horizontalSeparator = new Separator();
		centerVBox.getChildren().add(horizontalSeparator);
		
		// Additional Parameters		
		for (AdditionalParameter additionalParameter: additionalGameParameters) {
			HBox additionalParameterHBox = new HBox();
			additionalParameterHBox.setSpacing(10);
			additionalParameterHBox.getChildren().addAll(additionalParameter.getLabel(), additionalParameter.getTextField());
			centerVBox.getChildren().add(additionalParameterHBox);
		}
		
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
	
	public MenuButton getGameMenuButton() {
		return this.gameMenuButton;
	}
	
	public ObservableList<AdditionalParameter> getAdditionalGameParameters() {
		return this.additionalGameParameters;
	}
}
