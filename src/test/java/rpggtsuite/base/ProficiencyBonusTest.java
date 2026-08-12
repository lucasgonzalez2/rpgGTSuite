package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProficiencyBonusTest {

    @Test
    void followsTheLevelTable() {
        assertEquals(2, ProficiencyBonus.forLevel(1));
        assertEquals(2, ProficiencyBonus.forLevel(4));
        assertEquals(3, ProficiencyBonus.forLevel(5));
        assertEquals(3, ProficiencyBonus.forLevel(8));
        assertEquals(4, ProficiencyBonus.forLevel(9));
        assertEquals(4, ProficiencyBonus.forLevel(12));
        assertEquals(5, ProficiencyBonus.forLevel(13));
        assertEquals(5, ProficiencyBonus.forLevel(16));
        assertEquals(6, ProficiencyBonus.forLevel(17));
        assertEquals(6, ProficiencyBonus.forLevel(20));
    }

    @Test
    void rejectsLevelBelowOne() {
        assertThrows(IllegalArgumentException.class, () -> ProficiencyBonus.forLevel(0));
    }
}
