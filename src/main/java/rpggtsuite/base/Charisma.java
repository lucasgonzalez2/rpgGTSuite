package rpggtsuite.base;

public class Charisma extends AbilityScore {
    public Charisma(int value) {
        super(value);
    }

    @Override
    public String getName() {
        return "Charisma";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.CHARISMA;
    }
}
