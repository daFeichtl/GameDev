import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

public class PlayerData {
    private Player player;
    private UUID playerID;
    private String customWelcomeMessage;
    private String customExitMessage;
    private String[] data; //can init with null
    private Ranks currentRank;

    public PlayerData(Player player, UUID playerID, String[] data, Ranks currentRank, String customWelcomeMessage) {
        this.player = player;
        this.playerID = playerID;
        this.data = data;
        this.currentRank = currentRank;
        this.customWelcomeMessage = customWelcomeMessage;
    }

    public PlayerData(UUID playerID, String[] data, Ranks currentRank) {
        this.playerID = playerID;
        this.data = data;
        this.currentRank = currentRank;
    }

    public PlayerData(String playerName) {
        try{
            YamlConfiguration yml = new YamlConfiguration();
            yml.load("players.prop");
            player = Bukkit.getPlayer(playerName);
            playerID = player.getUniqueId();
        } catch (NullPointerException n){
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"PlayerData cannot be obtained! (Player does not exist!)");
        } catch (InvalidConfigurationException | IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"YML file failed to init");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public UUID getPlayerID() {
        return playerID;
    }

    public void setPlayerID(UUID playerID) {
        this.playerID = playerID;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public Ranks getCurrentRank() {
        return currentRank;
    }

    public void setCurrentRank(Ranks currentRank) {
        this.currentRank = currentRank;
    }

    public String getCustomWelcomeMessage() {
        return customWelcomeMessage;
    }

    public void setCustomWelcomeMessage(String customWelcomeMessage) {
        this.customWelcomeMessage = customWelcomeMessage;
    }
    public static PlayerData getDefaultPlayerData(String playerName){
        Player player = Bukkit.getPlayer(playerName);
        UUID id = player.getUniqueId();
        return new PlayerData(player, id, null, Ranks.NEWBIE, "has joined the server");
    }

    public String getCustomExitMessage() {
        return customExitMessage;
    }

    public void setCustomExitMessage(String customExitMessage) {
        this.customExitMessage = customExitMessage;
    }

    public String getWelcomeMessage(){
        return currentRank.getPlayerColor()+player.getDisplayName()+" "+customWelcomeMessage;
    }

    public String getExitMessage(){
        return currentRank.getPlayerColor()+player.getDisplayName()+" "+customExitMessage;
    }
}
