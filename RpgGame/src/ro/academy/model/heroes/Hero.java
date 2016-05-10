package ro.academy.model.heroes;

import ro.academy.controller.battle.FightingBehavior;
import ro.academy.model.base.Character;
import ro.academy.model.artefacts.Inventory;
import ro.academy.model.races.HeroRaces;

/**
 * Created by Gustavo on 10/04/2016.
 */
public class Hero extends Character implements FightingBehavior {
    // common attributes for Hero and Monster can be grouped in a base class (Character or something similar)
    protected String name;
    protected Inventory inventory;
    protected HeroRaces race;

    public Hero(String name, HeroRaces race, int strength, int defense, int agility, int intelligence,
                Inventory inventory) {
        super(strength, defense, agility, intelligence);
        this.name = name;
        this.inventory = inventory;
        this.race = race;
    }

    @Override
    public void move() {
        System.out.println(name + " moved forward with courage and determination to get to the princess");
    }

    @Override
    public void dodge() {
        System.out.println(name + " managed to dodge the deadly blow");
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
                ", race=" + race +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", defense=" + defense +
                ", intelligence=" + intelligence + "\n" +
                ", inventory=" + inventory +
                '}';
    }
}