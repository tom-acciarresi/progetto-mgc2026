package it.unicam.cs.mpgc.rpg130730.util;

import java.util.HashMap;

import javafx.scene.input.KeyCode;

public class InputMap {
        public static HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

        public static HashMap<KeyCode, Boolean> getCurrentlyPressedKeys() {
            return keys;
        }
}
