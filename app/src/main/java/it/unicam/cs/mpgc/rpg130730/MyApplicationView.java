package it.unicam.cs.mpgc.rpg130730;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;

public class MyApplicationView extends Application {
    private static final boolean IS_FULLSCREEN = false;
    public static final boolean IS_RESIZABLE = true;

    public static final int WINDOW_WIDTH = 192;
    public static final int WINDOW_HEIGHT = 160;

    @Override
    public void start(Stage stage) throws IOException {
        Stage root = new Stage(StageStyle.DECORATED);
        root.setResizable(IS_RESIZABLE);
        root.setWidth(WINDOW_WIDTH);
        root.setHeight(WINDOW_HEIGHT);
        root.setFullScreen(IS_FULLSCREEN);

        double scalingFactor = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / WINDOW_HEIGHT;
        if (scalingFactor < 1)
            throw new IllegalStateException("Screen size too small");
        root.setForceIntegerRenderScale(true);
        root.setRenderScaleY(scalingFactor);
        root.setRenderScaleX(scalingFactor);

        root.setScene(FXMLLoader.load(getClass().getResource("tilegrid.fxml")));
        root.show();
    }
}
