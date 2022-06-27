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

public class EverySecondClock extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e:entities) {
            entityMap.get(e).regen();
            entityMap.get(e).regenMana();
        }
    }
}
