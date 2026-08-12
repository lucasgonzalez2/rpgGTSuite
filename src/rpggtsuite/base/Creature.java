package rpggtsuite.base;

public class Creature {
    public static final float DEFAULT_INVENTORY_CAPACITY = 100.0f;

    private String name;
    private String race;
    private String description;
    private int age;
    private Inventory<Item> inventory;
    private int hpTotal;
    private int hpNow;

    public Creature(String name) {
        this(name, new Inventory<Item>(DEFAULT_INVENTORY_CAPACITY));
    }

    public Creature(String name, Inventory<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public void setTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public void setNow(int hpNow) {
        this.hpNow = hpNow;
    }

    public int getHPTotal() {
        return this.hpTotal;
    }

    public int getHPNow() {
        return this.hpNow;
    }

    public String getName() {
        return this.name;
    }

    public String getRace() {
        return this.race;
    }

    public String getDescription() {
        return this.description;
    }

    public int getAge() {
        return this.age;
    }

    public Inventory<Item> getInventory() {
        return this.inventory;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean addItemToInventory(Item item) {
        return this.inventory.addItem(item);
    }

    public boolean removeItemFromInventory(Item item) {
        return this.inventory.removeItem(item);
    }
}
