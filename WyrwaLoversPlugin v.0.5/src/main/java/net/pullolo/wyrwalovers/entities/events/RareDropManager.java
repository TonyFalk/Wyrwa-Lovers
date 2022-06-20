package net.pullolo.wyrwalovers.entities.events;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

import static net.pullolo.wyrwalovers.Main.econ;
import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class RareDropManager implements Listener {

    private static final Random rand = new Random();

    public static void rollForDrop(Entity e, Player damager){

        int chance;
        if (entityMap.get(e).getEntityType().equalsIgnoreCase("zombie")){
            chance = 1;
            if (rand.nextInt(100) <= chance){
                BukkitRunnable r1 = new BukkitRunnable() {
                    @Override
                    public void run() {
                        damager.playSound(damager.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, (float) 0.6);
                    }
                };
                BukkitRunnable r2 = new BukkitRunnable() {
                    @Override
                    public void run() {
                        damager.playSound(damager.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, (float) 0.8);
                    }
                };
                BukkitRunnable r3 = new BukkitRunnable() {
                    @Override
                    public void run() {
                        damager.playSound(damager.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, (float) 1);
                    }
                };
                r1.runTaskLater(plugin, 0);
                r2.runTaskLater(plugin, 6);
                r3.runTaskLater(plugin, 12);
                damager.sendMessage("§8[§eRARE DROP!§8] §b" + "Diamond");
                ItemStack item = new ItemStack(Material.DIAMOND);

                if (Arrays.asList(damager.getInventory().getStorageContents()).contains(null)){
                    damager.getInventory().addItem(item);
                }else {
                    damager.getWorld().dropItem(damager.getLocation(), item);
                }
            }
        }
        if (rand.nextInt(5) == 0){
            if (econ != null){
                int am = (rand.nextInt(5)+5)*entityMap.get(e).getLevel();
                econ.depositPlayer(damager, am);
                BukkitRunnable r1 = new BukkitRunnable() {
                    @Override
                    public void run() {
                        damager.playSound(damager.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 3F, (float) 2);
                    }
                };
                r1.runTaskLater(plugin, 6);
                damager.sendMessage( ChatColor.GREEN + "+ " + am + " coins!");
            }
        }
    }
}
