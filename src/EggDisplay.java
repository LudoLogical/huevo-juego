import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class EggDisplay {
    private int eggX;
    private int eggY;
    private PImage fallingegg;
    public EggDisplay(PImage eggfalling){
        eggX= (int)(Math.random() * 500) + 1;
        eggY=0;
        fallingegg = eggfalling;
    }
    public void addfallingegg(){
        eggY++;
        ArrayList<Point2D.Float> eggCoordinates = new ArrayList<>();
        eggCoordinates.add(new Point2D.Float(eggX, eggY));
    }
    public void draw(PApplet source){
        source.image(fallingegg, eggX, eggY);
    }
}