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
        YamlConfiguration yml=null;
        PlayerData playerData;
        try{
            yml = new YamlConfiguration();
            yml.load("players.prop");
            Object unknownData = yml.get(Bukkit.getPlayer(playerName).getUniqueId()+"");
            if (unknownData instanceof PlayerData)
                playerData = (PlayerData) unknownData;
            else{
                Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"ERROR: "+ChatColor.WHITE+"Object in YML file is not instance of PlayerData!");
                throw new InvalidConfigurationException("Failed to convert Object to PlayerData!");
            }
            setAllAttributes(playerData);
        } catch (InvalidConfigurationException i) {
            this.player = Bukkit.getPlayer(playerName);
            this.playerID = this.player.getUniqueId();
            this.customWelcomeMessage = ChatColor.WHITE+" has joined the server.";
            this.customExitMessage = ChatColor.WHITE+" has left the server";
            this.currentRank = Ranks.NEWBIE;
            this.data = null;
            yml.set(String.valueOf(playerID), this);
        } catch (IOException e) {
            e.printStackTrace();
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
    public void setAllAttributes(PlayerData data){
        this.data = data.data;
        this.currentRank = data.currentRank;
        this.customExitMessage = data.customExitMessage;
        this.customWelcomeMessage = data.customWelcomeMessage;
        this.player = data.player;
        this.playerID = data.playerID;
    }
}
