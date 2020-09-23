import org.bukkit.ChatColor;

public enum Ranks {
    OWNER(1, ChatColor.DARK_RED), ADMIN(2, ChatColor.RED), MOD(3, ChatColor.BLUE), BUILDER(4,ChatColor.DARK_GREEN), USER(5,ChatColor.GREEN), NEWBIE(6, ChatColor.GRAY);

    private int number;
    private ChatColor playerColor;

    Ranks(int number, ChatColor playerColor) {
        this.number = number;
        this.playerColor = playerColor;
    }
}
