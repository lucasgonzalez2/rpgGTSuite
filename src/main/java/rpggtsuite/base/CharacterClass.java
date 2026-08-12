package rpggtsuite.base;

public enum CharacterClass {
    BARBARIAN(12, AbilityType.STRENGTH),
    BARD(8, AbilityType.CHARISMA),
    CLERIC(8, AbilityType.WISDOM),
    DRUID(8, AbilityType.WISDOM),
    FIGHTER(10, AbilityType.STRENGTH),
    MONK(8, AbilityType.DEXTERITY),
    PALADIN(10, AbilityType.STRENGTH),
    RANGER(10, AbilityType.DEXTERITY),
    ROGUE(8, AbilityType.DEXTERITY),
    SORCERER(6, AbilityType.CHARISMA),
    WARLOCK(8, AbilityType.CHARISMA),
    WIZARD(6, AbilityType.INTELLIGENCE);

    private final int hitDieSides;
    private final AbilityType primaryAbility;

    CharacterClass(int hitDieSides, AbilityType primaryAbility) {
        this.hitDieSides = hitDieSides;
        this.primaryAbility = primaryAbility;
    }

    public int getHitDieSides() {
        return this.hitDieSides;
    }

    public AbilityType getPrimaryAbility() {
        return this.primaryAbility;
    }

    public Dice newHitDie() {
        return new Dice(this.hitDieSides);
    }
}
