package rpggtsuite.base;

public class Constitution extends AbilityScore {
    public Constitution(int value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Constitution";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.CONSTITUTION;
    }
}
