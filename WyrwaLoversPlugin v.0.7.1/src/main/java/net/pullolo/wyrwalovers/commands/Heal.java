package net.pullolo.wyrwalovers.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0){
            if (cmd.getName().equalsIgnoreCase("heal")){
                if (sender instanceof Player){
                    entityMap.get(sender).heal();
                    entityMap.get(sender).setMana(entityMap.get(sender).getMaxMana());
                }
            }
        } else if (args.length == 1) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                entityMap.get(target).heal();
                entityMap.get(target).setMana(entityMap.get(target).getMaxMana());
            } catch (Exception er){
                sender.sendMessage(ChatColor.RED + "Invalid usage!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Invalid usage!");
        }
        return true;
    }
}
