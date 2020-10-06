import org.bukkit.ChatColor;

public enum Ranks {
    OWNER(1, ChatColor.DARK_RED, "ranks.owner"), ADMIN(2, ChatColor.RED,"ranks.admin"), MOD(3, ChatColor.BLUE,"ranks.mod"), BUILDER(4,ChatColor.DARK_GREEN,"ranks.builder"), USER(5,ChatColor.GREEN,"ranks.user"), NEWBIE(6, ChatColor.GRAY,"ranks.noob");

    private int number;
    private ChatColor playerColor;
    private String permission;

    Ranks(int number, ChatColor playerColor, String permission) {
        this.number = number;
        this.playerColor = playerColor;
        this.permission=permission;
    }

    public int getNumber() {
        return number;
    }

    public ChatColor getPlayerColor() {
        return playerColor;
    }

    public String getPermission() {
        return permission;
    }
}
