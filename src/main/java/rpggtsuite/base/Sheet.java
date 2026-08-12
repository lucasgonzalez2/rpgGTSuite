package rpggtsuite.base;

public class Sheet {
    private String occupation;
    private String appearances;
    private Skills agility;
    private Skills strength;
    private Skills intelligence;
    private Skills constitution;

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAppearances() {
        return this.appearances;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }

    public Skills getAgility() {
        return this.agility;
    }

    public void setAgility(Skills agility) {
        this.agility = agility;
    }

    public Skills getStrength() {
        return this.strength;
    }

    public void setStrength(Skills strength) {
        this.strength = strength;
    }

    public Skills getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(Skills intelligence) {
        this.intelligence = intelligence;
    }

    public Skills getConstitution() {
        return this.constitution;
    }

    public void setConstitution(Skills constitution) {
        this.constitution = constitution;
    }
}
