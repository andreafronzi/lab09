package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * Application controller. Performs the I/O.
 */
@SuppressWarnings("MissingJavadocMethod")
public final class Controller {

    private static final String DEFAULT_FILE_NAME = "output.txt";
    private static final String DEFAULT_PATH =
        System.getProperty("user.home") 
        + System.getProperty("file.separator")
        + DEFAULT_FILE_NAME;

    private File currentFile;

    public Controller() {
        this.currentFile = new File(DEFAULT_PATH);
    }

    public void setCurrentFile(final File file) {
        this.currentFile = file;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getPath() {
        return this.currentFile.toPath().toString();
    }

    public void setFileContent(final String content) throws IOException {
        try (DataOutputStream outputFile = new DataOutputStream(new FileOutputStream(this.getPath()));) {
            outputFile.writeUTF(content);
        }   
    }
//CHECKSTYLE MissingJavadocMethod ON
}
