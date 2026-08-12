package rpggtsuite.base;

import java.util.Map;

public enum Race {
    HUMAN(30, Size.MEDIUM, Map.of(
            AbilityType.STRENGTH, 1,
            AbilityType.DEXTERITY, 1,
            AbilityType.CONSTITUTION, 1,
            AbilityType.INTELLIGENCE, 1,
            AbilityType.WISDOM, 1,
            AbilityType.CHARISMA, 1)),
    ELF(30, Size.MEDIUM, Map.of(AbilityType.DEXTERITY, 2)),
    DWARF(25, Size.MEDIUM, Map.of(AbilityType.CONSTITUTION, 2)),
    HALFLING(25, Size.SMALL, Map.of(AbilityType.DEXTERITY, 2)),
    DRAGONBORN(30, Size.MEDIUM, Map.of(AbilityType.STRENGTH, 2, AbilityType.CHARISMA, 1)),
    GNOME(25, Size.SMALL, Map.of(AbilityType.INTELLIGENCE, 2)),
    HALF_ELF(30, Size.MEDIUM, Map.of(AbilityType.CHARISMA, 2)),
    HALF_ORC(30, Size.MEDIUM, Map.of(AbilityType.STRENGTH, 2, AbilityType.CONSTITUTION, 1)),
    TIEFLING(30, Size.MEDIUM, Map.of(AbilityType.CHARISMA, 2, AbilityType.INTELLIGENCE, 1));

    private final int speed;
    private final Size size;
    private final Map<AbilityType, Integer> abilityBonuses;

    Race(int speed, Size size, Map<AbilityType, Integer> abilityBonuses) {
        this.speed = speed;
        this.size = size;
        this.abilityBonuses = abilityBonuses;
    }

    public int getSpeed() {
        return this.speed;
    }

    public Size getSize() {
        return this.size;
    }

    public int bonusFor(AbilityType type) {
        return this.abilityBonuses.getOrDefault(type, 0);
    }
}
