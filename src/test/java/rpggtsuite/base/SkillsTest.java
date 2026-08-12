package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SkillsTest {

    @Test
    void keepsValueFromConstructor() {
        Skills agility = new Agility(50);
        assertEquals(50, agility.getValue());
    }

    @Test
    void rejectsNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Agility(-1));
    }

    @Test
    void rejectsNegativeValueOnSet() {
        Skills agility = new Agility(50);
        assertThrows(IllegalArgumentException.class, () -> agility.setValue(-1));
    }

    @Test
    void checkSucceedsWhenRollIsAtOrBelowValue() {
        Skills agility = new Agility(50);
        assertTrue(agility.check(fixedRoll(50)));
        assertTrue(agility.check(fixedRoll(1)));
        assertFalse(agility.check(fixedRoll(51)));
    }

    private static Die fixedRoll(int roll) {
        return new Die() {
            @Override
            public int roll() {
                return roll;
            }

            @Override
            public int getSides() {
                return 100;
            }
        };
    }

    @Test
    void concreteSkillsReportTheirOwnName() {
        assertEquals("Agility", new Agility(10).getName());
        assertEquals("Strength", new Strength(10).getName());
        assertEquals("Intelligence", new Intelligence(10).getName());
        assertEquals("Constitution", new Constitution(10).getName());
    }
}
