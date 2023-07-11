public class Sheet extends Character {

    //Attribute

    private String occupation;
    private String appearances;
    private Skills agility;
    private Skills charism;
    private Skills power;
    private Skills intellect;
    private Skills perception;
    private Skills strength;
    
    //Method Constructor

    public Sheet(String name, int age, String race, String occupation, String appearances, Skills agility, Skills charism, Skills power, Skills intellect, Skills perception, Skills strength) {
        super(name);
        setAge(age);
        setRace(race);
        setOccupation(occupation);
        setAppearances(appearances);
        setAgility(agility);
        setCharism(charism);
        setPower(power);
        setIntellect(intellect);
        setPerception(perception);
        setStrength(strength);
    }

    //Methods Setters and Getters

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setAppearances(String appearances) {
        this.appearances = appearances;
    }

    public String getAppearances() {
        return this.appearances;
    }

    public void setAgility(Skills agility) {
        this.agility = agility;
    }

    public Skills getAgility() {
        return this.agility;
    }

    public void setCharism(Skills charism) {
        this.charism = charism;
    }

    public Skills getCharism() {
        return this.charism;
    }

    public void setPower(Skills power) {
        this.power = power;
    }

    public Skills getPower() {
        return this.power;
    }

    public void setIntellect(Skills intellect) {
        this.intellect = intellect;
    }

    public Skills getIntellect() {
        return this.intellect;
    }

    public void setPerception(Skills perception) {
        this.perception = perception;
    }

    public Skills getPerception() {
        return this.perception;
    }

    public void setStrength(Skills strength) {
        this.strength = strength;
    }

    public Skills getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "Sheet [Name=" + getName() + ", age=" + getAge() + ", race=" + getRace() + ", occupation=" + occupation + ", appearances=" + appearances + ", agility=" + agility
                + ", charism=" + charism + ", power=" + power + ", intellect=" + intellect + ", perception="
                + perception + ", strength=" + strength + "]";
    }
}
