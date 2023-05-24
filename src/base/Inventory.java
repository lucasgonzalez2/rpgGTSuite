import java.util.ArrayList;

public class Inventory {
    ArrayList<Item> items;
    int capacity;

    public Inventory(int capacity) {
        this.items = new ArrayList<Item>();
        this.capacity = capacity;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item haveItem(String name) {
        for (Item item : this.items) {
            if (item.getName.contains(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean addItem(Item item) {
        if (items.size() >= capacity) {
            return false;
        }
        items.add(item);
        return true;
    }
}