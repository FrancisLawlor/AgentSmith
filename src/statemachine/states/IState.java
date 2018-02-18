package statemachine.states;

import statemachine.utils.StateParameters;

public interface IState {
	void execute(StateParameters param);
}
