package it.unicam.cs.mpgc.rpg130730;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyApplicationView extends Application {
    private final String APPLICATION_TITLE = "TestProject";

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("fxml_example.fxml"));
        Scene scene = new Scene(root, 1920, 1080);

        stage.setTitle(APPLICATION_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}
