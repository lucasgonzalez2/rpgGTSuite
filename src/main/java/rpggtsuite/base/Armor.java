package rpggtsuite.base;

public class Armor extends Item {
    private final int baseArmorClass;
    private final ArmorCategory category;
    private final Integer maxDexterityBonus;
    private final boolean stealthDisadvantage;

    public Armor(String name, float weight, int baseArmorClass, ArmorCategory category, Integer maxDexterityBonus,
            boolean stealthDisadvantage) {
        super(name, weight);
        this.baseArmorClass = baseArmorClass;
        this.category = category;
        this.maxDexterityBonus = maxDexterityBonus;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    public int getBaseArmorClass() {
        return this.baseArmorClass;
    }

    public ArmorCategory getCategory() {
        return this.category;
    }

    public Integer getMaxDexterityBonus() {
        return this.maxDexterityBonus;
    }

    public boolean hasStealthDisadvantage() {
        return this.stealthDisadvantage;
    }

    public int armorClassWith(AbilityScore dexterity) {
        if (this.category == ArmorCategory.HEAVY) {
            return this.baseArmorClass;
        }
        int dexModifier = dexterity.getModifier();
        if (this.maxDexterityBonus != null) {
            dexModifier = Math.min(dexModifier, this.maxDexterityBonus);
        }
        return this.baseArmorClass + dexModifier;
    }
}
