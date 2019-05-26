import processing.core.PApplet;
import processing.core.PImage;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class EggDisplay {
    ArrayList<Point2D.Float> eggCoordinates;
    private PImage fallingegg;
    private PImage farmbackground;
    public EggDisplay(PImage eggfalling, PImage background){
        eggCoordinates = new ArrayList<>();
        fallingegg = eggfalling;
        farmbackground= background;

    }
    public void addfallingegg(){
        eggCoordinates.add(new Point2D.Float((float)(Math.random() * 500) + 1, 23));
    }
    public void draw(PApplet source){
        source.background(farmbackground);

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