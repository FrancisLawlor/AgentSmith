package statemachine.states;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import filemanagement.fileloader.FileLoader;
import gui.core.GUI;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.stage.FileChooser;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentData;
import tournament.data.TournamentDataWrapper;

public class LoadTournamentFileState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private GUI gui;
	private TournamentDataWrapper GUItournamentData;
	private File file;
	
	public LoadTournamentFileState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, GUI gui, TournamentDataWrapper GUItournamentData) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
		this.gui = gui;
		this.GUItournamentData = GUItournamentData;
	}

	@Override
	public void execute(StateParameters param) {
		switch (param) {
			case INIT:
				init();
				break;
			default:
				break;
		}
	}
	
	private void init() {
		this.sceneContainerStage.setTitle(GUIText.LOAD_TOURNAMENT);
		
		this.file = chooseFile();
		
		if (this.file != null) {
			fileSelected(this.file.getPath());
		} else {
			cancelledFileSelection();
		}
	}

	private void fileSelected(String filePath) {
		try {
			String tournamentDataJsonString = FileLoader.loadJSONFile(filePath);
			
			Gson gsonUtility = new GsonBuilder()
					.setLenient()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.create();
			
			this.GUItournamentData.setTournamentData(gsonUtility.fromJson(tournamentDataJsonString, TournamentData.class));
			this.gui.updateTournamentData(this.GUItournamentData.getTournamentData());
						
			this.stateMachine.setCurrentState(StateName.DASHBOARD);
			this.stateMachine.execute(StateParameters.INIT);
		} catch (IOException | ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
	}

	private File chooseFile() {		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(GUIText.SELECT_FILE);
		File file = fileChooser.showOpenDialog(this.sceneContainerStage);
		
        if (file != null) {
            return file;
        }
		
        return null;		
	}
}
