package org.echo.javafxui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        NativeBackend backend = new NativeBackend();
        backend.greet();
    }
}
