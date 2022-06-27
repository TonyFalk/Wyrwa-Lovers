package net.pullolo.wyrwalovers.entities.events;

import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
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
import static net.pullolo.wyrwalovers.items.Items.slimeSword;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class RareDropManager implements Listener {

    private static final Random rand = new Random();

    public static void rollForDrop(Entity e, Player damager){

        int chance = 1;
        if (entityMap.get(e).getEntityType().equalsIgnoreCase(EntityType.ZOMBIE.toString().toLowerCase())){
            if (rand.nextInt(100) <= chance){
                playDropSound(damager);
                damager.sendMessage("§8[§eRARE DROP!§8] §b" + "Diamond");
                ItemStack item = new ItemStack(Material.DIAMOND);

                if (Arrays.asList(damager.getInventory().getStorageContents()).contains(null)){
                    damager.getInventory().addItem(item);
                }else {
                    damager.getWorld().dropItem(damager.getLocation(), item);
                }
            } else if (rand.nextInt(465) <= chance){
                playDropSound(damager);
                damager.sendMessage("§8[§d§ka §dVERY RARE DROP! §ka§8] §e" + "Totem of Undying");
                ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);

                if (Arrays.asList(damager.getInventory().getStorageContents()).contains(null)){
                    damager.getInventory().addItem(item);
                }else {
                    damager.getWorld().dropItem(damager.getLocation(), item);
                }
            }
        }
        else if (entityMap.get(e).getEntityType().equalsIgnoreCase(EntityType.SLIME.toString().toLowerCase())){
            if (rand.nextInt(700) <= chance){
                playDropSound(damager);
                damager.sendMessage("§8[§d§ka §dVERY RARE DROP! §ka§8] " + slimeSword.getItemMeta().getDisplayName());

                if (Arrays.asList(damager.getInventory().getStorageContents()).contains(null)){
                    damager.getInventory().addItem(slimeSword);
                }else {
                    damager.getWorld().dropItem(damager.getLocation(), slimeSword);
                }
            }
        }
        if (rand.nextInt(5) == 0){
            if (econ != null){
                int am = (rand.nextInt(5)+5)*entityMap.get(e).getLevel()/5;
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

    private static void playDropSound(Player damager){
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
    }
}
