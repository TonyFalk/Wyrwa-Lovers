package net.pullolo.wyrwalovers.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static net.pullolo.wyrwalovers.Main.prefix;

public class OnJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.getPlayer().sendMessage(prefix + "Welcome to the server!");
        e.getPlayer().sendMessage(ChatColor.RED + "[!] While you play, here is the list of unfinished features, so you don't have to waste time on these things!");
        e.getPlayer().sendMessage(ChatColor.GRAY + "---------------------------");
        e.getPlayer().sendMessage(ChatColor.GREEN + "Custom stats System!");
        e.getPlayer().sendMessage(ChatColor.GOLD + "Mobs leveling values!");
        e.getPlayer().sendMessage(ChatColor.RED + "Enchantments!");
        e.getPlayer().sendMessage(ChatColor.GREEN + "Stats saving!");
        e.getPlayer().sendMessage(ChatColor.RED + "Guis!");
        e.getPlayer().sendMessage(ChatColor.RED + "Leveling!");
        e.getPlayer().sendMessage(ChatColor.GREEN + "Money integration!");
        e.getPlayer().sendMessage(ChatColor.RED + "Bosses!");
        e.getPlayer().sendMessage(ChatColor.GOLD + "Custom mobs, items, armour!");
        e.getPlayer().sendMessage(ChatColor.RED + "Weapon upgrading!");
        e.getPlayer().sendMessage(ChatColor.GRAY + "---------------------------");
    }
}
