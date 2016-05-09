package game;

import heroes.Hero;

import java.io.*;

/**
 * Created by Gustavo on 06/05/2016.
 */
public class History {


    public static void saveHero(Hero hero) {
        try {
            FileOutputStream file = new FileOutputStream("resources/hero");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            if (hero == null) {
                throw new NullPointerException();
            }
            oos.writeObject(hero);
            System.out.println("Game saved succesfully");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("You need to create a hero before you can save the game");
        }
    }

    public static Hero readHero() {
        try {
            InputStream file = new FileInputStream("resources/hero");
            ObjectInput input = new ObjectInputStream(file);
            Hero hero = (Hero) input.readObject();
            if (hero != null) {
                System.out.println("Game loaded succesfully now you can see your hero");
                return hero;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("No save data found");
        }
        return null;
    }
}
