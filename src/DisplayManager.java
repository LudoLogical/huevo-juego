import processing.core.PApplet;
import processing.core.PImage;

public class DisplayManager extends PApplet {

    private EggDisplay eDisplay;
    private BuildingDisplay bDisplay;
    private UpgradeDisplay uDisplay;
    private int activeDisplay = 0;

    private HuevoManager huevoManager;
    private TypingManager typingManager;

    public DisplayManager() {

    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup() {
        eDisplay = new EggDisplay(loadImage("img"+FileIO.FILE_SEPARATOR+"fallingegg.png"));
        bDisplay = new BuildingDisplay();
        uDisplay = new UpgradeDisplay();
        huevoManager = new HuevoManager("example.egg");
        typingManager = new TypingManager();
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        background(255);   // Clear the screen with a white background
        handleTypingBar();
        if (activeDisplay == 0) {
            eDisplay.draw(this);
        } else if (activeDisplay == 1) {
            //bDisplay.draw();
        } else if (activeDisplay == 2) {
            //uDisplay.draw();
        } else {
            throw new IllegalArgumentException("Invalid activeDisplay value: " + activeDisplay);
        }
    }

    private void handleTypingBar() {
        typingManager.draw(this);
        huevoManager.draw(this);
    }

    public void keyPressed() {
        boolean addHuevos = typingManager.acceptInput(this);
        if (addHuevos) {
            huevoManager.addTypedHuevos();
            eDisplay.addfallingegg();
        }
    }

}