package monsters;

import heroes.Hero;
import races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Undead extends Monster {

    public Undead() {
        super(MonsterRaces.UNDEAD, 30, 20, 20, 20);
    }

    @Override
    public void castSpell(Hero enemy) {
        System.out.println(race + " marked you as dead you now have a little chance to survive");
        super.castSpell(enemy);
    }
}
