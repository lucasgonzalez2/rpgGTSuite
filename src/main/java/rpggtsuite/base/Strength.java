package rpggtsuite.base;

public class Strength extends AbilityScore {
    public Strength(int value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Strength";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.STRENGTH;
    }
}
