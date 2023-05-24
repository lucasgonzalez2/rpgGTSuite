public class Creature {
    private String name;
    private int hpTotal;
    private int hpNow;

    public Creature(String name) {
        this.name = name;
    }

    public void setTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public void setNow(int hpNow) {
        this.hpNow = hpNow;
    }

    public int getTotal() {
        return this.hpTotal;
    }

    public int getNow() {
        return this.hpNow;
    }

    public String getCreature() {
        return this.name;
    }
}