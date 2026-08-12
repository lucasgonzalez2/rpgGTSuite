package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpellTest {

    @Test
    void keepsNameLevelAndSchoolFromConstructor() {
        Spell fireball = new Spell("Fireball", 3, SpellSchool.EVOCATION);
        assertEquals("Fireball", fireball.getName());
        assertEquals(3, fireball.getLevel());
        assertEquals(SpellSchool.EVOCATION, fireball.getSchool());
        assertFalse(fireball.isCantrip());
    }

    @Test
    void levelZeroIsACantrip() {
        assertTrue(new Spell("Fire Bolt", 0, SpellSchool.EVOCATION).isCantrip());
    }

    @Test
    void rejectsLevelOutsideZeroToNine() {
        assertThrows(IllegalArgumentException.class, () -> new Spell("Broken", -1, SpellSchool.ABJURATION));
        assertThrows(IllegalArgumentException.class, () -> new Spell("Broken", 10, SpellSchool.ABJURATION));
    }

    @Test
    void storesConcentrationRitualAndDescription() {
        Spell spell = new Spell("Detect Magic", 1, SpellSchool.DIVINATION);
        spell.setConcentration(true);
        spell.setRitual(true);
        spell.setDescription("sense magic within range");
        assertTrue(spell.isConcentration());
        assertTrue(spell.isRitual());
        assertEquals("sense magic within range", spell.getDescription());
    }
}
