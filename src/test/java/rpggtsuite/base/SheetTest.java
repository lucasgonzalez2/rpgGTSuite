package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SheetTest {

    @Test
    void startsEmptyAtLevelOne() {
        Sheet sheet = new Sheet();
        assertNull(sheet.getOccupation());
        assertNull(sheet.getAppearances());
        assertNull(sheet.getStrength());
        assertNull(sheet.getDexterity());
        assertNull(sheet.getConstitution());
        assertNull(sheet.getIntelligence());
        assertNull(sheet.getWisdom());
        assertNull(sheet.getCharisma());
        assertNull(sheet.getRace());
        assertNull(sheet.getCharacterClass());
        assertNull(sheet.getAlignment());
        assertEquals(1, sheet.getLevel());
        assertTrue(sheet.getSpells().isEmpty());
    }

    @Test
    void storesOccupationAndAppearances() {
        Sheet sheet = new Sheet();
        sheet.setOccupation("detective");
        sheet.setAppearances("tall, red hair, scar on left cheek");
        assertEquals("detective", sheet.getOccupation());
        assertEquals("tall, red hair, scar on left cheek", sheet.getAppearances());
    }

    @Test
    void storesAbilityScores() {
        Sheet sheet = new Sheet();
        AbilityScore strength = new Strength(16);
        AbilityScore dexterity = new Dexterity(14);
        sheet.setStrength(strength);
        sheet.setDexterity(dexterity);
        assertSame(strength, sheet.getStrength());
        assertSame(dexterity, sheet.getDexterity());
        assertSame(strength, sheet.getAbility(AbilityType.STRENGTH));
        assertSame(dexterity, sheet.getAbility(AbilityType.DEXTERITY));
    }

    @Test
    void abilityModifierIsZeroWhenAbilityIsUnset() {
        assertEquals(0, new Sheet().abilityModifier(AbilityType.WISDOM));
    }

    @Test
    void rejectsLevelBelowOne() {
        assertThrows(IllegalArgumentException.class, () -> new Sheet().setLevel(0));
    }

    @Test
    void proficiencyBonusFollowsLevel() {
        Sheet sheet = new Sheet();
        sheet.setLevel(5);
        assertEquals(3, sheet.proficiencyBonus());
    }

    @Test
    void savingThrowBonusAddsProficiencyOnlyWhenProficient() {
        Sheet sheet = new Sheet();
        sheet.setConstitution(new Constitution(14));
        sheet.setLevel(1);
        assertEquals(2, sheet.savingThrowBonus(AbilityType.CONSTITUTION));

        sheet.addSavingThrowProficiency(AbilityType.CONSTITUTION);
        assertTrue(sheet.isProficientInSavingThrow(AbilityType.CONSTITUTION));
        assertEquals(4, sheet.savingThrowBonus(AbilityType.CONSTITUTION));
    }

    @Test
    void skillBonusStacksExpertiseOnTopOfProficiency() {
        Sheet sheet = new Sheet();
        sheet.setDexterity(new Dexterity(14));
        sheet.setLevel(1);
        assertEquals(2, sheet.skillBonus(Skill.STEALTH));

        sheet.addSkillProficiency(Skill.STEALTH);
        assertEquals(4, sheet.skillBonus(Skill.STEALTH));

        sheet.addSkillExpertise(Skill.STEALTH);
        assertTrue(sheet.hasSkillExpertise(Skill.STEALTH));
        assertEquals(6, sheet.skillBonus(Skill.STEALTH));
    }

    @Test
    void rejectsExpertiseWithoutProficiency() {
        assertThrows(IllegalStateException.class, () -> new Sheet().addSkillExpertise(Skill.ARCANA));
    }

    @Test
    void removingProficiencyAlsoRemovesExpertise() {
        Sheet sheet = new Sheet();
        sheet.addSkillProficiency(Skill.PERCEPTION);
        sheet.addSkillExpertise(Skill.PERCEPTION);
        sheet.removeSkillProficiency(Skill.PERCEPTION);
        assertFalse(sheet.isProficientInSkill(Skill.PERCEPTION));
        assertFalse(sheet.hasSkillExpertise(Skill.PERCEPTION));
    }

    @Test
    void storesSpells() {
        Sheet sheet = new Sheet();
        Spell fireball = new Spell("Fireball", 3, SpellSchool.EVOCATION);
        assertTrue(sheet.addSpell(fireball));
        assertEquals(1, sheet.getSpells().size());
        assertTrue(sheet.removeSpell(fireball));
        assertTrue(sheet.getSpells().isEmpty());
    }
}
