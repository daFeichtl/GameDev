import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;
import java.util.List;

public class PlayerJoin implements Listener {
    Main main;

    public PlayerJoin(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        PlayerData playerData = PlayerData.getDefaultPlayerData(player.getDisplayName());
        YamlConfiguration yml = new YamlConfiguration();
        ChatColor color = playerData.getCurrentRank().getPlayerColor();
        try {
            yml.load("players.prop");
            Object data = yml.get(player.getUniqueId().toString());
            if (data instanceof PlayerData){
                playerData = (PlayerData) data;
                color = playerData.getCurrentRank().getPlayerColor();
            }
            else{
                throw new IOException("YML File failed to load PlayerData!");
            }
        } catch (IOException | InvalidConfigurationException ex) {
            Bukkit.getConsoleSender().sendMessage(ex.getMessage());
        }
        finally {
            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
            for(Player player1:players){
                player1.sendMessage(playerData.getCustomWelcomeMessage());
            }
        }
    }
}
