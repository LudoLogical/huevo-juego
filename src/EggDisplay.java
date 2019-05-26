import java.awt.geom.Point2D;
import java.util.ArrayList;

public class EggDisplay {
    private static int eggX;
    private static int eggY;
    public EggDisplay(){
        eggX= (int)(Math.random() * 500) + 1;
        eggY=0;
    }
    public static void addfallingegg(){
        eggY++;
        ArrayList<Point2D.Float> eggCoordinates= new ArrayList<>();
        eggCoordinates.add(new Point2D.Float(eggX, eggY));

    }
}
