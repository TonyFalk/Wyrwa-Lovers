package net.pullolo.wyrwalovers.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static net.pullolo.wyrwalovers.stats.Stats.xpMap;

public class Set implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("set")){
            if (args.length == 3){
                try{
                    Player target = Bukkit.getPlayer(args[0]);
                    if (args[1].equalsIgnoreCase("level")){
                        try{
                            entityMap.get(target).setLevel(Integer.valueOf(args[2]));
                        } catch (Exception er){
                            sender.sendMessage(ChatColor.RED + "Level has to be a number!");
                        }
                    }
                    if (args[1].equalsIgnoreCase("xp")){
                        try{
                            xpMap.get(target).setXp(Double.parseDouble(args[2]));
                        } catch (Exception er){
                            sender.sendMessage(ChatColor.RED + "Xp has to be a number!");
                        }
                    }
                } catch (Exception e){
                    sender.sendMessage(ChatColor.RED + "Invalid usage!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Invalid usage!");
            }
        }
        return true;
    }
}
