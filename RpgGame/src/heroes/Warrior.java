package heroes;

import items.ArmourPiece;
import items.Inventory;
import items.Weapon;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, 20, 40, 20, 15,
                new Inventory(new Weapon(20), new ArmourPiece(40, "Steel plate"),
                new ArmourPiece(5, "Iron helmet"), new ArmourPiece(8, "Iron boots"),
                new ArmourPiece(5, "Iron gauntlets")));
    }
}
