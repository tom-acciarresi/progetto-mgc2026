package it.unicam.cs.mpgc.rpg130730;

import java.io.IOException;
import org.jspecify.annotations.Nullable;

import it.unicam.cs.mpgc.rpg130730.entities.Player;
import it.unicam.cs.mpgc.rpg130730.environment.Tilemap;
import it.unicam.cs.mpgc.rpg130730.util.CustomImageLoader;
import it.unicam.cs.mpgc.rpg130730.util.GameLoop;
import it.unicam.cs.mpgc.rpg130730.util.GlobalConstants;
import it.unicam.cs.mpgc.rpg130730.util.InputMap;
import it.unicam.cs.mpgc.rpg130730.util.SceneManager;
import it.unicam.cs.mpgc.rpg130730.util.Tuple;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Creates application window and populates it with the first scene
 * <p>
 * Contains game loop
 *
 * @author Tommaso Acciarresi
 */
public class AppLauncher extends Application {

    private Stage stage = new Stage();

    @Override
    public void start(@Nullable Stage defaultStage) throws IOException {
        setSettings(stage);

        SceneManager sceneManager = instantiateSceneManager(stage);

        setInputListeners();

        loadFirstScene(stage, sceneManager);

        GameLoop.startLoop(stage);

        stage.show();
    }

    private void setSettings(Stage stage) {
        // Set Window Settings
        stage.setWidth(GlobalConstants.WINDOW_WIDTH);
        stage.setHeight(GlobalConstants.WINDOW_HEIGHT);
        stage.setTitle(GlobalConstants.APPLICATION_TITLE);
        stage.setResizable(GlobalConstants.IS_RESIZABLE);
        // Set icon
        CustomImageLoader il = new CustomImageLoader();
        stage.getIcons().add(il.loadImage(GlobalConstants.ICON_FILENAME));
    }

    private SceneManager instantiateSceneManager(Stage stage) {
        SceneManager sceneManager = new SceneManager();
        Scene scene = new Scene(sceneManager);
        stage.setScene(scene);

        return sceneManager;
    }

    private void setInputListeners() {
        stage.getScene().setOnKeyPressed(e -> InputMap.getCurrentlyPressedKeys().put(e.getCode(), true));
        stage.getScene().setOnKeyReleased(e -> InputMap.getCurrentlyPressedKeys().put(e.getCode(), false));
    }

    private void loadFirstScene(Stage stage, SceneManager sceneManager) {
        // TODO: Change
        // Add tiles
        Tilemap firstTilemap = new Tilemap("/text/layout.txt");
        sceneManager.addChild(firstTilemap);

        // Add player
        Player tempPlayer = new Player(new Tuple<Double, Double>(
                (GlobalConstants.WINDOW_WIDTH - GlobalConstants.TILE_SIZE) / 2.0,
                (GlobalConstants.WINDOW_HEIGHT - GlobalConstants.TILE_SIZE) / 2.0));
        sceneManager.addChild(tempPlayer);
    }

}
