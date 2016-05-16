package ro.academy.model.artefacts;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Weapon extends Item {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "damage=" + damage +
                '}';
    }

    @Override
    public int sellItem() {
        value = damage * 3;
        return value;
    }
}
