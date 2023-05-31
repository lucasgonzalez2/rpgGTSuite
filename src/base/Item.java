public class Item {
    private String name;
    private float value;
    private String description;
    private float weight;

    public Item(String name, float weight) {
        this.name = name;
        this.weight = weight;
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

    public float getValue() {
        return this.value;
    }

     public float getWeight() {
        return this.weight;
    }

    public String getDescription() {
        return this.description;
    }
}