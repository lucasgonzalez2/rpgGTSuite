package rpggtsuite.base;

public abstract class Skills {
    private int value;

    protected Skills(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("A skill value cannot be negative");
        }
        this.value = value;
    }

    public abstract String getName();

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("A skill value cannot be negative");
        }
        this.value = value;
    }

    public boolean check(Die die) {
        return die.roll() <= this.value;
    }
}
