

import battle.system.Game;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            Game.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
