package statemachine.states;

import java.io.File;
import java.io.IOException;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import filemanagement.fileloader.FileSaver;
import filemanagement.utils.FileResources;
import gui.core.SceneContainerStage;
import gui.utils.GUIText;
import javafx.stage.FileChooser;
import statemachine.core.StateMachine;
import statemachine.utils.StateName;
import statemachine.utils.StateParameters;
import tournament.data.TournamentData;

public class SaveTournamentFileState extends State {
	private StateMachine stateMachine;
	private SceneContainerStage sceneContainerStage;
	private TournamentData GUItournamentData;
	private File file;
	
	public SaveTournamentFileState(StateMachine stateMachine, SceneContainerStage sceneContainerStage, TournamentData GUItournamentData) {
		this.stateMachine = stateMachine;
		this.sceneContainerStage = sceneContainerStage;
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
		this.sceneContainerStage.setTitle(GUIText.SAVE_TOURNAMENT);
		
		this.file = chooseSaveLocation();
		
		if (this.file != null) {
			fileSelected(this.file.getPath());
		} else {
			cancelledFileSelection();
		}
	}

	private void fileSelected(String filePath) {
		try {
			Gson gsonUtility = new GsonBuilder()
					.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
					.create();
						
			FileSaver.saveJsonStringToFile(gsonUtility.toJson(this.GUItournamentData), filePath);
			
			this.stateMachine.setCurrentState(StateName.DASHBOARD);
			this.stateMachine.execute(StateParameters.INIT);
		} catch (SecurityException | IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void cancelledFileSelection() {
		this.stateMachine.setCurrentState(StateName.DASHBOARD);
		this.stateMachine.execute(StateParameters.INIT);
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
}
