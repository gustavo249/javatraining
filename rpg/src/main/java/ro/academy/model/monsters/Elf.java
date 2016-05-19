package ro.academy.model.monsters;

import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Elf extends Monster {
    public Elf() {
        super(MonsterRaces.ELF, 30, 30, 20, 20, 13);
    }

    @Override
    public String castSpell(Hero enemy) {
        return (race + " casted a big sand wave which can break all your bones so be careful next time");
    }
}
