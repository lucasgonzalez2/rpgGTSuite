import java.util.ArrayList;

public class Player {
    private int uniqueID;
    private String macAddress;
    private String username;
    private String password;
    private ArrayList<Character> characters;

    public Player() {
        characters = new ArrayList<Character>();
    }

    public boolean addCharacter(Character character) {
        return this.characters.add(character);
    }

    public boolean removeCharacter(Character character) {
        return this.characters.remove(character);
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }
}
