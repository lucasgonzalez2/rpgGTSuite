package rpggtsuite.base;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeaponTest {

    @Test
    void isAnItem() {
        Weapon longsword = new Weapon("longsword", 3.0f, 1, 8, DamageType.SLASHING, WeaponCategory.MARTIAL_MELEE);
        assertTrue(longsword instanceof Item);
        assertEquals("longsword", longsword.getName());
        assertEquals(3.0f, longsword.getWeight(), 0.0001f);
        assertEquals(DamageType.SLASHING, longsword.getDamageType());
        assertEquals(WeaponCategory.MARTIAL_MELEE, longsword.getCategory());
    }

    @Test
    void rejectsZeroDamageDice() {
        assertThrows(IllegalArgumentException.class,
                () -> new Weapon("cursed dagger", 1.0f, 0, 4, DamageType.PIERCING, WeaponCategory.SIMPLE_MELEE));
    }

    @Test
    void rollDamageStaysWithinDiceRange() {
        Weapon greataxe = new Weapon("greataxe", 7.0f, 1, 12, DamageType.SLASHING, WeaponCategory.MARTIAL_MELEE);
        for (int i = 0; i < 100; i++) {
            int damage = greataxe.rollDamage(new Random(i));
            assertTrue(damage >= 1 && damage <= 12);
        }
    }

    @Test
    void rollDamageSumsMultipleDice() {
        Weapon fireball = new Weapon("fireball bolt", 0.0f, 8, 6, DamageType.FIRE, WeaponCategory.SIMPLE_RANGED);
        for (int i = 0; i < 100; i++) {
            int damage = fireball.rollDamage(new Random(i));
            assertTrue(damage >= 8 && damage <= 48);
        }
    }
}
