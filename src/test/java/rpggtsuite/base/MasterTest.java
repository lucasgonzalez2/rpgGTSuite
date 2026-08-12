package rpggtsuite.base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MasterTest {

    @Test
    void isAPlayer() {
        assertTrue(new Master() instanceof Player);
    }

    @Test
    void managesCharactersLikeAnyPlayer() {
        Master master = new Master();
        Character npc = new Character("npc");
        assertTrue(master.addCharacter(npc));
        assertTrue(master.removeCharacter(npc));
    }
}
