package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class SheetTest {

    @Test
    void startsEmpty() {
        Sheet sheet = new Sheet();
        assertNull(sheet.getOccupation());
        assertNull(sheet.getAppearances());
        assertNull(sheet.getAgility());
        assertNull(sheet.getStrength());
        assertNull(sheet.getIntelligence());
        assertNull(sheet.getConstitution());
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
    void storesSkills() {
        Sheet sheet = new Sheet();
        Skills agility = new Agility(40);
        Skills strength = new Strength(60);
        Skills intelligence = new Intelligence(70);
        Skills constitution = new Constitution(55);

        sheet.setAgility(agility);
        sheet.setStrength(strength);
        sheet.setIntelligence(intelligence);
        sheet.setConstitution(constitution);

        assertSame(agility, sheet.getAgility());
        assertSame(strength, sheet.getStrength());
        assertSame(intelligence, sheet.getIntelligence());
        assertSame(constitution, sheet.getConstitution());
    }
}
