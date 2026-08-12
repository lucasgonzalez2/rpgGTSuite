package rpggtsuite.base;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {

    @Test
    void isACreature() {
        assertTrue(new Character("hero") instanceof Creature);
    }

    @Test
    void holdsNickname() {
        Character character = new Character("hero");
        character.setNickname("the bold");
        assertEquals("the bold", character.getNickname());
    }

    @Test
    void acceptsInjectedInventory() {
        Inventory<Item> inventory = new Inventory<Item>(2.0f);
        Character character = new Character("hero", inventory);
        assertSame(inventory, character.getInventory());
    }

    @Test
    void startsWithASheet() {
        Character character = new Character("hero");
        assertNotNull(character.getSheet());
    }

    @Test
    void rollInitiativeWithoutDexterityStaysWithinDieRange() {
        Character character = new Character("hero");
        for (int i = 0; i < 50; i++) {
            int result = character.rollInitiative(new Random(i));
            assertTrue(result >= 1 && result <= 20);
        }
    }

    @Test
    void rollInitiativeAddsDexterityModifier() {
        Character noMod = new Character("scout");
        noMod.getSheet().setDexterity(new Dexterity(10));
        int base = noMod.rollInitiative(new Random(7));

        Character withMod = new Character("scout");
        withMod.getSheet().setDexterity(new Dexterity(16));
        int boosted = withMod.rollInitiative(new Random(7));

        assertEquals(base + 3, boosted);
    }
}
