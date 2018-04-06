package statemachine.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import filemanagement.tempfiles.TempFileWrapper;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.concurrent.Task;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentDataWrapper;

public class TournamentPhaseState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TempFileWrapper tempFileWrapper;
	private TournamentDataWrapper GUITournamentData;
	private boolean first = true;
	private boolean firstContinue = true;
	
	public TournamentPhaseState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUITournamentData, TempFileWrapper tempFileWrapper) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.tempFileWrapper = tempFileWrapper;
		this.GUITournamentData = GUITournamentData;
	}

	public void execute(StateParameters param) {		
		switch (param) {
			case INIT:
				init();
				break;
			case CLICK_CONTINUE:
				clicksContinue();
				break;
			case RETURN:
				phaseFinished();
				break;
			default:
				break;
		}
	}

	private void phaseFinished() {
		String line = null;
		StringBuilder displayTextBuilder = new StringBuilder();
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(tempFileWrapper.getTempFile().getAbsolutePath());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				displayTextBuilder.append(line);
			}
			
			bufferedReader.close(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		java.lang.reflect.Type type = new TypeToken<Map<String, Float>>(){}.getType();
		Map<String, Float> displayData = gsonUtility.fromJson(displayTextBuilder.toString(), type);
		
		if (firstContinue) {
			this.gui.getTournamentPhaseScene().getPhaseDataText().setText(GUIText.WAITING_FOR_DATA);
			firstContinue = false;
		} else {
			this.gui.getTournamentPhaseScene().updateRoundData(displayData);
		}
			
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);		
	}

	private void clicksContinue() {
		stateMachine.setCurrentState(StateName.TOURNAMENT_PLAYING);
		stateMachine.execute(StateParameters.RETURN);
	}

	private void init() {
		String line = null;
		StringBuilder displayTextBuilder = new StringBuilder();
		
		FileReader fileReader;
		try {
			fileReader = new FileReader(tempFileWrapper.getTempFile().getAbsolutePath());
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				displayTextBuilder.append(line);
			}
			
			bufferedReader.close(); 
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		if (first) {
			Task<Void> task = new Task<Void>() {
				@Override
				public Void call() throws Exception {
					disableButton();
					return null;
				}

				private void disableButton() throws InterruptedException {
					gui.getTournamentPhaseScene().getContinueButton().setDisable(true);
					int amount = 0;
					
					for (int i = 0; i < GUITournamentData.getTournamentData().getAgents().size(); i++) {
						amount += GUITournamentData.getTournamentData().getAgents().get(i).getAmount();
					}
					
					Thread.sleep(500 * amount);					
				}
			};
			task.setOnSucceeded(e -> {	
				this.gui.getTournamentPhaseScene().getContinueButton().setDisable(false);
				first = false;
			});
			
			new Thread(task).start();
		}
		this.gui.getTournamentPhaseScene().getPhaseDataText().setText(GUIText.WAITING_FOR_AGENTS);
		
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);
	}
}
