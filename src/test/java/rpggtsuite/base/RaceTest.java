package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceTest {

    @Test
    void humanGrantsAUniformBonus() {
        for (AbilityType type : AbilityType.values()) {
            assertEquals(1, Race.HUMAN.bonusFor(type));
        }
    }

    @Test
    void elfGrantsDexterityOnly() {
        assertEquals(2, Race.ELF.bonusFor(AbilityType.DEXTERITY));
        assertEquals(0, Race.ELF.bonusFor(AbilityType.STRENGTH));
    }

    @Test
    void dragonbornGrantsTwoBonuses() {
        assertEquals(2, Race.DRAGONBORN.bonusFor(AbilityType.STRENGTH));
        assertEquals(1, Race.DRAGONBORN.bonusFor(AbilityType.CHARISMA));
        assertEquals(0, Race.DRAGONBORN.bonusFor(AbilityType.WISDOM));
    }

    @Test
    void exposesSpeedAndSize() {
        assertEquals(25, Race.DWARF.getSpeed());
        assertEquals(Size.MEDIUM, Race.DWARF.getSize());
        assertEquals(Size.SMALL, Race.HALFLING.getSize());
    }
}
