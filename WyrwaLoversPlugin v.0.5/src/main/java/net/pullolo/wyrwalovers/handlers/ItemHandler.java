package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.items.ItemStats;
import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.items.Items.woodenSword;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class ItemHandler extends BukkitRunnable implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            if (event.getItem() != null && event.getItem().getItemMeta() != null){
                if (customItems.contains(event.getItem().getItemMeta().getDisplayName())){
                    //Todo check for static ItemStacks in Items class and do the ability
                    if (event.getItem().getItemMeta().getDisplayName().equals(healingWand.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("HW", player)){
                            if (entityMap.get(player).getMana() >= 60){
                                CooldownAPI.addCooldown("HW", player, 20);
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - 60);

                                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));

                                if (entityMap.get(player).getBonusHealthRegen().containsKey("hw")){
                                    entityMap.get(player).getBonusHealthRegen().replace("hw", (double) (5+2*entityMap.get(player).getLevel()));
                                } else {
                                    entityMap.get(player).getBonusHealthRegen().put("hw", (double) (5+2*entityMap.get(player).getLevel()));
                                }
                                BukkitRunnable healStop = new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        entityMap.get(player).getBonusHealthRegen().replace("hw", 0.0);
                                    }
                                };
                                healStop.runTaskLater(plugin, 100);
                            } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                        } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("HW", player) + "s.");
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        //Todo read item stats and add bonuses accordingly
        for (Player p : Bukkit.getOnlinePlayers()){
            String key = "itemHeld";
            if (p.getInventory().getItemInMainHand().getItemMeta() != null){
                if (customItems.contains(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                    if (entityMap.get(p).getBonusDefense().containsKey(key)){
                        entityMap.get(p).getBonusDefense().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getDefense());
                    }else {
                        entityMap.get(p).getBonusDefense().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getDefense());
                    }
                    if (entityMap.get(p).getBonusCritDamage().containsKey(key)){
                        entityMap.get(p).getBonusCritDamage().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getCritDamage());
                    }else {
                        entityMap.get(p).getBonusCritDamage().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getCritDamage());
                    }
                    continue;
                }
            }
            if (entityMap.get(p).getBonusDefense().containsKey(key)){
                entityMap.get(p).getBonusDefense().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusDefense().put(key, 0.0);
            }
            if (entityMap.get(p).getBonusCritDamage().containsKey(key)){
                entityMap.get(p).getBonusCritDamage().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusCritDamage().put(key, 0.0);
            }
        }
        //For item conversion
        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getInventory().getItemInMainHand().getItemMeta() == null){
                continue;
            }
            if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.BOW))){
                p.getInventory().setItemInMainHand(bow);
            }
            if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.NETHERITE_SWORD))){
                p.getInventory().setItemInMainHand(netheriteSword);
            }
            else if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.DIAMOND_SWORD))){
                p.getInventory().setItemInMainHand(diamondSword);
            }
            else if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.IRON_SWORD))){
                p.getInventory().setItemInMainHand(ironSword);
            }
            else if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.GOLDEN_SWORD))){
                p.getInventory().setItemInMainHand(goldSword);
            }
            else if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.STONE_SWORD))){
                p.getInventory().setItemInMainHand(stoneSword);
            }
            else if (p.getInventory().getItemInMainHand().equals(new ItemStack(Material.WOODEN_SWORD))){
                p.getInventory().setItemInMainHand(woodenSword);
            }
        }
    }
}
