package ro.academy.model.monsters;

import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Orc extends Monster {
    public Orc() {
        super(MonsterRaces.ORC, 20, 40, 20, 20);
    }

    @Override
    public void castSpell(Hero enemy) {
        System.out.println(race + " slammed a big hammer in your head and caused you serious dizzines");
        super.castSpell(enemy);
    }
}
