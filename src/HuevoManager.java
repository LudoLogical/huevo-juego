import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class HuevoManager {

    private String saveFile;

    private double numHuevos;
    private long lastUpdated;
    private double currentHuevoRate;
    private double huevoMultiplier;

    private ArrayList<Building> buildings;
    private ArrayList<Upgrade> upgrades;

    public HuevoManager(String saveFile) {
        this.saveFile = saveFile;
        this.lastUpdated = System.currentTimeMillis();
        this.buildings = new ArrayList<>();
        this.upgrades = new ArrayList<>();
        this.load();
    }

    /**
     * Calculates and retrieves the number of eggs that
     * the user has at the time of this method call.
     * @return the current number of eggs
     */
    public double getNumHuevos() {
        long now = System.currentTimeMillis();
        double secondsSince = (now-lastUpdated)/1000.0;
        numHuevos += currentHuevoRate*secondsSince*huevoMultiplier;
        lastUpdated = now;
        return numHuevos;
    }

    public void addTypedHuevos() {
        // TODO
    }

    public void addBuildings(int buildingID, int numBuildings) {
        // buildings.get(buildingID).add(numBuildings);
        update();
    }

    public void unlockUpgrade(int upgradeID) {
        // upgrades.get(upgradeIG).unlock();
        update();
    }

    public void update() {
        for (Building b : buildings) {
            // currentHuevoRate += b.getTotalHPS()
        }
        for (Upgrade u : upgrades) {
            // some code with u.getEffect()
        }
    }

    public void save() {
        ArrayList<String> output = new ArrayList<>();
        for (Building b : buildings) {
            output.add(b.exportInfo());
        }
        try {
            FileIO.writeFile(saveFile, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        ArrayList<String> input;
        try {
            input = FileIO.readFile(saveFile);
        } catch (FileNotFoundException e) {
            System.out.println("No source file");
            for (int i = 0; i < Building.buildingNames.length; i++) {
                buildings.add(new Building(i));
            }
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < Building.buildingNames.length; i++) {
            buildings.add(new Building(input.get(i)));
        }
    }

}
