package rpggtsuite.base;

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
}
