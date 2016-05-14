package ro.academy.model.monsters;

import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Skeleton extends Monster {
    public Skeleton() {
        super(MonsterRaces.SKELETON, 50, 20, 20, 20, 12);
    }

    @Override
    public String castSpell(Hero enemy) {
        return (race + " with a great hunger has begun to eat you alive, if you don't fight back you'll die");
    }
}
