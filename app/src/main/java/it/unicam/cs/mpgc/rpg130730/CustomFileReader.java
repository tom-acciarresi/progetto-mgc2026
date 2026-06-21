package it.unicam.cs.mpgc.rpg130730;

import java.io.IOException;

public class CustomFileReader {

    /**
     * @param filepath - the file path sarting from `resources/[package]/`
     */
    public String readFile(String filepath) {
        try {
            return new String(getClass().getResourceAsStream(filepath).readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
