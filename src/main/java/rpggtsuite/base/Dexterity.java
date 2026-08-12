package rpggtsuite.base;

public class Dexterity extends AbilityScore {
    public Dexterity(int value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Dexterity";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DEXTERITY;
    }
}
