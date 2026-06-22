package it.unicam.cs.mpgc.rpg130730.environment;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tile extends StackPane {
    private Rectangle sprite = new Rectangle(64,64);
    // private boolean isCollidable;

    public Tile() {
        getChildren().add(sprite);
    }

    public void setSprite(ImagePattern img) {
        sprite.setFill(img);
    }

    public Rectangle getSprite() {
        return this.sprite;
    }
}
