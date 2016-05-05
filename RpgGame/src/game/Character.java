package game;

/**
 * Created by Gustavo on 05/05/2016.
 */
public abstract class Character {
    protected int level;
    protected int hitPoints;
    protected int strength;
    protected int defense;
    protected int agility;
    protected int intelligence;

    public Character(int level, int hitPoints, int strength, int defense, int agility, int intelligence) {
        this.level = level;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.defense = defense;
        this.intelligence = intelligence;
        this.agility = agility;
    }
}
