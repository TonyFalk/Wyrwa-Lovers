package net.pullolo.wyrwalovers.commands;

import net.pullolo.wyrwalovers.entities.Entities;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import java.util.ArrayList;

public class Spawnmob implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("spawnmob")){
            if (sender instanceof Player){
                if (args[0].equalsIgnoreCase("lapiszombie")){
                    //spawn
                    Entities.spawnLapisZombie(((Player) sender).getWorld().spawn(((Player) sender).getLocation(), Zombie.class));
                }
            } else {
                try {
                    Location loc;
                    World w;
                    ArrayList<String> names = new ArrayList<>();
                    for (Player p:Bukkit.getOnlinePlayers()){
                        names.add(p.getName().toLowerCase());
                    }
                    if (names.contains(args[1])){
                        Player target = Bukkit.getPlayer(args[1]);
                        loc = target.getLocation();
                        w = target.getWorld();
                    } else {
                        Location locc = new Location(Bukkit.getWorld("world"), Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]));
                        loc = locc;
                        w = Bukkit.getWorld("world");
                    }

                    if (args[0].equalsIgnoreCase("lapiszombie")){
                        //spawn
                        Entities.spawnLapisZombie(w.spawn(loc, Zombie.class));
                    }
                } catch (Exception e){
                    sender.sendMessage("Invalid usage!");
                }
            }
        }
        return true;
    }
}
