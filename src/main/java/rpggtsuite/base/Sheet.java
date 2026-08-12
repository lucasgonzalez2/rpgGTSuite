package rpggtsuite.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sheet {
    public static final int DEFAULT_LEVEL = 1;

    private String occupation;
    private String appearances;
    private AbilityScore strength;
    private AbilityScore dexterity;
    private AbilityScore constitution;
    private AbilityScore intelligence;
    private AbilityScore wisdom;
    private AbilityScore charisma;
    private Race race;
    private CharacterClass characterClass;
    private Alignment alignment;
    private int level;
    private int experience;
    private final Set<AbilityType> savingThrowProficiencies;
    private final Set<Skill> skillProficiencies;
    private final Set<Skill> skillExpertise;
    private final List<Spell> spells;

    public Sheet() {
        this.level = DEFAULT_LEVEL;
        this.savingThrowProficiencies = new HashSet<AbilityType>();
        this.skillProficiencies = new HashSet<Skill>();
        this.skillExpertise = new HashSet<Skill>();
        this.spells = new ArrayList<Spell>();
    }

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

    public AbilityScore getStrength() {
        return this.strength;
    }

    public void setStrength(AbilityScore strength) {
        this.strength = strength;
    }

    public AbilityScore getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(AbilityScore dexterity) {
        this.dexterity = dexterity;
    }

    public AbilityScore getConstitution() {
        return this.constitution;
    }

    public void setConstitution(AbilityScore constitution) {
        this.constitution = constitution;
    }

    public AbilityScore getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(AbilityScore intelligence) {
        this.intelligence = intelligence;
    }

    public AbilityScore getWisdom() {
        return this.wisdom;
    }

    public void setWisdom(AbilityScore wisdom) {
        this.wisdom = wisdom;
    }

    public AbilityScore getCharisma() {
        return this.charisma;
    }

    public void setCharisma(AbilityScore charisma) {
        this.charisma = charisma;
    }

    public AbilityScore getAbility(AbilityType type) {
        switch (type) {
            case STRENGTH:
                return this.strength;
            case DEXTERITY:
                return this.dexterity;
            case CONSTITUTION:
                return this.constitution;
            case INTELLIGENCE:
                return this.intelligence;
            case WISDOM:
                return this.wisdom;
            case CHARISMA:
                return this.charisma;
            default:
                throw new IllegalArgumentException("Unknown ability type: " + type);
        }
    }

    public int abilityModifier(AbilityType type) {
        AbilityScore ability = this.getAbility(type);
        return ability == null ? 0 : ability.getModifier();
    }

    public Race getRace() {
        return this.race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("A character level must be at least 1");
        }
        this.level = level;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int proficiencyBonus() {
        return ProficiencyBonus.forLevel(this.level);
    }

    public boolean addSavingThrowProficiency(AbilityType type) {
        return this.savingThrowProficiencies.add(type);
    }

    public boolean removeSavingThrowProficiency(AbilityType type) {
        return this.savingThrowProficiencies.remove(type);
    }

    public boolean isProficientInSavingThrow(AbilityType type) {
        return this.savingThrowProficiencies.contains(type);
    }

    public int savingThrowBonus(AbilityType type) {
        int bonus = this.abilityModifier(type);
        if (this.isProficientInSavingThrow(type)) {
            bonus += this.proficiencyBonus();
        }
        return bonus;
    }

    public boolean addSkillProficiency(Skill skill) {
        return this.skillProficiencies.add(skill);
    }

    public boolean removeSkillProficiency(Skill skill) {
        this.skillExpertise.remove(skill);
        return this.skillProficiencies.remove(skill);
    }

    public boolean isProficientInSkill(Skill skill) {
        return this.skillProficiencies.contains(skill);
    }

    public boolean addSkillExpertise(Skill skill) {
        if (!this.isProficientInSkill(skill)) {
            throw new IllegalStateException("A character needs proficiency before gaining expertise in " + skill);
        }
        return this.skillExpertise.add(skill);
    }

    public boolean hasSkillExpertise(Skill skill) {
        return this.skillExpertise.contains(skill);
    }

    public int skillBonus(Skill skill) {
        int bonus = this.abilityModifier(skill.getAbilityType());
        if (this.hasSkillExpertise(skill)) {
            bonus += this.proficiencyBonus() * 2;
        } else if (this.isProficientInSkill(skill)) {
            bonus += this.proficiencyBonus();
        }
        return bonus;
    }

    public List<Spell> getSpells() {
        return this.spells;
    }

    public boolean addSpell(Spell spell) {
        return this.spells.add(spell);
    }

    public boolean removeSpell(Spell spell) {
        return this.spells.remove(spell);
    }
}
