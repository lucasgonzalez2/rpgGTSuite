import java.util.Random;

public class Dice {
    private Random rand;
    public int sides;
    private int lastNumber;

    public Dice(int sides) {
        this.sides = sides;
        this.rand = new Random();
    }

    public Dice() {
        this(20);
    }

    public int roll() {
        this.lastNumber = this.rand.nextInt(this.sides) + 1;
        return this.lastNumber;
    }
}
