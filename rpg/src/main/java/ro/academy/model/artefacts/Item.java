package ro.academy.model.artefacts;

import java.io.Serializable;

/**
 * Created by Gustavo on 05/05/2016.
 */
public abstract class Item implements Serializable {
    protected int value;
    public abstract int sellItem();

    public int getValue() {
        return value;
    }
}
