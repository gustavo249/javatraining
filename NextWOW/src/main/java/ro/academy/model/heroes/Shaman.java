package ro.academy.model.heroes;

import ro.academy.model.artefacts.*;
import ro.academy.model.races.HeroRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Shaman extends Hero {
    public Shaman(String name) {
        super(name, HeroRaces.SAMAN, 10, 32, 20, 30, new Inventory(new Weapon(10), new ArmourPiece(25, ArmourType.ARMOUR),
                new ArmourPiece(2, ArmourType.HELMET), new ArmourPiece(3, ArmourType.BOOTS),
                new ArmourPiece(2, ArmourType.GAUNTLETS)));
    }
}
