package heroes;

import items.*;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Ninja extends Hero {
    public Ninja(String name) {
        super(name, 15, 30, 20, 20, new Inventory(new Weapon(15), new ArmourPiece(30, "Wooden plate"),
                new ArmourPiece(3, "Wooden helmet"), new ArmourPiece(5, "Wooden boots"),
                new ArmourPiece(3, "Wooden gauntlets")));
    }
}
