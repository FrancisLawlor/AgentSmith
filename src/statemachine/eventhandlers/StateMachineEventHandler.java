package statemachine.eventhandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import statemachine.core.StateMachine;
import statemachine.utils.StateParameters;

public class StateMachineEventHandler implements EventHandler<ActionEvent> {
	private StateParameters stateParameter;
	private StateMachine stateMachine;
	
	public StateMachineEventHandler(StateParameters stateParameter, StateMachine stateMachine) {
		this.stateParameter = stateParameter;
		this.stateMachine = stateMachine;
	}
	@Override
	public void handle(ActionEvent event) {
		stateMachine.execute(stateParameter);
	}
	
}
