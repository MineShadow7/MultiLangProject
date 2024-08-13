package org.echo.javafxui;

import com.sun.jna.Native;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        String libraryPath = JNAClasspathLoader.loadLibraryFromClasspath("libbackend.so");
        BackendLibrary backendLibrary = Native.load(libraryPath, BackendLibrary.class);
        backendLibrary.greet();
    }
}
