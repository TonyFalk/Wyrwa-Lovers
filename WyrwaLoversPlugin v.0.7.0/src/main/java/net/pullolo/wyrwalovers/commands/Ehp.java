package net.pullolo.wyrwalovers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class Ehp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ehp")){
            if (sender instanceof Player){
                sender.sendMessage("§7Your §4physical§7 ehp is §c" + Math.round(entityMap.get(sender).getHealth() * (1 + entityMap.get(sender).getDefense()/100)));
                sender.sendMessage("§7Your §3magical§7 ehp is §c" + Math.round(entityMap.get(sender).getHealth() * (1 + entityMap.get(sender).getResistance()/100)));
            } else sender.sendMessage("Only players can execute this command!");
        }
        return true;
    }
}
