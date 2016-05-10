package ro.academy.model.heroes;

import ro.academy.model.artefacts.*;
import ro.academy.model.races.HeroRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Ninja extends Hero {
    public Ninja(String name) {
        super(name, HeroRaces.NINJA,  15, 30, 20, 20, new Inventory(new Weapon(15), new ArmourPiece(30, ArmourType.ARMOUR),
                new ArmourPiece(3, ArmourType.HELMET), new ArmourPiece(5, ArmourType.BOOTS),
                new ArmourPiece(3, ArmourType.GAUNTLETS)));
    }
}
