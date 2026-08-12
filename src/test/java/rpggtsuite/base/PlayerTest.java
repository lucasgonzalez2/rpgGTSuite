package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void verifiesPasswordWithoutStoringPlaintext() {
        Player player = new Player();
        player.setPassword("s3cret");
        assertTrue(player.checkPassword("s3cret"));
        assertFalse(player.checkPassword("wrong"));
    }

    @Test
    void rejectsPasswordBeforeItIsSet() {
        assertFalse(new Player().checkPassword("anything"));
    }

    @Test
    void managesCharacters() {
        Player player = new Player();
        Character hero = new Character("hero");
        assertTrue(player.addCharacter(hero));
        assertEquals(1, player.getCharacters().size());
        assertTrue(player.removeCharacter(hero));
        assertTrue(player.getCharacters().isEmpty());
    }

    @Test
    void exposesIdentityFields() {
        Player player = new Player();
        player.setUniqueID(7);
        player.setUsername("tomieiro");
        player.setMacAddress("00:11:22:33:44:55");
        assertEquals(7, player.getUniqueID());
        assertEquals("tomieiro", player.getUsername());
        assertEquals("00:11:22:33:44:55", player.getMacAddress());
    }
}
