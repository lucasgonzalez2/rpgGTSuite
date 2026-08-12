package rpggtsuite.base;

public class Character extends Creature {
    private String nickname;
    private final Sheet sheet;

    public Character(String name) {
        super(name);
        this.sheet = new Sheet();
    }

    public Character(String name, Inventory<Item> inventory) {
        super(name, inventory);
        this.sheet = new Sheet();
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Sheet getSheet() {
        return this.sheet;
    }
}
