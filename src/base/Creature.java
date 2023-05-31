public class Creature {
    private String name;
    private String race;
    private String description;
    private int age;
    private Inventory inventory;
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

    public void setRace(String race) {
        this.race = race;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean addItemToInventory(Item item){
        return this.inventory.addItem(item);
    }

    public boolean removeItemToInventory(Item item){
        return this.inventory.removeItem(item);
    }
}