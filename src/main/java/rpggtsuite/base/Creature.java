package rpggtsuite.base;

import java.util.EnumSet;
import java.util.Set;

public class Creature {
    public static final float DEFAULT_INVENTORY_CAPACITY = 100.0f;

    private String name;
    private String race;
    private String description;
    private int age;
    private Inventory<Item> inventory;
    private int hpTotal;
    private int hpNow;
    private final Set<Condition> conditions;

    public Creature(String name) {
        this(name, new Inventory<Item>(DEFAULT_INVENTORY_CAPACITY));
    }

    public Creature(String name, Inventory<Item> inventory) {
        this.name = name;
        this.inventory = inventory;
        this.conditions = EnumSet.noneOf(Condition.class);
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

    public boolean addCondition(Condition condition) {
        return this.conditions.add(condition);
    }

    public boolean removeCondition(Condition condition) {
        return this.conditions.remove(condition);
    }

    public boolean hasCondition(Condition condition) {
        return this.conditions.contains(condition);
    }

    public Set<Condition> getConditions() {
        return this.conditions;
    }
}
