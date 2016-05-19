package ro.academy.controller.battle;

import ro.academy.model.heroes.Hero;
import ro.academy.model.monsters.*;

import java.util.Random;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Mission {


    private Hero hero;
    private Monster monster = generateRandomMonster();
    private Battle battle;

    public void startBattle() {
        battle = new Battle();
        battle.startBattle(hero, monster);
    }

    /**
     * Generates one of the ro.academy.model.monsters : Orc, Skeleton, Elf or Undead
     *
     * @return Monster
     */
    private Monster generateRandomMonster() {
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
        return monster;
    }

    public String setStoryline() {
        StringBuilder storyLine = new StringBuilder();

        String description = "You are in love with a beautiful princess" +
                "and your purpose is to get to the castle and marry her, \nbut the road is full of danger...\n";

        if (hero.getLevel() == 1) {
            storyLine.append(description);
        }

        storyLine.append(hero.getName()).append(" moved forward with courage and determination to get to the princess\n");
        storyLine.append("As you make your way through the " +
                "forest an ugly creature appears from nowhere...");

        return storyLine.toString();
    }

    public String danger() {
        monster = generateRandomMonster();

        return String.valueOf(monster.getRace()) + " got closer to you... \nYour heart has begun to pump really fast" +
                "\nWhat do you want to do now ?";
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Battle getBattle() {
        return battle;
    }

    public Monster getMonster() {
        return monster;
    }
}
