package artefacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Inventory {
    private List<Item> additionalItems = new ArrayList<>();
    private int gold;
    private Weapon weapon;
    private ArmourPiece plate;
    private ArmourPiece helmet;
    private ArmourPiece boots;
    private ArmourPiece gauntlets;

    public Inventory(Weapon weapon, ArmourPiece plate, ArmourPiece helmet,
                     ArmourPiece boots, ArmourPiece gauntlets) {
        this.gold = 500;
        this.weapon = weapon;
        this.plate = plate;
        this.helmet = helmet;
        this.boots = boots;
        this.gauntlets = gauntlets;
    }

    public void equip(Item item) {
        if (item instanceof  Weapon) {
            this.weapon = (Weapon) item;
        } else {
            ArmourPiece armourPiece = (ArmourPiece) item;
            switch (armourPiece.getType()) {
                case ARMOUR:
                    this.plate = armourPiece;
                    break;
                case HELMET:
                    this.helmet = armourPiece;
                    break;
                case BOOTS:
                    this.boots = armourPiece;
                    break;
                case GAUNTLETS:
                    this.gauntlets = armourPiece;
                    break;
            }
        }
    }

    public void sell(Item item) {
        gold += item.sellItem();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "gold=" + gold +
                ", weapon=" + weapon +
                ",\n plate=" + plate +
                ", helmet=" + helmet +
                ", boots=" + boots +
                ", gauntlets=" + gauntlets +
                '}';
    }
}
