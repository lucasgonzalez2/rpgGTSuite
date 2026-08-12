package rpggtsuite.base;

import java.util.Random;

public class Weapon extends Item {
    private final int damageDiceCount;
    private final int damageDiceSides;
    private final DamageType damageType;
    private final WeaponCategory category;

    public Weapon(String name, float weight, int damageDiceCount, int damageDiceSides, DamageType damageType,
            WeaponCategory category) {
        super(name, weight);
        if (damageDiceCount < 1) {
            throw new IllegalArgumentException("A weapon must roll at least one damage die");
        }
        this.damageDiceCount = damageDiceCount;
        this.damageDiceSides = damageDiceSides;
        this.damageType = damageType;
        this.category = category;
    }

    public int getDamageDiceCount() {
        return this.damageDiceCount;
    }

    public int getDamageDiceSides() {
        return this.damageDiceSides;
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public WeaponCategory getCategory() {
        return this.category;
    }

    public int rollDamage(Random random) {
        Dice dice = new Dice(this.damageDiceSides, random);
        int total = 0;
        for (int i = 0; i < this.damageDiceCount; i++) {
            total += dice.roll();
        }
        return total;
    }
}
