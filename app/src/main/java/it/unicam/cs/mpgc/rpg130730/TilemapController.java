package it.unicam.cs.mpgc.rpg130730;

// import javax.imageio.ImageIO;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class TilemapController {
    public static final int TILE_SIZE = 16;
    public static final int GRID_WIDTH = 10;
    public static final int GRID_HEIGHT = 10;

    @FXML
    GridPane gridPane;

    private ImageView[][] tileset;

    @FXML
    public void initialize() {
        tileset = new ImageView[MyApplicationView.WINDOW_HEIGHT /
                TILE_SIZE][MyApplicationView.WINDOW_WIDTH / TILE_SIZE];

        for (Node node : gridPane.getChildren()) {
            Integer rowIndex = GridPane.getRowIndex(node);
            Integer columnIndex = GridPane.getColumnIndex(node);

            tileset[rowIndex == null ? 0 : rowIndex][columnIndex == null ? 0 : columnIndex] = (ImageView) node;
        }

        Image testImage = new Image(getClass().getResource("testtile.png").toExternalForm());

        for (int i = 0; i < tileset.length; i++) {
            for (int j = 0; j < tileset[0].length; j++) {
                tileset[i][j].setImage(testImage);
            }
        }

        // Image MyMORBINGimage = null;
        // try {
        // MyMORBINGimage = new Image(
        // new FileInputStream(new File("MORB.png")));
        // } catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }

        // if (MyMORBINGimage != null)
        // tileset[0][3].setImage(MyMORBINGimage);
        // else
        // System.err.println("MORB");

        // Image tileset = new Image("test.png");
        // ArrayList<Image> tiles = new ArrayList<>();
        // for (int i = 0; i < TILE_SIZE * GRID_HEIGHT; i += TILE_SIZE) {
        // for (int j = 0; j < TILE_SIZE * GRID_WIDTH; j += TILE_SIZE) {
        // tiles.add()
        // }
        // }
    }
}
