import java.util.ArrayList;

public class Room {
    private ArrayList<Player> players;
    private String gameName;
    private String roomName;
    private String passaword;
    private Master master;

    public Room(Master master, String gameName, String roomName) {
        this.gameName = gameName;
        this.master = master;
        this.roomName = roomName;
    }

    public Room(Master master, String gameName, String roomName, String password) {
        this(master, gameName, roomName);
        this.passaword = password;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return this.gameName;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }
}