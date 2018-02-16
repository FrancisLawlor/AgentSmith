package statemachine.states;

import agents.info.AgentInfo;
import games.minoritygame.MinorityGame;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import tournament.rounds.Round;

public class DashboardState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	
	public DashboardState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
	}

	public void execute(StateName param) {
		sceneContainerStage.changeScene(gui.getDashBoardScene());
		sceneContainerStage.setTitle(GUIText.DASHBOARD);
		
		gui.getDashBoardScene().getAgentListView().getItems().add(new AgentInfo("james", "bestplay"));
		gui.getDashBoardScene().getRoundListView().getItems().add(new Round(new MinorityGame("game")));
		switch (param) {
			default:
				break;
		}
	}
}
