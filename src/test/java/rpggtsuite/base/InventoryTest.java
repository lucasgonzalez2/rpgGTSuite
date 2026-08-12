package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InventoryTest {

    @Test
    void startsEmptyWithFullCapacity() {
        Inventory<Item> inventory = new Inventory<Item>(10.0f);
        assertTrue(inventory.getItems().isEmpty());
        assertEquals(10.0f, inventory.getCapacity(), 0.0001f);
        assertEquals(0.0f, inventory.getUsedWeight(), 0.0001f);
        assertEquals(10.0f, inventory.getFreeWeight(), 0.0001f);
    }

    @Test
    void addItemTracksWeight() {
        Inventory<Item> inventory = new Inventory<Item>(10.0f);
        assertTrue(inventory.addItem(new Item("sword", 3.0f)));
        assertEquals(3.0f, inventory.getUsedWeight(), 0.0001f);
        assertEquals(7.0f, inventory.getFreeWeight(), 0.0001f);
        assertEquals(1, inventory.getItems().size());
    }

    @Test
    void rejectsItemHeavierThanRemainingCapacity() {
        Inventory<Item> inventory = new Inventory<Item>(5.0f);
        assertTrue(inventory.addItem(new Item("rock", 4.0f)));
        assertFalse(inventory.addItem(new Item("anvil", 2.0f)));
        assertEquals(1, inventory.getItems().size());
        assertEquals(4.0f, inventory.getUsedWeight(), 0.0001f);
    }

    @Test
    void rejectsNullItem() {
        assertFalse(new Inventory<Item>(5.0f).addItem(null));
    }

    @Test
    void removeItemFreesWeight() {
        Inventory<Item> inventory = new Inventory<Item>(10.0f);
        Item sword = new Item("sword", 3.0f);
        inventory.addItem(sword);
        assertTrue(inventory.removeItem(sword));
        assertEquals(0.0f, inventory.getUsedWeight(), 0.0001f);
        assertTrue(inventory.getItems().isEmpty());
    }

    @Test
    void removeUnknownItemReturnsFalse() {
        Inventory<Item> inventory = new Inventory<Item>(10.0f);
        assertFalse(inventory.removeItem(new Item("ghost", 1.0f)));
    }

    @Test
    void haveItemMatchesByNameSubstring() {
        Inventory<Item> inventory = new Inventory<Item>(10.0f);
        Item sword = new Item("iron sword", 3.0f);
        inventory.addItem(sword);
        assertSame(sword, inventory.haveItem("sword"));
        assertNull(inventory.haveItem("shield"));
    }
}
