package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AbilityScoreTest {

    @Test
    void isASkill() {
        assertTrue(new Strength(10) instanceof Skills);
    }

    @Test
    void modifierFollowsTheStandardFormula() {
        assertEquals(-5, new Strength(1).getModifier());
        assertEquals(-1, new Strength(8).getModifier());
        assertEquals(-1, new Strength(9).getModifier());
        assertEquals(0, new Strength(10).getModifier());
        assertEquals(0, new Strength(11).getModifier());
        assertEquals(3, new Strength(16).getModifier());
        assertEquals(5, new Strength(20).getModifier());
    }

    @Test
    void eachConcreteAbilityReportsItsOwnNameAndType() {
        assertEquals("Strength", new Strength(10).getName());
        assertEquals(AbilityType.STRENGTH, new Strength(10).getType());

        assertEquals("Dexterity", new Dexterity(10).getName());
        assertEquals(AbilityType.DEXTERITY, new Dexterity(10).getType());

        assertEquals("Constitution", new Constitution(10).getName());
        assertEquals(AbilityType.CONSTITUTION, new Constitution(10).getType());

        assertEquals("Intelligence", new Intelligence(10).getName());
        assertEquals(AbilityType.INTELLIGENCE, new Intelligence(10).getType());

        assertEquals("Wisdom", new Wisdom(10).getName());
        assertEquals(AbilityType.WISDOM, new Wisdom(10).getType());

        assertEquals("Charisma", new Charisma(10).getName());
        assertEquals(AbilityType.CHARISMA, new Charisma(10).getType());
    }
}
