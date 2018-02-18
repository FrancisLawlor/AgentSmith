package statemachine.eventhandlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import statemachine.core.StateMachine;
import statemachine.utils.StateParameters;

public class ListViewEventHandler implements EventHandler<MouseEvent> {
	private StateParameters stateParameter;
	private StateMachine stateMachine;
	
	public ListViewEventHandler(StateParameters stateParameter, StateMachine stateMachine) {
		this.stateParameter = stateParameter;
		this.stateMachine = stateMachine;
	}
	
	@Override
	public void handle(MouseEvent event) {
		stateMachine.execute(stateParameter);
	}
	
}
