package statemachine.states;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import filemanagement.tempfiles.TempFileWrapper;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;

public class TournamentPhaseState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TempFileWrapper tempFileWrapper;
	
	public TournamentPhaseState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TempFileWrapper tempFileWrapper) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.tempFileWrapper = tempFileWrapper;
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
		
		this.gui.getTournamentPhaseScene().getPhaseDataText().setText(displayTextBuilder.toString());
		
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
		
		this.gui.getTournamentPhaseScene().getPhaseDataText().setText(displayTextBuilder.toString());
		
		this.sceneContainerStage.changeScene(gui.getTournamentPhaseScene());
		this.sceneContainerStage.setTitle(GUIText.TOURNAMENT_PHASE_TEXT);
		
		// TODO Put current phase data in ScrollPane Text
		// Placeholder code:
		
	}
}
