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

public class AgentCreationPane extends BorderPane {
	private Button backButton;
	private Button createAgentButton;
	private TextField strategyTextField;
	private ObservableList<AdditionalParameter> additionalParameters;
	private Button browseStrategyButton;
	private TextField amountTextField;
	
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
		
		// Agent strategy text field
		HBox nameHBox = new HBox();
		nameHBox.setSpacing(10);
		TextField strategyTextField = new TextField();
		this.strategyTextField = strategyTextField;
		Button browseStrategyButton = new Button(GUIText.BROWSE_STRATEGY_BUTTON_LABEL);
		this.browseStrategyButton = browseStrategyButton;
		TextField amountTextField = new TextField();
		this.amountTextField = amountTextField;
		nameHBox.getChildren().addAll(new Label(GUIText.STRATEGY_TEXT_FIELD_LABEL), strategyTextField, 
				browseStrategyButton, new Label(GUIText.AMOUNT_LABEL), amountTextField);
		centerVBox.getChildren().add(nameHBox);
		
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
	
	public TextField getStrategyTextField() {
		return this.strategyTextField;
	}
	
	public ObservableList<AdditionalParameter> getAdditionalParameters() {
		return this.additionalParameters;
	}
	
	public Button getBrowseStrategyButton() {
		return this.browseStrategyButton;
	}
	
	public TextField getAmountTextField() {
		return this.amountTextField;
	}
}
