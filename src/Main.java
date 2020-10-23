import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private static YamlConfiguration yml = new YamlConfiguration();

    public static YamlConfiguration getPlayerYml() {
        try {
            yml.load("players.prop");
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
            new File("players.prop").createNewFile();
            Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW+"players.prop isn't existing\n"+ChatColor.AQUA+"Created new file: players.prop; please rejoin!");
        }
        finally {
            return yml;
        }
    }

    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        getCommand("data").setExecutor(new CommandPlayerData(this));
    }

}
