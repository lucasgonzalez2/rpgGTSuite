package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SkillsTest {

    @Test
    void keepsValueFromConstructor() {
        Skills strength = new Strength(50);
        assertEquals(50, strength.getValue());
    }

    @Test
    void rejectsNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Strength(-1));
    }

    @Test
    void rejectsNegativeValueOnSet() {
        Skills strength = new Strength(50);
        assertThrows(IllegalArgumentException.class, () -> strength.setValue(-1));
    }

    @Test
    void checkSucceedsWhenRollIsAtOrBelowValue() {
        Skills strength = new Strength(50);
        assertTrue(strength.check(fixedRoll(50)));
        assertTrue(strength.check(fixedRoll(1)));
        assertFalse(strength.check(fixedRoll(51)));
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
}
