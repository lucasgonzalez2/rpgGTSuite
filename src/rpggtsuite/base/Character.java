package rpggtsuite.base;

public class Character extends Creature {
    private String nickname;

    public Character(String name) {
        super(name);
    }

    public Character(String name, Inventory<Item> inventory) {
        super(name, inventory);
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
