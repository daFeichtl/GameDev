import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
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
                case "del":

                    break;
                case "mod":
                    YamlConfiguration yml = Main.getPlayerYml();
                    switch (args[1]){
                        case "exit_msg":
                            String exitMsg = args[2];
                            break;
                        case "welcome_msg":
                            String welcomeMsg = args[2];

                            break;
                        default:
                            player.sendMessage(ChatColor.RED+"Illegal input! Use /help GameDev for more");
                            break;
                    }
                    break;
            }
        }
        else if (sender instanceof ConsoleCommandSender){
            ConsoleCommandSender console = (ConsoleCommandSender) sender;

        }
        return true;
    }
}
