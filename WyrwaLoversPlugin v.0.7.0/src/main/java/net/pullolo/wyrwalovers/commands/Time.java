package net.pullolo.wyrwalovers.commands;

import net.pullolo.wyrwalovers.misc.TimeHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.Main.prefix;

public class Time implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("time")){
            if (args.length < 1){
                if (sender instanceof Player){
                    sender.sendMessage(prefix + "§7Current time is: §a" + TimeHandler.getTime(((Player) sender).getWorld()));
                } else {
                    sender.sendMessage(ChatColor.RED + "This cmd can only be used by Players!");
                }
            } else {
                if (sender instanceof Player){
                    if (sender.hasPermission("wl.set")){
                        if (args[0].equalsIgnoreCase("set")){
                            if (args[1].equalsIgnoreCase("day")){
                                ((Player) sender).getWorld().setTime(1000);
                            } else if(args[1].equalsIgnoreCase("night")){
                                ((Player) sender).getWorld().setTime(13000);
                            } else if(args[1].equalsIgnoreCase("noon")){
                                ((Player) sender).getWorld().setTime(6000);
                            } else if(args[1].equalsIgnoreCase("midnight")){
                                ((Player) sender).getWorld().setTime(18000);
                            } else {
                                try {
                                    ((Player) sender).getWorld().setTime(Long.parseLong(args[1]));
                                } catch (Exception e){
                                    sender.sendMessage(ChatColor.RED + "Invalid usage!");
                                }
                            }
                        }
                        sender.sendMessage(prefix + "§7Current time is now: §a" + TimeHandler.getTime(((Player) sender).getWorld()));
                    } else {
                        sender.sendMessage(ChatColor.RED + "You don't have perms!");
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "This cmd can only be used by Players!");
                }
            }
        }
        return true;
    }
}
