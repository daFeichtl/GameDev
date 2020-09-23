import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CustomWelcomeMessage {
    private String msg;
    private Player player;

    public CustomWelcomeMessage(String msg, Player player) {
        this.msg = msg;
        this.player = player;
    }
    public CustomWelcomeMessage(Player player) {
        this.msg = "";
        this.player = player;
    }


}
