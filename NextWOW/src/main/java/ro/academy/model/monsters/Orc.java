package ro.academy.model.monsters;

import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Orc extends Monster {
    public Orc() {
        super(MonsterRaces.ORC, 20, 40, 20, 20, 10);
    }

    @Override
    public String castSpell(Hero enemy) {
        return (race + " slammed a big hammer in your head and caused you serious dizzines");
    }
}
