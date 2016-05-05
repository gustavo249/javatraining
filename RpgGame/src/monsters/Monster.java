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
        super(1, 100, strength, defense, agility, intelligence);
        this.race = race;
        this.level = 1;
        this.hitPoints = 1000 + level * 10;
        this.strength = strength + level;
        this.defense = defense + level;
    }

    @Override
    public void move() {
        System.out.println(race + " got closer to you and your heart has begun to pump really fast");
    }

    @Override
    public void dodge() {
        System.out.println(race + " managed to dodge the attack");
    }

    public void attack(Hero hero) {
        Random r = new Random();
        int variance = r.nextInt(1800 - 1600) + 1600;
        int totalDamage = (strength * level + variance) / 6 - hero.getDefense();
        System.out.println(race + " caused " + totalDamage + " damage to " + hero.getName());
        hero.setHitPoints(hero.getHitPoints() - totalDamage);

        System.out.println(hero.getName() + " has " + hero.getHitPoints() + " hp left ");
    }

    public void attack(int damage, Hero hero) {
        System.out.println(race + " dealt " + damage + " with a special ability");
        hero.setHitPoints(hero.getHitPoints() - damage);
    }

    public void concede() {
        System.out.println(race + " is too afraid to continue the fight");
    }

    public void castSpell(Hero enemy) {
        int variance = new Random().nextInt(80 - 60) + 60;
        attack(variance + level, enemy);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public MonsterRaces getRace() {
        return race;
    }

    public void setRace(MonsterRaces race) {
        this.race = race;
    }
}
