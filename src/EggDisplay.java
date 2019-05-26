import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class EggDisplay {
    ArrayList<Point2D.Float> eggCoordinates;
    private PImage fallingegg;
    public EggDisplay(PImage eggfalling){
        eggCoordinates = new ArrayList<>();
        fallingegg = eggfalling;
    }
    public void addfallingegg(int width){
        eggCoordinates.add(new Point2D.Float((float)(Math.random() * width) + 1, 50-27));
    }
    public void draw(PApplet source){
        for (int i = 0; i < eggCoordinates.size(); i++) {
            Point2D.Float nowPoint = eggCoordinates.get(i);
            nowPoint.y++;
            source.image(fallingegg, nowPoint.x, nowPoint.y);
            if (nowPoint.y >= source.height - 50) {
                eggCoordinates.remove(i);
                i--;
            }
        }


    }
}