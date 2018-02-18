package gui.core;

import agents.info.AgentInfo;
import gui.panes.AgentCreationPane;
import gui.panes.DashBoardPane;
import gui.panes.RoundCreationPane;
import gui.panes.TournamentPlayingPane;
import gui.panes.additionalparameters.AdditionalParameter;
import gui.scenes.AgentCreationScene;
import gui.scenes.DashBoardScene;
import gui.scenes.RoundCreationScene;
import gui.scenes.TournamentPlayingScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tournament.rounds.Round;

public class GUI {
	private DashBoardPane dashBoardPane;
	private DashBoardScene dashBoardScene;
	private AgentCreationPane agentCreationPane;
	private AgentCreationScene agentCreationScene;
	private RoundCreationPane roundCreationPane;
	private RoundCreationScene roundCreationScene;
	private TournamentPlayingPane tournamentPlayingPane;
	private TournamentPlayingScene tournamentPlayingScene;
	
	
	public GUI(SceneContainerStage containerStage) {
	    ObservableList<AgentInfo> agentData = FXCollections.observableArrayList();
	    ObservableList<Round> roundData = FXCollections.observableArrayList();
	    
	    //Fake data for illustrative purposes.
	    ObservableList<AdditionalParameter> additionalParameters = FXCollections.observableArrayList();
	    additionalParameters.add(new AdditionalParameter(new Label("History Length"), new TextField()));

		this.dashBoardPane = new DashBoardPane(agentData, roundData);
		this.dashBoardScene = new DashBoardScene(this.dashBoardPane);
		
		this.agentCreationPane = new AgentCreationPane(additionalParameters);
		this.agentCreationScene = new AgentCreationScene(this.agentCreationPane);
		
		this.roundCreationPane = new RoundCreationPane(additionalParameters);
		this.roundCreationScene = new RoundCreationScene(this.roundCreationPane);
		
		this.tournamentPlayingPane = new TournamentPlayingPane();
		this.tournamentPlayingScene = new TournamentPlayingScene(this.tournamentPlayingPane);
	}
	
	public DashBoardScene getDashBoardScene() {
		return this.dashBoardScene;
	}
	
	public AgentCreationScene getAgentCreationScene() {
		return this.agentCreationScene;
	}
	
	public RoundCreationScene getRoundCreationScene() {
		return this.roundCreationScene;
	}
	
	public TournamentPlayingScene getTournamentPlayingScene() {
		return this.tournamentPlayingScene;
	}
}
