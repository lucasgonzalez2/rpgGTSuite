package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreatureTest {

    @Test
    void createsDefaultInventory() {
        Creature creature = new Creature("goblin");
        assertNotNull(creature.getInventory());
        assertTrue(creature.addItemToInventory(new Item("dagger", 1.0f)));
    }

    @Test
    void usesInjectedInventory() {
        Inventory<Item> inventory = new Inventory<Item>(1.0f);
        Creature creature = new Creature("goblin", inventory);
        assertSame(inventory, creature.getInventory());
        assertFalse(creature.addItemToInventory(new Item("boulder", 50.0f)));
    }

    @Test
    void tracksHitPoints() {
        Creature creature = new Creature("orc");
        creature.setTotal(20);
        creature.setNow(15);
        assertEquals(20, creature.getHPTotal());
        assertEquals(15, creature.getHPNow());
    }

    @Test
    void exposesIdentityFields() {
        Creature creature = new Creature("elf");
        creature.setRace("high elf");
        creature.setDescription("wise");
        creature.setAge(120);
        assertEquals("elf", creature.getName());
        assertEquals("high elf", creature.getRace());
        assertEquals("wise", creature.getDescription());
        assertEquals(120, creature.getAge());
    }

    @Test
    void removesItemsFromInventory() {
        Creature creature = new Creature("dwarf");
        Item axe = new Item("axe", 4.0f);
        creature.addItemToInventory(axe);
        assertTrue(creature.removeItemFromInventory(axe));
        assertFalse(creature.removeItemFromInventory(axe));
    }
}
