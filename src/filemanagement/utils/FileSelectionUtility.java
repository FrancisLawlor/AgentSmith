package filemanagement.utils;

import java.io.File;

import gui.utils.GUIText;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileSelectionUtility {
	public static File chooseFile(Stage sceneContainerStage) {		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(GUIText.SELECT_FILE);
		File file = fileChooser.showOpenDialog(sceneContainerStage);
		
        if (file != null) {
            return file;
        }
		
        return null;		
	}
}
