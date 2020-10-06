import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        getCommand("data").setExecutor(new CommandPlayerData(this));
    }
}
