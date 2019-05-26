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
        PImage background = loadImage("img"+FileIO.FILE_SEPARATOR+"farmbackground.jpg");
        background.resize(width, height);
        eDisplay = new EggDisplay(loadImage("img"+FileIO.FILE_SEPARATOR+"fallingegg.png"), background);
        bDisplay = new BuildingDisplay();
        uDisplay = new UpgradeDisplay();
        huevoManager = new HuevoManager();
        typingManager = new TypingManager();
    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        background(255);   // Clear the screen with a white background
        if (activeDisplay == 0) {
            eDisplay.draw(this);
        } else if (activeDisplay == 1) {
            //bDisplay.draw();
        } else if (activeDisplay == 2) {
            //uDisplay.draw();
        } else {
            throw new IllegalArgumentException("Invalid activeDisplay value: " + activeDisplay);
        }
        handleTypingBar();
        stroke(0);
        fill(255);
        if (activeDisplay == 0 || activeDisplay == 2) {
            rect(0, height/2 - 25, 50, 50);
            line(10, height/2, 40, height/2);
            line(10, height/2, 15, height/2 - 5);
            line(10, height/2, 15, height/2 + 5);
        }
        if (activeDisplay == 0 || activeDisplay == 1) {
            rect(width - 50, height/2 - 25, 50, 50);
            line(width - 10, height/2, width - 40, height/2);
            line(width - 10, height/2, width - 15, height/2 - 5);
            line(width - 10, height/2, width - 15, height/2 + 5);
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
            eDisplay.addfallingegg(width);
        }
    }

    public void mousePressed() {
        boolean leftRegion = mouseX > 0 && mouseX < 50 && mouseY > width/2 - 25 && mouseY < width/2 + 25;
        boolean rightRegion = mouseX > width-50 && mouseX < width && mouseY > width/2 - 25 && mouseY < width/2 + 25;
        if (leftRegion) {
            if (activeDisplay == 0) {
                activeDisplay = 1;
            } else if (activeDisplay == 2) {
                activeDisplay = 0;
            }
        } else if (rightRegion) {
            if (activeDisplay == 0) {
                activeDisplay = 2;
            } else if (activeDisplay == 1) {
                activeDisplay = 0;
            }
        }
    }

}