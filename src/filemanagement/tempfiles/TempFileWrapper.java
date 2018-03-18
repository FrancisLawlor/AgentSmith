package filemanagement.tempfiles;

import java.io.File;

public class TempFileWrapper {
	private File tempFile;
	
	public TempFileWrapper(File tempFile) {
		this.tempFile = tempFile;
	}

	public void setTempFile(File tempFile) {
		this.tempFile = tempFile;
	}
	
	public File getTempFile() {
		return this.tempFile;
	}
}
