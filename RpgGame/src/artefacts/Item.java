package artefacts;

/**
 * Created by Gustavo on 05/05/2016.
 */
public abstract class Item {
    protected int value;
    public abstract int sellItem();

    public int getValue() {
        return value;
    }
}
