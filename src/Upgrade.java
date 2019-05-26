import org.jetbrains.annotations.Contract;

public class Upgrade {

    public static final String[] upgradeNames = new String[] {
            "Boiled Egg",
            "Fried Egg",
            "Poached Egg",
            "Scrambled Egg",
            "Egg Tart",
            "Deviled Egg",
            "Century Egg",
            "Eggs Benedict",
            "Tea Egg"
    };

    private static final double[] hpsEffect = new double[] {

    };

    public final int upgradeID;
    public int GlobalMultiplierEffect = 1;
    private boolean unlocked;

    public Upgrade(int upgradeID) {
        this.upgradeID = upgradeID;
    }

    public Upgrade(String data) {
        String[] values = data.split(FileIO.ENTRY_SEPARATOR);
        this.upgradeID = Integer.parseInt(values[0]);
        this.unlocked = Boolean.parseBoolean(values[1]);
    }

    public void unlock() {
        this.unlocked = true;
    }

    public void getEffect()
    {

    }

    public String exportInfo() {
        return upgradeID + FileIO.ENTRY_SEPARATOR + this.unlocked;
    }
}
