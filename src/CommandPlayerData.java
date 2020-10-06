import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandPlayerData implements CommandExecutor {
    Main plugin;

    public CommandPlayerData(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            switch (args[0]){
                case "add":
                    break;
                case "delete":
                    break;
                case "modify":
                    break;
            }
        }
        else if (sender instanceof ConsoleCommandSender){
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

        }
        return true;
    }
}
