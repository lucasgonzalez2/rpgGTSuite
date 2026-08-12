package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArmorTest {

    @Test
    void isAnItem() {
        Armor leather = new Armor("leather armor", 10.0f, 11, ArmorCategory.LIGHT, null, false);
        assertTrue(leather instanceof Item);
    }

    @Test
    void lightArmorAddsFullDexterityBonus() {
        Armor leather = new Armor("leather armor", 10.0f, 11, ArmorCategory.LIGHT, null, false);
        assertEquals(15, leather.armorClassWith(new Dexterity(18)));
    }

    @Test
    void mediumArmorCapsDexterityBonus() {
        Armor halfPlate = new Armor("half plate", 40.0f, 15, ArmorCategory.MEDIUM, 2, true);
        assertEquals(17, halfPlate.armorClassWith(new Dexterity(18)));
        assertTrue(halfPlate.hasStealthDisadvantage());
    }

    @Test
    void heavyArmorIgnoresDexterityBonus() {
        Armor plate = new Armor("plate", 65.0f, 18, ArmorCategory.HEAVY, 0, true);
        assertEquals(18, plate.armorClassWith(new Dexterity(20)));
        assertEquals(18, plate.armorClassWith(new Dexterity(1)));
    }
}
