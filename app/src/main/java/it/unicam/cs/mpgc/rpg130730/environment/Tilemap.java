package it.unicam.cs.mpgc.rpg130730.environment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import it.unicam.cs.mpgc.rpg130730.util.CustomFileReader;
import it.unicam.cs.mpgc.rpg130730.util.Tuple;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;

/**
 * Draws tiles in a grid
 *
 * @author Tommaso Acciarresi
 */
public class Tilemap extends GridPane {
    private static final String TILE_INFO_FILE = "/text/tiles.json";
    private static final String TILE_DIR_PREFIX = "/images/tiles/";
    public static final int TILE_SIZE = 64;
    public static final int GRID_WIDTH = 12;
    public static final int GRID_HEIGHT = 10;

    private HashMap<Integer, ImagePattern> tileDictionary = new HashMap<Integer, ImagePattern>();

    private Tile[][] tiles = new Tile[GRID_HEIGHT][GRID_WIDTH];

    public Tilemap() {
        instantiateTiles();

        loadTileSpritesWithJSON();
    }

    public Tilemap(String filepath) {
        this();
        setTileMapTo(loadTileBitmapFromTextFile(filepath));
    }

    private void instantiateTiles() {
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                Tile newTile = new Tile();
                tiles[i][j] = newTile;
                this.add(newTile, j, i);
            }
        }
    }

    private void loadTileSpritesWithJSON() {
        Gson gson = new Gson();
        CustomFileReader fr = new CustomFileReader();
        String fileOut = fr.readFile(TILE_INFO_FILE);

        TypeToken<ArrayList<HashMap<String, String>>> mapType = new TypeToken<ArrayList<HashMap<String, String>>>() {
        };
        ArrayList<HashMap<String, String>> map = gson.fromJson(fileOut, mapType);
        for (HashMap<String, String> tileData : map) {
            tileDictionary.put(Integer.valueOf(tileData.get("index")), new ImagePattern(
                    new Image(getClass().getResource(TILE_DIR_PREFIX + tileData.get("fileName")).toExternalForm())));
        }
    }

    public void setTileMapTo(String filepath) {
        setTileMapTo(loadTileBitmapFromTextFile(filepath));
    }

    private void setTileMapTo(int[] tileLayoutBitmap) {
        for (int i = 0; i < GRID_HEIGHT; i++) {
            for (int j = 0; j < GRID_WIDTH; j++) {
                ImagePattern newSprite = tileDictionary.get(tileLayoutBitmap[i * GRID_WIDTH + j]);

                if (newSprite == null) {
                    System.err.println("Null sprite");
                    return;
                }

                tiles[i][j].getSprite().setFill(newSprite);
            }
        }
    }

    public void setTile(Tuple<Integer, Integer> coords, ImagePattern img) {
        tiles[coords.x][coords.y].getSprite().setFill(img);
    }

    private int[] loadTileBitmapFromTextFile(String filepath) {
        CustomFileReader fr = new CustomFileReader();
        String out = fr.readFile(filepath).replaceAll("\n", " ");
        int[] array = Arrays.stream(out.split(" ")).mapToInt(Integer::parseInt).toArray();

        if (array == null) {
            System.err.println("Null array");
            return new int[0];
        }

        return array;
    }
}
