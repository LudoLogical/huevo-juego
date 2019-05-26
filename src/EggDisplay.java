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
    public void addfallingegg(){
        eggCoordinates.add(new Point2D.Float((float)(Math.random() * 500) + 1, 23));
    }
    public void draw(PApplet source){
        for (int i = 0; i < eggCoordinates.size(); i++) {
            Point2D.Float nowPoint = eggCoordinates.get(i);
            nowPoint.y++;
            source.image(fallingegg, nowPoint.x, nowPoint.y);
            if (nowPoint.y>=450)
            {
                eggCoordinates.remove(i);
            }
        }


    }
}