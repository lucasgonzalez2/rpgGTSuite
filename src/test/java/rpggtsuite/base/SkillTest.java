package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillTest {

    @Test
    void everySkillHasAGoverningAbility() {
        assertEquals(AbilityType.DEXTERITY, Skill.STEALTH.getAbilityType());
        assertEquals(AbilityType.WISDOM, Skill.PERCEPTION.getAbilityType());
        assertEquals(AbilityType.STRENGTH, Skill.ATHLETICS.getAbilityType());
        assertEquals(AbilityType.CHARISMA, Skill.PERSUASION.getAbilityType());
        assertEquals(AbilityType.INTELLIGENCE, Skill.ARCANA.getAbilityType());
        assertEquals(18, Skill.values().length);
    }
}
