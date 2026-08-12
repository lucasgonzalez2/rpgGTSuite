package rpggtsuite.base;

import java.util.Random;

public class Dice implements Die {
    public static final int DEFAULT_SIDES = 20;

    private final Random rand;
    private final int sides;
    private int lastNumber;

    public Dice() {
        this(DEFAULT_SIDES);
    }

    public Dice(int sides) {
        this(sides, new Random());
    }

    public Dice(int sides, Random rand) {
        if (sides < 1) {
            throw new IllegalArgumentException("A die must have at least one side");
        }
        this.sides = sides;
        this.rand = rand;
    }

    public int roll() {
        this.lastNumber = this.rand.nextInt(this.sides) + 1;
        return this.lastNumber;
    }

    public int getSides() {
        return this.sides;
    }

    public int getLastNumber() {
        return this.lastNumber;
    }
}
