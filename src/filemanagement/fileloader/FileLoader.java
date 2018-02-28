package filemanagement.fileloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoader {
	private static final String WHITE_SPACE_REGEX = "\\s";
	public static String loadJSONFile(String filePath) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		String tournamentJsonString = bufferedReader.readLine();
		bufferedReader.close();
		
		return tournamentJsonString.replaceAll(WHITE_SPACE_REGEX,"");
	}
}
