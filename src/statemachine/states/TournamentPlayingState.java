package statemachine.states;

import java.io.File;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import agents.AgentSystemInitialiser;
import agents.TournamentRestarter;
import astra.core.ASTRAClassNotFoundException;
import astra.core.AgentCreationException;
import astra.core.Scheduler;
import astra.execution.AdaptiveSchedulerStrategy;
import astra.formula.Goal;
import astra.formula.Predicate;
import astra.term.ListTerm;
import astra.term.Primitive;
import astra.term.Term;
import filemanagement.utils.FileResources;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentDataWrapper;

public class TournamentPlayingState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TournamentDataWrapper GUITournamentData;
	private volatile int currentPhase = 0;
	private int numberOfRoundsPerPhase = 5;
	private int numberOfPhases;

	public TournamentPlayingState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUITournamentData) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.GUITournamentData = GUITournamentData;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case RETURN:
				nextPhase();
				break;
			default:
				break;
		}
	}

	private void nextPhase() {
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				startNextNRounds();
				return null;
			}
			
			private void startNextNRounds() {
				currentPhase++;
				String name = java.lang.System.getProperty("astra.name", "tournament_restarter" + currentPhase);
				try {
					astra.core.Agent agent = new TournamentRestarter().newInstance(name);
					agent.initialize(new Goal(new Predicate("main", new Term[] { new ListTerm() })));
					Scheduler.schedule(agent);
				} catch (AgentCreationException e) {
					e.printStackTrace();
				} catch (ASTRAClassNotFoundException e) {
					e.printStackTrace();
				};					
			}
		};
		task.setOnSucceeded(e -> {
			this.currentPhase++;

			if (this.currentPhase >= this.numberOfPhases) {
				this.stateMachine.setCurrentState(StateName.DASHBOARD);
				this.stateMachine.execute(StateParameters.INIT);
			} else {
				this.stateMachine.setCurrentState(StateName.TOURNAMENT_PHASE);
				this.stateMachine.execute(StateParameters.RETURN);
			}
		});
		new Thread(task).start();			
	}

	private void init() {
		this.numberOfPhases = calculateNumberOfPhases();
		
		this.sceneContainerStage.setTitle(GUIText.SELECT_FILE);
		
		File resultFile = chooseSaveLocation();
		
		if (resultFile != null) {
			fileSelected(resultFile.getPath());
		} else {
			cancelledFileSelection();
		}
	}

	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.RETURN);	
	}

	private void fileSelected(String path) {
		this.sceneContainerStage.changeScene(gui.getTournamentPlayingScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PLAYING_TEXT);
		
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		String[] params = {gsonUtility.toJson(this.GUITournamentData.getTournamentData()), path};
		
		Task<Void> task = new Task<Void>() {
			@Override
			public Void call() throws Exception {
				initialiseAgentSystem();
				return null;
			}

			private void initialiseAgentSystem() {
				Scheduler.setStrategy(new AdaptiveSchedulerStrategy());
				ListTerm argList = new ListTerm();
				for (String arg: params) {
					argList.add(Primitive.newPrimitive(arg));
				}

				String name = java.lang.System.getProperty("astra.name", "main");
				try {
					astra.core.Agent agent = new AgentSystemInitialiser(params[0], params[1]).newInstance(name);
					agent.initialize(new Goal(new Predicate("main", new Term[] { argList })));
					Scheduler.schedule(agent);
				} catch (AgentCreationException e) {
					e.printStackTrace();
				} catch (ASTRAClassNotFoundException e) {
					e.printStackTrace();
				};					
			}
		};
		task.setOnSucceeded(e -> {
			stateMachine.setCurrentState(StateName.TOURNAMENT_PHASE);
			stateMachine.execute(StateParameters.INIT);
		});
		new Thread(task).start();
	}

	private File chooseSaveLocation() {		
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(FileResources.SAVE_FILE_DESCRIPTION, FileResources.JSON_EXTENSION));
		fileChooser.setTitle(GUIText.SELECT_FILE);
		File file = fileChooser.showSaveDialog(this.sceneContainerStage);
		
        if (file != null) {
            return file;
        }
		
        return null;		
	}

	private int calculateNumberOfPhases() {
		int totalNumberOfRounds = calculateTotalNumberOfRounds();
		
		if (totalNumberOfRounds <= this.numberOfRoundsPerPhase) {
			return 1;
		}
		
		if (totalNumberOfRounds % this.numberOfRoundsPerPhase == 0) {
			return totalNumberOfRounds / this.numberOfRoundsPerPhase;
		} else {
			int remainderRounds = totalNumberOfRounds % this.numberOfRoundsPerPhase;
			int numberOfWholePhases = (totalNumberOfRounds - remainderRounds) / this.numberOfRoundsPerPhase;
			
			return numberOfWholePhases + 1;
		}
	}

	private int calculateTotalNumberOfRounds() {
		int totalNumberOfRounds = 0;
		
		for (int i = 0; i < GUITournamentData.getTournamentData().getRounds().size(); i++) {
			totalNumberOfRounds += GUITournamentData.getTournamentData().getRounds().get(i).getAmount();
		}
		
		return totalNumberOfRounds;
	}
}
