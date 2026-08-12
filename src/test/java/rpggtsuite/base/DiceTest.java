package rpggtsuite.base;

import java.util.Random;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceTest {

    @Test
    void defaultDiceHasTwentySides() {
        assertEquals(20, new Dice().getSides());
    }

    @Test
    void rollStaysWithinOneAndSides() {
        Dice dice = new Dice(6, new Random(42));
        for (int i = 0; i < 1000; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 6);
        }
    }

    @Test
    void rollIsDeterministicForSeededRandom() {
        Dice first = new Dice(20, new Random(7));
        Dice second = new Dice(20, new Random(7));
        for (int i = 0; i < 10; i++) {
            assertEquals(first.roll(), second.roll());
        }
    }

    @Test
    void lastNumberTracksLastRoll() {
        Dice dice = new Dice(12, new Random(1));
        int rolled = dice.roll();
        assertEquals(rolled, dice.getLastNumber());
    }

    @Test
    void rejectsZeroOrNegativeSides() {
        assertThrows(IllegalArgumentException.class, () -> new Dice(0));
        assertThrows(IllegalArgumentException.class, () -> new Dice(-3));
    }
}
