import processing.core.PApplet;

public class DisplayManager extends PApplet {

    private EggDisplay eDisplay;
    private BuildingDisplay bDisplay;
    private UpgradeDisplay uDisplay;
    private int activeDisplay = 0;

    private HuevoManager manager;

    public DisplayManager() {
        eDisplay = new EggDisplay();
        bDisplay = new BuildingDisplay();
        uDisplay = new UpgradeDisplay();
        manager = new HuevoManager("example.egg");
    }

    // The statements in the setup() function
    // execute once when the program begins
    public void setup() {

    }

    // The statements in draw() are executed until the
    // program is stopped. Each statement is executed in
    // sequence and after the last line is read, the first
    // line is executed again.
    public void draw() {
        background(255);   // Clear the screen with a white background
        handleTypingBar();
        if (activeDisplay == 0) {
            //eDisplay.draw();
        } else if (activeDisplay == 1) {
            //bDisplay.draw();
        } else if (activeDisplay == 2) {
            //uDisplay.draw();
        } else {
            throw new IllegalArgumentException("Invalid activeDisplay value: " + activeDisplay);
        }
    }

    private void handleTypingBar() {
        noStroke();
        fill(200,200,200);
        rect(0, height/2 - 50/2, width-1, 50);
        stroke(120,120,120);
        fill(0,0,0);
        textSize(40);
        textAlign(CENTER, CENTER);
        text("This is a sample.", width/2, height/2 - 3);
    }

}