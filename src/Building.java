import java.io.File;

public class Building {

    public static final String[] buildingNames = new String[] {
            "Chicken",
            "Bowl",
            "Frying Pan",
            "Whisk",
            "Spatula",
            "Toppings",
            "Separator",
            "Slicer",
            "Topper",
            "Chef"
    };

    private static final double[] hpsValues = new double[] {
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0
    };

    public final int buildingID;
    private int quantity;
    public double hps;

    public Building(int buildingID) {
        this.buildingID = buildingID;
        this.quantity = 0;
        this.hps = hpsValues[buildingID];
    }

    public Building(String data) {
        String[] values = data.split(FileIO.INDIVIDUAL_SEPARATOR);
        this.buildingID = Integer.parseInt(values[0]);
        this.quantity = Integer.parseInt(values[1]);
        this.hps = hpsValues[buildingID];
    }

    public void add(int numToAdd) {
        quantity += numToAdd;
    }

    public double getTotalHPS() {
        return quantity*hps;
    }

    public String exportInfo() {
        return buildingID + FileIO.INDIVIDUAL_SEPARATOR + quantity;
    }
}
