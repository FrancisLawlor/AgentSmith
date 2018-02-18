package gui.panes.additionalparameters;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AdditionalParameter {
	private Label label;
	private TextField textField;
	
	public AdditionalParameter(Label label, TextField textField) {
		this.label = label;
		this.textField = textField;
	}
	
	public Label getLabel() {
		return this.label;
	}
	
	public TextField getTextField() {
		return this.textField;
	}
}
