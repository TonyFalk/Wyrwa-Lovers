package net.pullolo.wyrwalovers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class Stats implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("stats")){
            if (!(sender instanceof Player)){
                return false;
            }
            if (args.length > 0){
                try {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (entityMap.containsKey(target)){
                        sender.sendMessage("§7Displaying stats for " + sender.getName());
                        sender.sendMessage("§7-------------------------------");
                        sender.sendMessage("§7Level: §f" + entityMap.get(target).getLevel());
                        sender.sendMessage("§7Max Health: §4" + entityMap.get(target).getMaxHealth());
                        sender.sendMessage("§7Health Regen: §4" + entityMap.get(sender).getHealthRegen());
                        sender.sendMessage("§7Max Mana: §b" + entityMap.get(target).getMaxMana());
                        sender.sendMessage("§7Defense: §a" + entityMap.get(target).getDefense());
                        sender.sendMessage("§7Resistance: §3" + entityMap.get(target).getResistance());
                        sender.sendMessage("§7Ability Power: §3" + entityMap.get(target).getAbilityPower());
                        sender.sendMessage("§7Speed: §f" + entityMap.get(target).getSpeed());
                        sender.sendMessage("§7Damage: §c" + entityMap.get(target).getDamage());
                        sender.sendMessage("§7Crit Chance: §c" + entityMap.get(target).getCritChance() + " %");
                        sender.sendMessage("§7Crit Damage: §c" + entityMap.get(target).getCritDamage());
                        sender.sendMessage("§7-------------------------------");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                if (entityMap.containsKey(sender)){
                    sender.sendMessage("§7Displaying stats for " + sender.getName());
                    sender.sendMessage("§7-------------------------------");
                    sender.sendMessage("§7Level: §f" + entityMap.get(sender).getLevel());
                    sender.sendMessage("§7Max Health: §4" + entityMap.get(sender).getMaxHealth());
                    sender.sendMessage("§7Health Regen: §4" + entityMap.get(sender).getHealthRegen());
                    sender.sendMessage("§7Max Mana: §b" + entityMap.get(sender).getMaxMana());
                    sender.sendMessage("§7Defense: §a" + entityMap.get(sender).getDefense());
                    sender.sendMessage("§7Resistance: §3" + entityMap.get(sender).getResistance());
                    sender.sendMessage("§7Ability Power: §3" + entityMap.get(sender).getAbilityPower());
                    sender.sendMessage("§7Speed: §f" + entityMap.get(sender).getSpeed());
                    sender.sendMessage("§7Damage: §c" + entityMap.get(sender).getDamage());
                    sender.sendMessage("§7Crit Chance: §c" + entityMap.get(sender).getCritChance() + " %");
                    sender.sendMessage("§7Crit Damage: §c" + entityMap.get(sender).getCritDamage());
                    sender.sendMessage("§7-------------------------------");
                }
            }
        }
        return true;
    }
}
