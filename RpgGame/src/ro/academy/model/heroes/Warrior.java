package ro.academy.model.heroes;

import ro.academy.model.artefacts.ArmourPiece;
import ro.academy.model.artefacts.ArmourType;
import ro.academy.model.artefacts.Inventory;
import ro.academy.model.artefacts.Weapon;
import ro.academy.model.races.HeroRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Warrior extends Hero {

    public Warrior(String name) {
        super(name, HeroRaces.WARRIOR,  20, 40, 20, 15,
                new Inventory(new Weapon(20), new ArmourPiece(40, ArmourType.ARMOUR),
                new ArmourPiece(5, ArmourType.HELMET), new ArmourPiece(8, ArmourType.BOOTS),
                new ArmourPiece(5, ArmourType.GAUNTLETS)));
    }
}
