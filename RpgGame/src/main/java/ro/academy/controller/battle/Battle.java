package ro.academy.controller.battle;

import ro.academy.model.artefacts.ArmourPiece;
import ro.academy.model.artefacts.ArmourType;
import ro.academy.model.artefacts.Item;
import ro.academy.model.artefacts.Weapon;
import ro.academy.model.heroes.Hero;
import ro.academy.model.monsters.Monster;

import java.util.Random;

/**
 * Created by Gustavo on 04/05/2016.
 */
public class Battle {

    private StringBuilder battleOutcome = new StringBuilder();
    private StringBuilder battleReport = new StringBuilder();

     public void startBattle(Hero hero, Monster monster) {

         monster.setLevel(hero.getLevel());
         monster.updateCharacter();

        int initialHitPoints = hero.getHitPoints();
        int monsterInitialHitPoints = monster.getHitPoints();
        while (true) {

            //one of the fighters dies when have 0 or below health then we break out of the loop

            if (monster.getHitPoints() <= 0) {
                hero.setHitPoints(initialHitPoints); //resetting hero's HP after the ro.academy.controller.battle
                break;
            } else if (hero.getHitPoints() <= 0) {
                monster.setHitPoints(monsterInitialHitPoints); //resetting monster's HP when the hero dies
                break;
            }
            takeTurns(hero, monster);
        }
        //If our hero died
        if (hero.getHitPoints() <= 0) {
           battleOutcome.append(hero.getName()).append(" was brave but lost the battle\n");
            battleOutcome.append("You were not able to save the princess maybe start again ?");
        } // This is the case where our hero managed to survive
        else {
            battleOutcome.append("Your hero managed to beat the hell out of the creature\n");
            battleOutcome.append("The princess is still alive at the castle and \n" +
                    " SHE SAID YES ! CONGRATULATIONS YOU JUST GOT MARRIED!!!\n\n");
            dropSystem(hero, monster);

            hero.updateCharacter();
            hero.collectXp(monster.getXp());
            initialHitPoints = hero.getHitPoints();
        }

        hero.setHitPoints(initialHitPoints); //resetting HP again in order to start a new Battle later
    }

    private  void dropSystem(Hero hero, Monster monster) {
        Item drop = generateRandomDrops(monster.getLevel());
        battleOutcome.append("Monster dropped a ").append(drop);
        battleOutcome.append("\nYou equipped this ").append(drop);
        hero.getInventory().equip(drop);
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


    public  void takeTurns(Hero hero, Monster monster) {
        //used to create random situations like chance of dodging or casting spells
        Random random = new Random();

        int decision = random.nextInt(2) + 1; // 1 in 2 chances for a monster to cast a spell
        int dodgeChance = random.nextInt(4) + 1; // 1 in 4 chances for one of the fighters to dodge the attack

        //when dodge is 3 then monster managed to dodge
        if (dodgeChance == 3) {
            battleReport.append(monster.dodge());
        } else {
            battleReport.append(hero.attack(hero, monster));
        }

        battleReport.append("\n");

        //when dodge is 2 the hero dodged
        if (dodgeChance == 2) {
            hero.dodge();

            //if the hero didn't dodged he is either targeted with a spell or with normal attack
        } else {
            if (decision == 1) {
                battleReport.append(monster.attack(monster, hero));
            } else {
                battleReport.append(monster.castSpell(hero));
            }
        }
        battleReport.append("\n");
    }

    public StringBuilder getBattleReport() {
        return battleReport;
    }

    public void setBattleReport(StringBuilder battleReport) {
        this.battleReport = battleReport;
    }

    public StringBuilder getBattleOutcome() {
        return battleOutcome;
    }

    public void setBattleOutcome(StringBuilder battleOutcome) {
        this.battleOutcome = battleOutcome;
    }
}
