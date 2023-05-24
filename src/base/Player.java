public class Player {
    private String name;
    private String nickname;
    private String race;
    private String description;
    private int age;

    public Player(String name) {
        this.name = name;
    }

    public void getNickname(String nickname) {
        this.nickname = nickname;
    }

    public void getRace(String race) {
        this.race = race;
    }

    public void getDescription(String description) {
        this.description = description;
    }

    public void getAge(int age) {
        this.age = age;
    }

    public String setNick() {
        return this.nickname;
    }

    public String setName() {
        return this.name;
    }

    public String setRace() {
        return this.race;
    }

    public String setDescription() {
        return this.description;
    }

    public int setAge() {
        return this.age;
    }

    public String setPlayer() {
        return setNick() + " " + setAge() + " " + setRace() + " " + setDescription();
    }
}