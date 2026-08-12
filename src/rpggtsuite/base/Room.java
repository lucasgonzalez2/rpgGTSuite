package rpggtsuite.base;

import java.util.ArrayList;
import java.util.List;

public class Room<P extends Player> {
    private final List<P> players;
    private String gameName;
    private final String roomName;
    private String password;
    private final Master master;

    public Room(Master master, String gameName, String roomName) {
        this.master = master;
        this.gameName = gameName;
        this.roomName = roomName;
        this.players = new ArrayList<P>();
    }

    public Room(Master master, String gameName, String roomName, String password) {
        this(master, gameName, roomName);
        this.password = password;
    }

    public boolean addPlayer(P player) {
        return this.players.add(player);
    }

    public boolean removePlayer(P player) {
        return this.players.remove(player);
    }

    public List<P> getPlayers() {
        return this.players;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public Master getMaster() {
        return this.master;
    }

    public boolean hasPassword() {
        return this.password != null;
    }

    public boolean checkPassword(String password) {
        return this.password != null && this.password.equals(password);
    }
}
