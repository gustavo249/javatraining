package ro.academy.model.monsters;

import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Undead extends Monster {

    public Undead() {
        super(MonsterRaces.UNDEAD, 30, 20, 20, 20, 11);
    }

    @Override
    public String castSpell(Hero enemy) {
        return (race + " marked you as dead you now have a little chance to survive");
    }
}
