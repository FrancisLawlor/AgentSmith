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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AgentCreationPane extends BorderPane {
	private Button backButton;
	private Button createAgentButton;
	private MenuButton strategyMenuButton;
	private TextField nameTextField;
	private ObservableList<AdditionalParameter> additionalParameters;
	
	public AgentCreationPane(ObservableList<AdditionalParameter> additionalParameters) {
		this.additionalParameters = additionalParameters;
		VBox leftBar = configureLeftBar();
		this.setLeft(leftBar);
		
		VBox centerPane = configureCenterPane(additionalParameters);
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
	
	private VBox configureCenterPane(ObservableList<AdditionalParameter> additionalParameters) {
		VBox centerVBox = new VBox();
		centerVBox.setSpacing(10);
		centerVBox.setPadding(new Insets(10));
		
		// Agent name text field
		HBox nameHBox = new HBox();
		nameHBox.setSpacing(10);
		TextField nameTextField = new TextField();
		this.nameTextField = nameTextField;
		nameHBox.getChildren().addAll(new Label(GUIText.AGENT_NAME_TEXT_FIELD_LABEL), nameTextField);
		centerVBox.getChildren().add(nameHBox);
				
		// Strategy drop down
		HBox strategyHBox = new HBox();
		strategyHBox.setSpacing(10);
		MenuButton strategyMenuButton = new MenuButton(GUIText.STRATEGY_MENU_BUTTON);
		this.strategyMenuButton = strategyMenuButton;
		strategyMenuButton.getItems().addAll(new MenuItem("Best Play"));
		strategyHBox.getChildren().addAll(new Label(GUIText.STRATEGY_TEXT_FIELD_LABEL), strategyMenuButton);
		centerVBox.getChildren().add(strategyHBox);
		
		// Horizontal Seperator
		Separator horizontalSeparator = new Separator();
		centerVBox.getChildren().add(horizontalSeparator);
		
		// Additional Parameters		
		for (AdditionalParameter additionalParameter: additionalParameters) {
			HBox additionalParameterHBox = new HBox();
			additionalParameterHBox.setSpacing(10);
			additionalParameterHBox.getChildren().addAll(additionalParameter.getLabel(), additionalParameter.getTextField());
			centerVBox.getChildren().add(additionalParameterHBox);
		}
		
		return centerVBox;
	}
	
	private BorderPane configureRightBar() {
		BorderPane rightBarContent = new BorderPane();
		rightBarContent.setPadding(new Insets(GUIDimensions.CREATE_AGENT_BUTTON_INSETS));
	    
	    Button createAgentButton = new Button(GUIText.CREATE_AGENT_BUTTON);
	    rightBarContent.setBottom(createAgentButton);
	    this.createAgentButton = createAgentButton;
        
		return rightBarContent;
	}
	
	public Button getBackButton() {
		return this.backButton;
	}
	
	public Button getCreateAgentButton() {
		return this.createAgentButton;
	}
	
	public MenuButton getStrategyMenuButton() {
		return this.strategyMenuButton;
	}
	
	public TextField getNameTextField() {
		return this.nameTextField;
	}
	
	public ObservableList<AdditionalParameter> getAdditionalParameters() {
		return this.additionalParameters;
	}
}
