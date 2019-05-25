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
    private double hps;

    public Building(int buildingID) {
        this.buildingID = buildingID;
        this.quantity = 0;
        this.hps = hpsValues[buildingID];
    }

    public void add(int numToAdd) {
        quantity += numToAdd;
    }

    public double getTotalHPS() {
        return quantity*hps;
    }

}
