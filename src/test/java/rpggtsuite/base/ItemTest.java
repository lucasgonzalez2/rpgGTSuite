package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ItemTest {

    @Test
    void keepsNameAndWeightFromConstructor() {
        Item item = new Item("sword", 3.5f);
        assertEquals("sword", item.getName());
        assertEquals(3.5f, item.getWeight(), 0.0001f);
    }

    @Test
    void valueAndDescriptionStartEmpty() {
        Item item = new Item("shield", 2.0f);
        assertEquals(0.0f, item.getValue(), 0.0001f);
        assertNull(item.getDescription());
    }

    @Test
    void storesValueAndDescription() {
        Item item = new Item("potion", 0.5f);
        item.setValue(10.0f);
        item.setDescription("heals");
        assertEquals(10.0f, item.getValue(), 0.0001f);
        assertEquals("heals", item.getDescription());
    }
}
