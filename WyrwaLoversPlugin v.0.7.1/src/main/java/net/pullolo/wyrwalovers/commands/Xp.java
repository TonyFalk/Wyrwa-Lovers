package net.pullolo.wyrwalovers.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.Main.xpManager;
import static net.pullolo.wyrwalovers.stats.Stats.xpMap;

public class Xp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("xp")){
            if (!(sender instanceof Player)){
                sender.sendMessage("Only players can do this!");
                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You have: &3" + xpMap.get(sender).getXp() + " &7xp."));
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You need &3" + xpManager.getAmountToLevelUp((Player) sender) + " &7xp to level up."));
        }
        return true;
    }
}
