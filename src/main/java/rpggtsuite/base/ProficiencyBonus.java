package rpggtsuite.base;

public final class ProficiencyBonus {
    private ProficiencyBonus() {
    }

    public static int forLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("A character level must be at least 1");
        }
        return 2 + (level - 1) / 4;
    }
}
