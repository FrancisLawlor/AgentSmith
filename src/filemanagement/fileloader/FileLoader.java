package filemanagement.fileloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
	public static String loadJSONFile(String filePath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String tournamentJsonString = bufferedReader.readLine();
		bufferedReader.close();
		
		return tournamentJsonString;
	}
}
