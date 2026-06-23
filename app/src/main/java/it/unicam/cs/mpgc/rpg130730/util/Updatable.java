package it.unicam.cs.mpgc.rpg130730.util;

/**
 * Implementers have access to the game loop `update()` method
 *
 * @author Tommaso Acciarresi
 */
public interface Updatable {
    public default void subscribeToUpdates() {
        GameLoop.subscribeToUpdates(this);
    };

    public void update(double timeDelta);
}
