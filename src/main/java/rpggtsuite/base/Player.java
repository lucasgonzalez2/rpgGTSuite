package rpggtsuite.base;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int uniqueID;
    private String macAddress;
    private String username;
    private String passwordHash;
    private final List<Character> characters;

    public Player() {
        this.characters = new ArrayList<Character>();
    }

    public boolean addCharacter(Character character) {
        return this.characters.add(character);
    }

    public boolean removeCharacter(Character character) {
        return this.characters.remove(character);
    }

    public List<Character> getCharacters() {
        return this.characters;
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
        this.passwordHash = hash(password);
    }

    public boolean checkPassword(String password) {
        return this.passwordHash != null && this.passwordHash.equals(hash(password));
    }

    private static String hash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder(bytes.length * 2);
            for (byte b : bytes) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not available", e);
        }
    }
}
