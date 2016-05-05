package heroes;

import battle.system.FightingBehavior;
import game.Character;
import artefacts.Inventory;
import monsters.Monster;

import java.util.Random;

/**
 * Created by Gustavo on 10/04/2016.
 */
public class Hero extends Character implements FightingBehavior {
	// common attributes for Hero and Monster can be grouped in a base class (Character or something similar)
    protected String name;
    protected Inventory inventory;

    public Hero(String name,  int strength, int defense, int agility, int intelligence,
    Inventory inventory) {
        super(strength, defense, agility, intelligence);
        this.name = name;
        this.inventory = inventory;
    }

    @Override
    public void move() {
        System.out.println(name + " moved forward with courage and determination to get to the princess");
    }

    @Override
    public void dodge() {
        System.out.println(name + " managed to dodge the deadly blow");
    }

    public void attack(Monster monster) {
        int totalDamage = calculateDamage() - monster.getDefense();
        System.out.println(name + " dealt " + totalDamage + " to " + monster.getRace());
        monster.setHitPoints(monster.getHitPoints() - totalDamage);
        System.out.println(monster.getRace() + " has " + monster.getHitPoints() + " hp left ");
    }

    private int calculateDamage() {
        int variance = new Random().nextInt(1800 - 1600) + 1600;
        int damage = (strength * level + variance) / 7;
        return damage;
    }

    @Override
    public void concede() {
        System.out.println("This adventure is not for you, come later when you are prepared");
    }

    public void castSpell(Hero enemy) {
        System.out.println(name + " Casted a magical spell towards all enemies");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", defense=" + defense +
                ", intelligence=" + intelligence +
                ", inventory=" + inventory +
                '}';
    }
}
