package gui.core;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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
	    
	    
	    //Fake data for illustrative purposes.
	    ObservableList<AdditionalParameter> additionalParameters = FXCollections.observableArrayList();
	    additionalParameters.add(new AdditionalParameter(new Label("History Length"), new TextField()));

		this.dashBoardPane = new DashBoardPane(this.agentData, this.roundData);
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

	public void updateTournamentData(TournamentData tournamentData) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Configure rounds.
		for (int i = 0; i < tournamentData.getRounds().size(); i++) {
//			for (int j = 0; j < tournamentData.getRounds().get(i).getAmount(); j++) {
//				HashMap<String, String> additionalParameters = new HashMap<String, String>();
//				
//				for (int k = 0; k < tournamentData.getRounds().get(i).getGame().getAdditionalParameters().size(); k++) {
//					String name = tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getName();
//					String value = tournamentData.getRounds().get(i).getGame().getAdditionalParameters().get(k).getValue();
//					additionalParameters.put(name, value);
//				}
//			}
			this.roundData.add(tournamentData.getRounds().get(i));
		}
		
		// Configure players.
		int currentId = 0;
		for (int i = 0; i < tournamentData.getAgents().size(); i++) {
//			for (int j = 0; j < tournamentData.getAgents().get(i).getAmount(); j++) {
//				HashMap<String, String> additionalParameters = new HashMap<String, String>();
//				for (int k = 0; k < tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().size(); k++) {
//					String name = tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getName();
//					String value = tournamentData.getAgents().get(i).getStrategyData().getAdditionalParameters().get(k).getValue();
//					additionalParameters.put(name, value);
//				}
//				
//				Player newPlayer = new Player(currentId + "", tournamentData.getAgents().get(i).getStrategyData().getName() , additionalParameters);
//				currentId++;
//			}
			
			this.agentData.add(tournamentData.getAgents().get(i));
		}
	}
}
