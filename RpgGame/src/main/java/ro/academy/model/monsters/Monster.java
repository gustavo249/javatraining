package ro.academy.model.monsters;

import ro.academy.controller.battle.FightingBehavior;
import ro.academy.model.base.Character;
import ro.academy.model.heroes.Hero;
import ro.academy.model.races.MonsterRaces;

import java.util.Random;

/**
 * Created by Gustavo on 10/04/2016.
 */
public  class Monster extends Character implements FightingBehavior {
    protected MonsterRaces race;
    protected int xp = ((level / 4) + 1) * 5;

    public Monster(MonsterRaces race, int strength, int defense, int agility, int intelligence, int xp) {
        super(strength, defense, agility, intelligence);
        this.race = race;
        this.xp += xp * 4;
    }

    @Override
    public void move() {
        System.out.println(race + " got closer to you and your heart has begun to pump really fast");
    }

    @Override
    public String dodge() {
        return (race + " managed to dodge the attack");
    }

    public String attack(int damage, Hero hero) {
        String hit = race + " dealt " + damage + " with a special ability";
        hero.setHitPoints(hero.getHitPoints() - damage);
        return hit;
    }

    public void concede() {
        System.out.println(race + " is too afraid to continue the fight");
    }

    public String castSpell(Hero enemy) {
        StringBuilder raport = new StringBuilder();
        int variance = new Random().nextInt(100 - 80) + 80;
        raport.append(attack(variance + level * 5, enemy));
        return raport.toString();
    }

    public MonsterRaces getRace() {
        return race;
    }

    public void setRace(MonsterRaces race) {
        this.race = race;
    }

    public int getXp() {
        return xp;
    }
}
