package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterClassTest {

    @Test
    void exposesHitDieAndPrimaryAbility() {
        assertEquals(10, CharacterClass.FIGHTER.getHitDieSides());
        assertEquals(AbilityType.STRENGTH, CharacterClass.FIGHTER.getPrimaryAbility());

        assertEquals(6, CharacterClass.WIZARD.getHitDieSides());
        assertEquals(AbilityType.INTELLIGENCE, CharacterClass.WIZARD.getPrimaryAbility());
    }

    @Test
    void newHitDieMatchesTheClassSides() {
        assertEquals(12, CharacterClass.BARBARIAN.newHitDie().getSides());
    }
}
