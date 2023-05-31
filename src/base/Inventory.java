import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.items = new ArrayList<Item>();
        this.capacity = capacity;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public Item haveItem(String name) {
        for (Item item : this.items) {
            if (item.getName().contains(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean addItem(Item item) {
        if (items.size() >= capacity) {
            return false;
        }
        this.items.add(item);
        this.capacity -= item.getWeight();
        return true;
    }

    public void removeItem(Item item){
        if (this.items.remove(item)){
            this.capacity += item.getWeight();
        }
    }
}
