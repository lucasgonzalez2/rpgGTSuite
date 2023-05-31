public class Character extends Creature{
    
    public Character(String name) {
        super(name);
    }

    private String nickname;

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}