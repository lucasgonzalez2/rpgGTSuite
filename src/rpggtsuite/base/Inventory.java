package rpggtsuite.base;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> {
    private final List<T> items;
    private final float capacity;
    private float usedWeight;

    public Inventory(float capacity) {
        this.items = new ArrayList<T>();
        this.capacity = capacity;
        this.usedWeight = 0.0f;
    }

    public List<T> getItems() {
        return this.items;
    }

    public float getCapacity() {
        return this.capacity;
    }

    public float getUsedWeight() {
        return this.usedWeight;
    }

    public float getFreeWeight() {
        return this.capacity - this.usedWeight;
    }

    public T haveItem(String name) {
        for (T item : this.items) {
            if (item.getName().contains(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean addItem(T item) {
        if (item == null) {
            return false;
        }
        if (this.usedWeight + item.getWeight() > this.capacity) {
            return false;
        }
        this.items.add(item);
        this.usedWeight += item.getWeight();
        return true;
    }

    public boolean removeItem(T item) {
        if (this.items.remove(item)) {
            this.usedWeight -= item.getWeight();
            return true;
        }
        return false;
    }
}
