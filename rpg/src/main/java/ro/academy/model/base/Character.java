package ro.academy.model.base;

import ro.academy.model.heroes.Hero;
import ro.academy.model.monsters.Monster;

import java.io.Serializable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gustavo on 05/05/2016.
 */
public abstract class Character implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected final int id;
    protected int level;
    protected int hitPoints;
    protected int strength;
    protected int defense;
    protected int agility;
    protected int intelligence;

    public Character(int strength, int defense, int agility, int intelligence) {
        this.level = 1;
        this.hitPoints = 1000;
        this.strength = strength;
        this.defense = defense;
        this.intelligence = intelligence;
        this.agility = agility;
        this.id = count.incrementAndGet();
    }

    public void updateCharacter() {
        hitPoints = hitPoints + (level * 100);
        strength = strength + (level * 2);
        defense = defense + (level * 3);
        intelligence = intelligence + (level * 2);
        agility = agility + (level * 2);

    }

    public String attack(Character attacker, Character defender) {
        Random r = new Random();
        Hero hero;
        Monster monster;
        StringBuilder battleReport = new StringBuilder();

        int variance = r.nextInt(200) + 1600 + 1;
        int totalDamage = (strength * level + variance) / 6 - defender.getDefense();

        if (attacker instanceof Monster) {
            monster = (Monster) attacker;
            hero = (Hero) defender;
            battleReport.append(monster.getRace()).append(" caused ").append(totalDamage).append(" damage to ").append(hero.getName());
            hero.setHitPoints(hero.getHitPoints() - totalDamage);
            battleReport.append("\n").append(hero.getName()).append(" has ").append(hero.getHitPoints()).append(" hp left ");
        } else if (attacker instanceof Hero) {
            hero = (Hero) attacker;
            monster = (Monster) defender;
            battleReport.append(hero.getName()).append(" dealt ").append(totalDamage).append(" to ").append(monster.getRace());
            monster.setHitPoints(monster.getHitPoints() - totalDamage);
            battleReport.append("\n").append(monster.getRace()).append(" has ").append(monster.getHitPoints()).append(" hp left ");
        }
        return battleReport.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Character) {
            Character anotherCharacter = (Character) obj;
            if (anotherCharacter.getId() == this.id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
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

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}