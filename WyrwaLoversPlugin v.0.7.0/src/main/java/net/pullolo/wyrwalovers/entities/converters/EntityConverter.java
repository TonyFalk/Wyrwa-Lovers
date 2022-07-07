package net.pullolo.wyrwalovers.entities.converters;

import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static net.pullolo.wyrwalovers.Main.econ;
import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class EntityConverter extends BukkitRunnable {

    public static List<Entity> entities = new ArrayList<>();

    @Override
    public void run() {
        for (World w:Bukkit.getWorlds()){
            for (Entity e:w.getEntities()){
                if (!entities.contains(e)){
                    if (e instanceof Damageable){
                        if (e instanceof LivingEntity){
                            if (!e.getType().equals(EntityType.ARMOR_STAND)){
                                if (!(e instanceof Player)){
                                    entities.add(e);
                                    entityMap.put(e, new EntityStats(e, null));
                                }
                            }
                        }
                    }
                }
            }
        }
        ArrayList<Entity> toDel = new ArrayList<>();
        for (Entity e:entities){
            if (e instanceof Player){
                float speed = (float) (entityMap.get(e).getSpeed()/500);
                ((Player) e).setWalkSpeed(speed);
                if (entityMap.get(e).getHealth() <= 0){
                    if (((Player) e).getInventory().getItemInMainHand().equals(new ItemStack(Material.TOTEM_OF_UNDYING)) || ((Player) e).getInventory().getItemInOffHand().equals(new ItemStack(Material.TOTEM_OF_UNDYING))){
                        e.getWorld().playSound(e.getLocation(), Sound.ITEM_TOTEM_USE, 1, 1);
                        entityMap.get(e).setHealth(entityMap.get(e).getMaxHealth()/20);
                        if (((Player) e).getInventory().getItemInMainHand().equals(new ItemStack(Material.TOTEM_OF_UNDYING))){
                            ((Player) e).getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                        } else {
                            ((Player) e).getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                        }
                        e.getWorld().spawnParticle(Particle.TOTEM, e.getLocation().add(0, 1, 0), 100, 0.1, 0, 0.1, 1);
                    } else {
                        entityMap.get(e).respawn();
                        try{
                            e.teleport(((Player) e).getBedSpawnLocation());
                        } catch (Exception er){
                            try{
                                e.teleport(Bukkit.getServer().getWorld(e.getWorld().getName()).getSpawnLocation());
                            } catch (Exception err){
                                Bukkit.getServer().getConsoleSender().sendMessage("The player " + ((Player) e).getPlayerListName() + " couldn't respawn properly!");
                            }
                        }
                        for (Player player : Bukkit.getOnlinePlayers()){
                            TextComponent m1 = new TextComponent("[Server]: F in the chat for " + ((Player) e).getPlayerListName());
                            try {
                                if (((EntityDamageByEntityEvent) e.getLastDamageCause()).getDamager() instanceof Player){
                                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Died of " + e.getLastDamageCause().getCause().toString().toLowerCase() + " by " + ((Player) ((EntityDamageByEntityEvent) e.getLastDamageCause()).getDamager()).getDisplayName())));
                                } else m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Died of " + e.getLastDamageCause().getCause().toString().toLowerCase() + " by " + entityMap.get(((EntityDamageByEntityEvent) e.getLastDamageCause()).getDamager()).getCustomName())));
                            } catch (Exception er){
                                try {
                                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Died of " + e.getLastDamageCause().getCause().toString().toLowerCase())));
                                } catch (Exception err){
                                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§7Died Of Death")));
                                }
                            }
                            player.spigot().sendMessage(m1);
                        }
                        if (econ != null){
                            double amount = econ.getBalance((OfflinePlayer) e)/2;
                            econ.withdrawPlayer((OfflinePlayer) e, amount);
                            DecimalFormat df = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.GERMAN));
                            e.sendMessage(ChatColor.RED + "You died and lost " + df.format(amount) + " coins!");
                        } else {
                            e.sendMessage(ChatColor.RED + "You died!");
                        }
                        e.setFireTicks(0);
                        ((Player) e).playSound(e, Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1, 2);
                    }
                }
            }
            else {
                if (entityMap.get(e).getHealth() <= 0){
                    entityMap.get(e).setHealth(0.0);
                    entityMap.get(e).updateStats(e);
                    ((Damageable) e).setHealth(0);
                    toDel.add(e);
                }
            }
        }
        for (Entity e:toDel) {
            BukkitRunnable r1 = new BukkitRunnable() {
                @Override
                public void run() {
                    if (e != null){
                        e.remove();
                    }
                }
            };
            if (e instanceof EnderDragon){
                r1.runTaskLater(plugin, 200);
            } else {
                r1.runTaskLater(plugin, 20);
            }
            entities.remove(e);
            entityMap.remove(e);
        }
        for (Entity e:entities) {
            if (!(e instanceof Player)){
                entityMap.get(e).updateStats(e);
                ((Damageable) e).setMaxHealth(40);
                ((Damageable) e).setHealth(40);
                if (e instanceof EnderDragon){
                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 255, false, false, false));
                    float h = (float) (entityMap.get(e).getHealth() / entityMap.get(e).getMaxHealth());
                    h = h * 40;
                    if (h >= 1){
                        ((Damageable) e).setHealth((int) h);
                    }
                    else {
                        ((Damageable) e).setHealth(1);
                    }

//                    if (e.)
                }
            }
            else {
                entityMap.get(e).updateStats(e);
                float h = (float) (entityMap.get(e).getHealth() / entityMap.get(e).getMaxHealth());
                h = h * 20;
                ((Player) e).setFoodLevel(20);
                ((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 255, false, false, false));
                ((Damageable) e).setMaxHealth(20);
                if (h >= 1){
                    ((Damageable) e).setHealth((int) h);
                }
                else {
                    ((Damageable) e).setHealth(1);
                }
            }
        }
    }
}
