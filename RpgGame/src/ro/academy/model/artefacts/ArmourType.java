package ro.academy.model.artefacts;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Gustavo on 05/05/2016.
 */
public enum ArmourType {
    ARMOUR, HELMET, BOOTS, GAUNTLETS;

    private static final List<ArmourType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static ArmourType randomArmourType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
