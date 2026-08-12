package rpggtsuite.base;

public class Spell {
    private final String name;
    private final int level;
    private final SpellSchool school;
    private boolean concentration;
    private boolean ritual;
    private String description;

    public Spell(String name, int level, SpellSchool school) {
        if (level < 0 || level > 9) {
            throw new IllegalArgumentException("A spell level must be between 0 and 9");
        }
        this.name = name;
        this.level = level;
        this.school = school;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean isCantrip() {
        return this.level == 0;
    }

    public SpellSchool getSchool() {
        return this.school;
    }

    public boolean isConcentration() {
        return this.concentration;
    }

    public void setConcentration(boolean concentration) {
        this.concentration = concentration;
    }

    public boolean isRitual() {
        return this.ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
