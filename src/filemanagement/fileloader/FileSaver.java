package filemanagement.fileloader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSaver {
	public static void saveJsonStringToFile(String jsonString, String filePath) throws IOException {
		FileWriter fileWriter = null;
		
		fileWriter = new FileWriter(new File(filePath));
		fileWriter.write(jsonString);
		fileWriter.close();
	}
}