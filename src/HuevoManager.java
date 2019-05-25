import java.util.ArrayList;

public class HuevoManager {

    private double numHuevos;
    private long lastUpdated = System.currentTimeMillis();
    private double currentHuevoRate;
    private double huevoMultiplier;
    private ArrayList<Building> buildings;
    private ArrayList<Upgrade> upgrades;

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

}
