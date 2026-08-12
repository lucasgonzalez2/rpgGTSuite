package rpggtsuite.base;

public class Wisdom extends AbilityScore {
    public Wisdom(int value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Wisdom";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.WISDOM;
    }
}
