public class Item {
    private String name;
    private float value;
    private String description;

    public Item(String name) {
        this.name = name;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public float gatValue() {
        return this.value;
    }
}