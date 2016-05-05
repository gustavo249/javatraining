package game;

import artefacts.Item;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gustavo on 05/05/2016.
 */
public abstract class Character {
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
        this.hitPoints = 1000 + (level * 100);
        this.strength = strength + level * 7;
        this.defense = defense + level * 2;
        this.intelligence = intelligence + level * 2;
        this.agility = agility + level;
        this.id = count.incrementAndGet();
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

}