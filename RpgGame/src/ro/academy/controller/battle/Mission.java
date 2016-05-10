package ro.academy.controller.battle;

import ro.academy.model.base.History;
import ro.academy.model.heroes.Hero;
import ro.academy.model.heroes.Ninja;
import ro.academy.model.heroes.Shaman;
import ro.academy.model.heroes.Warrior;
import ro.academy.model.monsters.*;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Mission {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean exit = false;
    private static Hero hero;


    /**
     * The starting point of the ro.academy.model.base where the user chooses an option either to create a new hero
     * or begin an adventure2
     * <p>
     * The ro.academy.controller.battle between hero and ro.academy.model.monsters is mostly random
     *
     * @throws InterruptedException
     */
    public static void start() throws InterruptedException {
        String options = "1.Print menu\n2.Create a new hero\n3.SaveGame\n4.Load game\n5.Begin adventure\n" +
                "6.See your character\n7.Exit game";
        System.out.println(options);
        hero = null;

        while (!exit) {
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(options);
                    break;
                case 2:
                    hero = createNewHero();
                    break;
                case 3:
                    History.saveHero(hero);
                    break;
                case 4:
                    hero = History.readHero();
                    break;
                case 5:
                    beginAdventure(hero);
                    break;
                case 6:
                    seeYourHero(hero);
                    break;
                case 7:
                    exit = true;
                    break;
            }
        }
    }

    private static void seeYourHero(Hero hero) {
        if (hero != null) {
            System.out.println(hero.toString());
        } else {
            System.err.println("You don\'t have an hero");
        }
    }

    /**
     * Basic method which models the adventure and prints different messages related to
     * the stages of the ro.academy.model.base
     * The player has to make just one choice whether to fight the monster or run away
     *
     * @param hero
     * @throws InterruptedException
     */
    private static void beginAdventure(Hero hero) throws InterruptedException {
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

            Monster monster = generateRandomMonster();
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
    private static Monster generateRandomMonster() {
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

    /**
     * Method which creates a virtual ro.academy.controller.battle between the hero and a random monster
     * It is 50/50% chance for a monster to hit normally or cast a spell
     * Each of the fighters take turns and finnaly
     * when one of them has 0 or below HP loses
     * 2 seconds pause between each turn
     *
     * @param hero
     * @param monster
     * @throws InterruptedException
     */


    /**
     * Method which creates a new hero based on the choice of the user
     * The name is provided by the user but the attributes
     * of the hero are predefined
     * This method returns null if no choice is selected
     *
     * @return Hero
     */
    private static Hero createNewHero() {
        System.out.println("What class you want your hero to be ?");
        System.out.println("1.Warrior (High defence , but kinda slow) \n" +
                "2.Ninja (Medium defence, moves faster than warrior)  \n" +
                "3.Shaman (Low defence, but has very powerful spells)");
        int choice = scanner.nextInt();
        String name;

        if (choice == 1 || choice == 2 || choice == 3) {
            System.out.println("Now, please provide a name for your hero: ");
            name = scanner.next();
        } else {
            System.err.println("Invalid choice please try creating the hero again");
            return null;
        }
        if (choice == 1) {
            System.out.println("Your hero has been created, welcome " + name +
                    " you\'ll be a great warrior now you can start a new adventure");
            hero = new Warrior(name);
        } else if (choice == 2) {
            System.out.println("Good choice for a ninja, welcome " + name +
                    " now you can start a new adventure");
            hero = new Ninja(name);
        } else if (choice == 3) {
            System.out.println("Smart decision future shaman ! Good luck " + name + "" +
                    " now you can start a new adventure");
            hero = new Shaman(name);
        }
        return hero;
    }
}
