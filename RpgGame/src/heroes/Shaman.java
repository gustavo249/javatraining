package heroes;

import artefacts.*;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Shaman extends Hero {
    public Shaman(String name) {
        super(name, 10, 20, 20, 30, new Inventory(new Weapon(12), new ArmourPiece(25, ArmourType.ARMOUR),
                new ArmourPiece(2, ArmourType.HELMET), new ArmourPiece(3, ArmourType.BOOTS),
                new ArmourPiece(2, ArmourType.GAUNTLETS)));
    }
}
