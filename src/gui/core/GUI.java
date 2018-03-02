package gui.core;

import java.lang.reflect.InvocationTargetException;

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
import tournament.data.AgentData;
import tournament.data.RoundData;
import tournament.data.TournamentData;

public class GUI {
	private DashBoardPane dashBoardPane;
	private DashBoardScene dashBoardScene;
	private AgentCreationPane agentCreationPane;
	private AgentCreationScene agentCreationScene;
	private RoundCreationPane roundCreationPane;
	private RoundCreationScene roundCreationScene;
	private TournamentPlayingPane tournamentPlayingPane;
	private TournamentPlayingScene tournamentPlayingScene;
	private ObservableList<AgentData> agentData = FXCollections.observableArrayList();
    private ObservableList<RoundData> roundData = FXCollections.observableArrayList();
	
	
	public GUI(SceneContainerStage containerStage) {
	    ObservableList<AdditionalParameter> additionalStrategyParameters = FXCollections.observableArrayList();
	    ObservableList<AdditionalParameter> additionalRoundParameters = FXCollections.observableArrayList();

		this.dashBoardPane = new DashBoardPane(this.agentData, this.roundData);
		this.dashBoardScene = new DashBoardScene(this.dashBoardPane);
		
		this.agentCreationPane = new AgentCreationPane(additionalStrategyParameters);
		this.agentCreationScene = new AgentCreationScene(this.agentCreationPane);
		
		this.roundCreationPane = new RoundCreationPane(additionalRoundParameters);
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

	public void updateTournamentData(TournamentData tournamentData) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		this.roundData.clear();
		this.agentData.clear();
		
		for (int i = 0; i < tournamentData.getRounds().size(); i++) {
			this.roundData.add(tournamentData.getRounds().get(i));
		}
		for (int i = 0; i < tournamentData.getAgents().size(); i++) {
			this.agentData.add(tournamentData.getAgents().get(i));
		}
	}
}
