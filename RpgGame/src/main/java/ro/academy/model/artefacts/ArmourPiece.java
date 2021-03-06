package ro.academy.model.artefacts;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class ArmourPiece extends Item {
    private ArmourType type;
    private int resistance;

    public ArmourPiece(int resistance, ArmourType type) {
        this.resistance = resistance;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArmourPiece{" +
                "resistance=" + resistance +
                ", type=" + type +
                '}';
    }


    public ArmourType getType() {
        return type;
    }

    public int getResistance() {
        return resistance;
    }

    @Override
    public int sellItem() {
        value = resistance * 2;
        return value;
    }
}
