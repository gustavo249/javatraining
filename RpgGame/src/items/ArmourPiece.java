package items;

/**
 * Created by Gustavo on 11/04/2016.
 */
public class ArmourPiece {
    private String name;
    private int resistance;

    public ArmourPiece(int resistance, String name) {
        this.resistance = resistance;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ArmourPiece{" +
                "resistance=" + resistance +
                '}';
    }
}
