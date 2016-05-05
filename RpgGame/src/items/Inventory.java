package items;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Inventory {
    private Weapon weapon;
    private ArmourPiece plate;
    private ArmourPiece helmet;
    private ArmourPiece boots;
    private ArmourPiece gauntlets;

    public Inventory(Weapon weapon, ArmourPiece plate, ArmourPiece helmet,
                     ArmourPiece boots, ArmourPiece gauntlets) {
        this.weapon = weapon;
        this.plate = plate;
        this.helmet = helmet;
        this.boots = boots;
        this.gauntlets = gauntlets;
    }

    public Inventory() {
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArmourPiece getPlate() {
        return plate;
    }

    public void setPlate(ArmourPiece plate) {
        this.plate = plate;
    }

    public ArmourPiece getHelmet() {
        return helmet;
    }

    public void setHelmet(ArmourPiece helmet) {
        this.helmet = helmet;
    }

    public ArmourPiece getBoots() {
        return boots;
    }

    public void setBoots(ArmourPiece boots) {
        this.boots = boots;
    }

    public ArmourPiece getGauntlets() {
        return gauntlets;
    }

    public void setGauntlets(ArmourPiece gauntlets) {
        this.gauntlets = gauntlets;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "weapon=" + weapon +
                ", plate=" + plate +
                ", helmet=" + helmet +
                ", boots=" + boots +
                ", gauntlets=" + gauntlets +
                '}';
    }
}
