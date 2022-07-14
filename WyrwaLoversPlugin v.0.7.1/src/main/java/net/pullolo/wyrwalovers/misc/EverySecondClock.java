package net.pullolo.wyrwalovers.misc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static net.pullolo.wyrwalovers.stats.entities.EntityStats.levelScale;

public class EverySecondClock extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e:entities) {
            entityMap.get(e).regen();
            entityMap.get(e).regenMana();
        }
        int sum = 0;
        int count = 0;
        for (Player p:Bukkit.getOnlinePlayers()) {
            sum += entityMap.get(p).getLevel();
            count++;
        }
        if (count == 0){
            levelScale = 1;
        } else levelScale = sum/count;
    }
}
