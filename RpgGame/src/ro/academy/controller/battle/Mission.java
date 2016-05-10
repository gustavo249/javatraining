package ro.academy.controller.battle;

import ro.academy.model.heroes.Hero;
import ro.academy.model.monsters.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Mission {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;


    /**
     * Basic method which models the adventure and prints different messages related to
     * the stages of the ro.academy.model.base
     * The player has to make just one choice whether to fight the monster or run away
     *
     * @param hero
     * @throws InterruptedException
     */

    public static void beginAdventure(Hero hero) throws InterruptedException {
        if (hero != null) {


            String description = "You are in love with a beautiful princess " +
                    "and your purpose is to get to the castle and marry her, but the road is full of danger\n";

            if (hero.getLevel() == 1) {
                System.out.println(description);
            }
            Thread.sleep(3500);
            hero.move();
            Thread.sleep(3500);
            System.out.println("As you make your way through the " +
                    "forest an ugly creature appears from nowhere...");
            Thread.sleep(3000);

            Monster monster = generateRandomMonster(hero);
            System.out.println("\nIt seems like an " + monster.getRace() + "...\n");
            Thread.sleep(2000);
            monster.move();
            System.out.println("\nWhat do you want to do now ? \n1.Run like a little girl\t" +
                    "2.Fight him like a brave man you are");

            int choice = scanner.nextInt();
            if (choice == 1) {
                hero.concede();
                exit = true;
            } else {
                Battle.startBattle(hero, monster);
            }

        } else {
            System.err.println("Please create a hero");
        }
    }

    /**
     * Generates one of the ro.academy.model.monsters : Orc, Skeleton, Elf or Undead
     *
     * @return Monster
     */
    private static Monster generateRandomMonster(Hero hero) {
        int randomMonster = new Random().nextInt(4) + 1;
        Monster monster = null;

        switch (randomMonster) {
            case 1:
                monster = new Orc();
                break;
            case 2:
                monster = new Elf();
                break;
            case 3:
                monster = new Skeleton();
                break;
            case 4:
                monster = new Undead();
                break;
        }
        assert monster != null;
        monster.setLevel(hero.getLevel());
        monster.updateCharacter();
        return monster;
    }

}
