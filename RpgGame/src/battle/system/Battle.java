package battle.system;

import artefacts.ArmourPiece;
import artefacts.ArmourType;
import artefacts.Item;
import artefacts.Weapon;
import heroes.Hero;
import monsters.Monster;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Gustavo on 04/05/2016.
 */
public class Battle {
    static void startBattle(Hero hero, Monster monster) throws InterruptedException {

        int initialHitPoints = hero.getHitPoints();
        int monsterInitialHitPoints = monster.getHitPoints();
        while (true) {

            //one of the fighters dies when have 0 or below health then we break out of the loop

            if (monster.getHitPoints() <= 0) {
                hero.setHitPoints(initialHitPoints); //resetting hero's HP after the battle
                break;
            } else if (hero.getHitPoints() <= 0) {
                monster.setHitPoints(monsterInitialHitPoints); //resetting monster's HP when the hero dies
                break;
            }
            takeTurns(hero, monster);
        }
        //If our hero died
        if (hero.getHitPoints() <= 0) {
            System.out.println(hero.getName() + " was brave but lost the battle");
            Thread.sleep(2000);
            System.out.println("You were not able to save the princess maybe start again ?");
        } // This is the case where our hero managed to survive
        else {
            System.out.println("Your hero managed to beat the hell out of the creature");
            Thread.sleep(2000);
            System.out.println("The princess is still alive at the castle and" +
                    " SHE SAID YES ! CONGRATULATIONS YOU JUST GOT MARRIED!!!\n\n");
            if (monsterDroppedAnItem()) {
                dropSystem(hero, monster);
            }
            hero.setLevel(hero.getLevel() + 1); //incrementing the level of our hero
            hero.updateCharacter();
            initialHitPoints = hero.getHitPoints();
        }

        hero.setHitPoints(initialHitPoints); //resetting HP again in order to start a new Battle later
        System.out.println("\nPress 3 to begin a new adventure or 5 to quit the game");
    }

    private static void dropSystem(Hero hero, Monster monster) {
        Item drop = generateRandomDrops(monster.getLevel());
        System.out.println("Monster dropped a " + drop);
        System.out.println("Do you want to equip or sell the item ?\t1.Equip\t2.Sell");
        int choice = new Scanner(System.in).nextInt();
        if (drop != null) {
            switch (choice) {
                case 1:
                    hero.getInventory().equip(drop);
                    System.out.println("You equiped the item " + drop);
                    break;
                case 2:
                    hero.getInventory().sell(drop);
                    System.out.println("You sold the item for " + drop.getValue() + " gold");
                    break;
            }
        }
    }

    private static Item generateRandomDrops(int level) {
        Random rand = new Random();
        int chance = rand.nextInt(2) + 1;
        switch (chance) {
            case 1:
                return new Weapon(level * rand.nextInt(50) + 1);
            case 2:
                return new ArmourPiece(level * rand.nextInt(50) + 1, ArmourType.randomArmourType());
        }
        return null;
    }

    private static boolean monsterDroppedAnItem() {
        return new Random().nextBoolean();
    }

    public static void takeTurns(Hero hero, Monster monster) throws InterruptedException {
        //used to create random situations like chance of dodging or casting spells
        Random random = new Random();

        int decision = random.nextInt(2) + 1; // 1 in 2 chances for a monster to cast a spell
        int dodgeChance = random.nextInt(4) + 1; // 1 in 4 chances for one of the fighters to dodge the attack

        //when dodge is 3 then monster managed to dodge
        if (dodgeChance == 3) {
            monster.dodge();
        } else {
            hero.attack(monster);
        }

        System.out.println();
        Thread.sleep(2000);

        //when dodge is 2 the hero dodged
        if (dodgeChance == 2) {
            hero.dodge();

            //if the hero didn't dodged he is either targeted with a spell or with normal attack
        } else {
            if (decision == 1) {
                monster.attack(hero);
            } else {
                monster.castSpell(hero);
            }
        }
        System.out.println();
        Thread.sleep(2000);
    }
}
