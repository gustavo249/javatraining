package monsters;

import battle.system.FightingBehavior;
import game.Character;
import heroes.Hero;
import races.MonsterRaces;

import java.util.Random;

/**
 * Created by Gustavo on 10/04/2016.
 */
public  class Monster extends Character implements FightingBehavior {
    protected MonsterRaces race;

    public Monster(MonsterRaces race, int strength, int defense, int agility, int intelligence) {
        super(strength, defense, agility, intelligence);
        this.race = race;
    }

    @Override
    public void move() {
        System.out.println(race + " got closer to you and your heart has begun to pump really fast");
    }

    @Override
    public void dodge() {
        System.out.println(race + " managed to dodge the attack");
    }

    public void attack(int damage, Hero hero) {
        System.out.println(race + " dealt " + damage + " with a special ability");
        hero.setHitPoints(hero.getHitPoints() - damage);
    }

    public void concede() {
        System.out.println(race + " is too afraid to continue the fight");
    }

    public void castSpell(Hero enemy) {
        int variance = new Random().nextInt(100 - 80) + 80;
        attack(variance + level * 5, enemy);
    }

    public MonsterRaces getRace() {
        return race;
    }

    public void setRace(MonsterRaces race) {
        this.race = race;
    }
}
