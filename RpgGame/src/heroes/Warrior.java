package heroes;

import artefacts.ArmourPiece;
import artefacts.ArmourType;
import artefacts.Inventory;
import artefacts.Weapon;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, 20, 40, 20, 15,
                new Inventory(new Weapon(20), new ArmourPiece(40, ArmourType.ARMOUR),
                new ArmourPiece(5, ArmourType.HELMET), new ArmourPiece(8, ArmourType.BOOTS),
                new ArmourPiece(5, ArmourType.GAUNTLETS)));
    }
}
