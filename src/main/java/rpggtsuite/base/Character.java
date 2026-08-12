package rpggtsuite.base;

import java.util.Random;

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

    public int rollInitiative(Random random) {
        return new Dice(20, random).roll() + this.sheet.abilityModifier(AbilityType.DEXTERITY);
    }
}
