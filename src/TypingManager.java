import processing.core.PApplet;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

public class TypingManager {

    public static ArrayList<String> nouns = null;
    static {
        try {
            nouns = FileIO.readFile("data/nouns.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> adjectives = null;
    static {
        try {
            adjectives = FileIO.readFile("data/adjectives.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> verbs = null;
    static {
        try {
            verbs = FileIO.readFile("data/verbs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> adverbs = null;
    static {
        try {
            adverbs = FileIO.readFile("data/adverbs.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String currentPhrase = "Welcome";
    private int currentIndex;
    private int backspacesRequired;

    public TypingManager() {
        pickNewPhrase();
        currentIndex = 0;
        backspacesRequired = 0;
    }

    private void pickNewPhrase() {
        currentPhrase = adjectives.get((int)(Math.random()*adjectives.size()));
        currentPhrase += " " + nouns.get((int)(Math.random()*nouns.size()));
        //currentPhrase += " " + verbs.get((int)(Math.random()*verbs.size()));
        //currentPhrase += " " + adverbs.get((int)(Math.random()*adverbs.size()));
    }

    public boolean acceptInput(PApplet source) {
        if (source.keyCode == source.SHIFT || source.keyCode == source.CONTROL || source.keyCode == source.ALT) {
            return false; // don't want to handle here
        }
        if (backspacesRequired > 0) {
            if (source.key == source.BACKSPACE) {
                backspacesRequired--;
            } else if (currentIndex + backspacesRequired < currentPhrase.length()) { // not @ end of word
                backspacesRequired++;
            }
        } else if (source.key == currentPhrase.charAt(currentIndex)) {
            currentIndex++;
            if (currentIndex == currentPhrase.length()) {
                pickNewPhrase();
                currentIndex = 0;
            }
            return true;
        } else if (source.key != source.BACKSPACE) {
            backspacesRequired++;
        }
        return false;
    }

    public void draw(PApplet source) {

        source.textSize(40);
        source.textAlign(source.LEFT, source.CENTER);

        float totalWidth = source.textWidth(currentPhrase);
        float left = (float)source.width/2 - totalWidth/2;
        float height = (float)source.height/2 - 3;

        String typed = currentPhrase.substring(0, currentIndex);
        String backspace = currentPhrase.substring(currentIndex, currentIndex + backspacesRequired);
        String remaining = currentPhrase.substring(currentIndex + backspacesRequired);

        source.fill(0,0,0);
        source.text(typed, left, height);
        source.fill(255,0,0);
        source.text(backspace, left + source.textWidth(typed), height);
        source.fill(120,120,120);
        source.text(remaining, left + source.textWidth(typed + backspace), height);
    }
}
