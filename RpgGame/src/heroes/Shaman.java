package heroes;

import items.*;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Shaman extends Hero {
    public Shaman(String name) {
        super(name, 10, 20, 20, 30, new Inventory(new Weapon(12), new ArmourPiece(25, "Cotton plate"),
                new ArmourPiece(2, "Cotton helmet"), new ArmourPiece(3, "Cotton boots"),
                new ArmourPiece(2, "Cotton gauntlets")));
    }
}
