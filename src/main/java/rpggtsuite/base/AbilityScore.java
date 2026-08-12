package rpggtsuite.base;

public abstract class AbilityScore extends Skills {
    protected AbilityScore(int value) {
        super(value);
    }

    public abstract AbilityType getType();

    public int getModifier() {
        return Math.floorDiv(this.getValue() - 10, 2);
    }
}
