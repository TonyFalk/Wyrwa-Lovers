package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.entities.events.OnEntityKilled;
import net.pullolo.wyrwalovers.entities.events.RareDropManager;
import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.items.Items.woodenSword;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static org.bukkit.Bukkit.getServer;

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

                    if (event.getItem().getItemMeta().getDisplayName().equals(healingStaff.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("HS", player)){
                            if (entityMap.get(player).getMana() >= 40){
                                CooldownAPI.addCooldown("HS", player, 18);
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - 40);

                                player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));

                                if (entityMap.get(player).getBonusHealthRegen().containsKey("hw")){
                                    entityMap.get(player).getBonusHealthRegen().replace("hw", (5+2.5*entityMap.get(player).getLevel()));
                                } else {
                                    entityMap.get(player).getBonusHealthRegen().put("hw", (5+2.5*entityMap.get(player).getLevel()));
                                }
                                BukkitRunnable healStop = new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        entityMap.get(player).getBonusHealthRegen().replace("hw", 0.0);
                                    }
                                };
                                healStop.runTaskLater(plugin, 100);
                            } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                        } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("HS", player) + "s.");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(golemSword.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= 140){
                            ArrayList<Entity> blocks = new ArrayList<>();
                            Random rand = new Random();
                            for (int i = 0; i<20; i++){
                                Entity e = player.getWorld().spawnFallingBlock(player.getLocation().add(rand.nextInt(11)-5, 5, rand.nextInt(11)-5), new MaterialData(Material.IRON_BLOCK));
                                e.setVelocity(new Vector(0, -1, 0));
                                FallingBlock en = (FallingBlock) e;
                                en.setDropItem(false);
                                blocks.add(e);
                            }
                            BukkitRunnable ironPunch = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    for (Entity en:player.getWorld().getNearbyEntities(player.getLocation().add(0, 1, 0), 5, 3, 5)){
                                        if (!en.equals(player)){
                                            if (entityMap.containsKey(en)){
                                                if (en instanceof Player){
                                                    if (isKillable((Player) en)){
                                                        entityMap.get(en).dealDamage(en, (entityMap.get(player).getDamage()/1.3 * Items.getItemStats(event.getItem()).getDamage()/2)*0.9, true, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                        ((Damageable) en).damage(0.01, player);
                                                    }
                                                } else {
                                                    entityMap.get(en).dealDamage(en, (entityMap.get(player).getDamage()/1.3 * Items.getItemStats(event.getItem()).getDamage()/2)*0.9, true, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) en).damage(0.01, player);
                                                    if (entityMap.get(en).getHealth()<=0){
                                                        RareDropManager.rollForDrop(en, player);
                                                        new OnEntityKilled(player, en);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    player.getWorld().spawnParticle(Particle.WHITE_ASH, player.getLocation().add(0, 0.1, 0), 1000, 3, 0.1, 3, 0.1);
                                    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1F, (float) 0.8);
                                    for (Entity e:blocks){
                                        FallingBlock en = (FallingBlock) e;
                                        if (en.getLocation().getBlock().getType().equals(Material.IRON_BLOCK)){
                                            en.getLocation().getBlock().setType(Material.AIR);
                                        }
                                        e.remove();
                                    }
                                    blocks.clear();
                                }
                            };
                            ironPunch.runTaskLater(plugin, 7);
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - 140);
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(hyperion.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= 300){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - 300);
                            player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1f, 1f);
                            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                            if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                player.teleport(loc);
                            }
                            else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1f, 1f);

                            for (int i = 0; i < 10; i++) {
                                if (player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                    player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                                }
                            }
                            List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation(), 8, 6, 8);
                            for (Entity entity : nearbyEntites){
                                if (!(entity.equals(event.getPlayer()))) {
                                    if (entity instanceof Damageable) {
                                        if (entityMap.containsKey(entity)){
                                            if (entity instanceof Player){
                                                if (isKillable((Player) entity)){
                                                    entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower() * Items.getItemStats(event.getItem()).getDamage()/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) entity).damage(0.01, player);
                                                }
                                            } else {
                                                entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower() * Items.getItemStats(event.getItem()).getDamage()/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                ((Damageable) entity).damage(0.01, player);
                                            }
                                        }
                                    }
                                }
                            }
                            player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, (player.getLocation().add(player.getLocation().getDirection().multiply(-3))), 4, 0.2, 0.1, 0.2, 0.3);
                            player.getWorld().spawnParticle(Particle.FLAME, (player.getLocation().add(player.getLocation().getDirection().multiply(-3))), 100, 0.6, 0.6, 0.6, 0.2);
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(aspectOfEnd.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= 50){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - 50);
                            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                            if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                player.teleport(loc);
                            }
                            else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));

                            for (int i = 0; i < 8; i++) {
                                if (player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                    player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                                }
                            }
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(leapingSword.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= 100){
                            if (!CooldownAPI.isOnCooldown("LS", player)){
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - 100);
                                CooldownAPI.addCooldown("LS", player, 10);

                                player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                                player.setVelocity(player.getLocation().getDirection().multiply(2.8));
                                List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation(), 8, 6, 8);

                                player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, (player.getLocation()), 4, 0.2, 0.1, 0.2, 0.3);
                                player.getWorld().spawnParticle(Particle.FLAME, (player.getLocation()), 100, 0.6, 0.6, 0.6, 0.2);

                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 255));

                                for (Entity entity : nearbyEntites){
                                    if (!(entity.equals(event.getPlayer()))) {
                                        if (entity instanceof Damageable) {
                                            if (entityMap.containsKey(entity)){
                                                double amount = 80;
                                                if (entity instanceof  Player){
                                                    if (isKillable((Player) entity)){
                                                        entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                        ((Damageable) entity).damage(0.01, player);
                                                    }
                                                } else {
                                                    entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) entity).damage(0.01, player);
                                                }
                                            }
                                        }
                                    }
                                }

                            } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("LS", player) + "s.");
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(aspectOfDragons.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= 100){
                            if (!CooldownAPI.isOnCooldown("AOD", player)){
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - 100);
                                CooldownAPI.addCooldown("AOD", player, 5);

                                player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f);
                                Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1.5, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                                for (int i = 10; i<19; i++){
                                    player.getWorld().spawnParticle(Particle.FLAME, loc.add(player.getLocation().getDirection().multiply(0.1 * i)), 10, 0.02 * i, 0.02 * i, 0.02 * i, 0.1);
                                }
                                List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation().add(player.getLocation().getDirection().multiply(4)), 5, 5, 5);
                                for (Entity entity : nearbyEntites){
                                    if (!(entity.equals(event.getPlayer()))) {
                                        if (entity instanceof Damageable) {
                                            if (entityMap.containsKey(entity)){
                                                double amount = 130;
                                                if (entity instanceof  Player){
                                                    if (isKillable((Player) entity)){
                                                        entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                        ((Damageable) entity).damage(0.01, player);
                                                    }
                                                } else {
                                                    entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) entity).damage(0.01, player);
                                                }
                                                entity.setVelocity(player.getLocation().getDirection().multiply(3));
                                            }
                                        }
                                    }
                                }

                            } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("AOD", player) + "s.");
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
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
                    if (entityMap.get(p).getBonusCritChance().containsKey(key)){
                        entityMap.get(p).getBonusCritChance().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getCritChance());
                    }else {
                        entityMap.get(p).getBonusCritChance().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getCritChance());
                    }
                    if (entityMap.get(p).getBonusMaxHealth().containsKey(key)){
                        entityMap.get(p).getBonusMaxHealth().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getHealth());
                    }else {
                        entityMap.get(p).getBonusMaxHealth().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getHealth());
                    }
                    if (entityMap.get(p).getBonusAbilityPower().containsKey(key)){
                        entityMap.get(p).getBonusAbilityPower().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getAbilityPower());
                    }else {
                        entityMap.get(p).getBonusAbilityPower().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getAbilityPower());
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
            if (entityMap.get(p).getBonusCritChance().containsKey(key)){
                entityMap.get(p).getBonusCritChance().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusCritChance().put(key, 0.0);
            }
            if (entityMap.get(p).getBonusMaxHealth().containsKey(key)){
                entityMap.get(p).getBonusMaxHealth().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusMaxHealth().put(key, 0.0);
            }
        }
        //For item conversion
        for (Player p: Bukkit.getOnlinePlayers()){
            if (p.getInventory().getItemInMainHand().getItemMeta() == null){
                continue;
            }
            if (customItems.contains(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName()) || customArmorItems.contains(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                continue;
            }
            if (p.getInventory().getItemInMainHand().getType().equals(Material.BOW)){
                p.getInventory().setItemInMainHand(bow);
            }
            if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_SWORD)){
                p.getInventory().setItemInMainHand(netheriteSword);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_SWORD)){
                p.getInventory().setItemInMainHand(diamondSword);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_SWORD)){
                p.getInventory().setItemInMainHand(ironSword);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_SWORD)){
                p.getInventory().setItemInMainHand(goldSword);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.STONE_SWORD)){
                p.getInventory().setItemInMainHand(stoneSword);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)){
                p.getInventory().setItemInMainHand(woodenSword);
            }
        }
    }

    private boolean isKillable(Player player){
        if (player.getGameMode().equals(GameMode.CREATIVE)){
            return false;
        }
        if (player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null && player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null){
            if (player.getInventory().getHelmet().getItemMeta() != null && player.getInventory().getChestplate().getItemMeta() != null
                    && player.getInventory().getLeggings().getItemMeta() != null && player.getInventory().getBoots().getItemMeta() != null){
                if (customArmorItems.contains(player.getInventory().getHelmet().getItemMeta().getDisplayName()) && customArmorItems.contains(player.getInventory().getChestplate().getItemMeta().getDisplayName())
                        && customArmorItems.contains(player.getInventory().getLeggings().getItemMeta().getDisplayName()) && customArmorItems.contains(player.getInventory().getBoots().getItemMeta().getDisplayName())){
                    if (player.getInventory().getHelmet().getItemMeta().getDisplayName().equals(angelHelmet.getItemMeta().getDisplayName())
                            && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals(angelChestplate.getItemMeta().getDisplayName())
                            && player.getInventory().getLeggings().getItemMeta().getDisplayName().equals(angelLeggings.getItemMeta().getDisplayName())
                            && player.getInventory().getBoots().getItemMeta().getDisplayName().equals(angelBoots.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("AA", player)){
                            CooldownAPI.addCooldown("AA", player, 40);
                            player.playSound(player, Sound.ITEM_SHIELD_BLOCK, 1, 1);
                            player.getWorld().spawnParticle(Particle.FLASH, player.getLocation(), 4, 0.1, 1, 0.1);
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
