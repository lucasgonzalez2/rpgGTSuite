package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RoomTest {

    @Test
    void startsWithoutPlayers() {
        Room<Player> room = new Room<Player>(new Master(), "campaign", "tavern");
        assertTrue(room.getPlayers().isEmpty());
    }

    @Test
    void addsAndRemovesPlayers() {
        Room<Player> room = new Room<Player>(new Master(), "campaign", "tavern");
        Player player = new Player();
        assertTrue(room.addPlayer(player));
        assertEquals(1, room.getPlayers().size());
        assertTrue(room.removePlayer(player));
        assertTrue(room.getPlayers().isEmpty());
    }

    @Test
    void exposesRoomMetadata() {
        Master master = new Master();
        Room<Player> room = new Room<Player>(master, "campaign", "tavern");
        assertEquals("campaign", room.getGameName());
        assertEquals("tavern", room.getRoomName());
        assertSame(master, room.getMaster());
        room.setGameName("new campaign");
        assertEquals("new campaign", room.getGameName());
    }

    @Test
    void checksPasswordOnlyWhenSet() {
        Room<Player> open = new Room<Player>(new Master(), "campaign", "tavern");
        assertFalse(open.hasPassword());
        assertFalse(open.checkPassword("anything"));

        Room<Player> locked = new Room<Player>(new Master(), "campaign", "tavern", "abc");
        assertTrue(locked.hasPassword());
        assertTrue(locked.checkPassword("abc"));
        assertFalse(locked.checkPassword("wrong"));
    }
}
