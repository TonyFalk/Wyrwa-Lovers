package net.pullolo.wyrwalovers.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Invis implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("Only players can use this!");
            return true;
        }
        ((Player) sender).setInvisible(!((Player) sender).isInvisible());
        return true;
    }
}
