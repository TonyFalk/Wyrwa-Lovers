package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.entities.events.OnEntityKilled;
import net.pullolo.wyrwalovers.entities.events.RareDropManager;
import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import org.bukkit.*;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerFishEvent;
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
import static net.pullolo.wyrwalovers.handlers.ArmourHandler.calcBaseManaWithBonuses;
import static net.pullolo.wyrwalovers.handlers.ArmourHandler.afterTeleportation;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.items.Items.woodenSword;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static org.bukkit.Bukkit.getServer;

public class ItemHandler extends BukkitRunnable implements Listener {

    @EventHandler
    public void preventPlace(BlockPlaceEvent event){
        if (event.getItemInHand().getType().equals(Material.PLAYER_HEAD)){
            if (event.getItemInHand().getItemMeta() != null){
                if (customItems.contains(event.getItemInHand().getItemMeta().getDisplayName()) || customArmorItems.contains(event.getItemInHand().getItemMeta().getDisplayName())){
                    event.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onShoot(EntityShootBowEvent event) {
        if (event.getBow() != null){
            if (event.getBow().getItemMeta() != null){
                if (event.getBow().getItemMeta().getDisplayName().equals(hurricaneBow.getItemMeta().getDisplayName())){
                    float force = (float) (event.getForce()*2.5);
                    Arrow a1 = event.getEntity().launchProjectile(Arrow.class, rotateVector(event.getEntity().getLocation().getDirection().multiply(force), 0.2));
                    Arrow a2 = event.getEntity().launchProjectile(Arrow.class, rotateVector(event.getEntity().getLocation().getDirection().multiply(force), -0.2));
                    a1.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
                    a2.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
                }
            }
        }
    }

    private Vector rotateVector(Vector vector, double whatAngle) {
        double sin = Math.sin(whatAngle);
        double cos = Math.cos(whatAngle);
        double x = vector.getX() * cos + vector.getZ() * sin;
        double z = vector.getX() * -sin + vector.getZ() * cos;

        return vector.setX(x).setZ(z);
    }

    @EventHandler
    public void onFishingRod(PlayerFishEvent ev){
        if (ev.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(grapplingHook.getItemMeta().getDisplayName())){
            if (ev.getState().equals(PlayerFishEvent.State.REEL_IN) || ev.getState().equals(PlayerFishEvent.State.IN_GROUND)){
                if (!CooldownAPI.isOnCooldown("GH" ,ev.getPlayer())){
                    CooldownAPI.addCooldown("GH", ev.getPlayer(), 2);
                    Location playerLoc = ev.getPlayer().getLocation();
                    Location hookLoc;
                    if (ev.getHook().getLocation().getY() < ev.getPlayer().getLocation().getY()){
                        hookLoc = new Location(ev.getHook().getWorld(), ev.getHook().getLocation().getX(), ev.getPlayer().getLocation().add(0, 1, 0).getY(), ev.getHook().getLocation().getZ());
                    }
                    else if (ev.getHook().getLocation().getY() > ev.getPlayer().getLocation().add(0, 3, 0).getY()){
                        hookLoc = new Location(ev.getHook().getWorld(), ev.getHook().getLocation().getX(), ev.getPlayer().getLocation().add(0, 3, 0).getY(), ev.getHook().getLocation().getZ());
                    }
                    else {
                        hookLoc = ev.getHook().getLocation();
                    }
                    Location change = hookLoc.subtract(playerLoc);
                    ev.getPlayer().setVelocity(change.toVector().multiply(0.3));
                } else ev.getPlayer().sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("GH", ev.getPlayer()) + "s.");
            }
        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event){
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            Player player = event.getPlayer();
            if (event.getItem() != null && event.getItem().getItemMeta() != null){
                if (customItems.contains(event.getItem().getItemMeta().getDisplayName())){
                    //Todo check for static ItemStacks in Items class and do the ability
                    if (event.getItem().getItemMeta().getDisplayName().equals(healingWand.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("HW", player)){
                            if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(60, player)){
                                CooldownAPI.addCooldown("HW", player, 20);
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(60, player));

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
                     if (event.getItem().getItemMeta().getDisplayName().equals(EnderSword.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("ES", player)){
                            if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(60, player)){
                                CooldownAPI.addCooldown("ES", player, 20);
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(60, player));

                                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 1));
                                Location loc = player.getLocation();
                                Vector dir = loc.getDirection();
                                dir.normalize();
                                dir.multiply(10);
                                loc.add(dir);
                                player.teleport(loc);
                            } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                        } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("ES", player) + "s.");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(healingStaff.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("HS", player)){
                            if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(40, player)){
                                CooldownAPI.addCooldown("HS", player, 18);
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(40, player));

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
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(140, player)){
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
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(140, player));
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(hyperion.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(300, player)){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(300, player));
                            player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1f, 1f);
                            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                            if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.TALL_GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.DEAD_BUSH)) {
                                player.teleport(loc);
                            }
                            else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1f, 1f);

                            for (int i = 0; i < 10; i++) {
                                if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.TALL_GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.DEAD_BUSH)) {
                                    player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                                }
                            }
                            afterTeleportation(player);
                            List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation(), 8, 6, 8);
                            for (Entity entity : nearbyEntites){
                                if (!(entity.equals(event.getPlayer()))) {
                                    if (entity instanceof Damageable) {
                                        if (entityMap.containsKey(entity)){
                                            if (entity instanceof Player){
                                                if (isKillable((Player) entity)){
                                                    entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * Items.getItemStats(event.getItem()).getDamage()/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) entity).damage(0.01, player);
                                                }
                                            } else {
                                                entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * Items.getItemStats(event.getItem()).getDamage()/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                ((Damageable) entity).damage(0.01, player);
                                                if (entityMap.get(entity).getHealth()<=0){
                                                    RareDropManager.rollForDrop(entity, player);
                                                    new OnEntityKilled(player, entity);
                                                }
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
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(50, player)){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(50, player));
                            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                            if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.TALL_GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.DEAD_BUSH)) {
                                player.teleport(loc);
                            }
                            else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);

                            for (int i = 0; i < 8; i++) {
                                if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.TALL_GRASS) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.DEAD_BUSH)) {
                                    player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                                }
                            }
                            afterTeleportation(player);
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(leapingSword.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(100, player)){
                            if (!CooldownAPI.isOnCooldown("LS", player)){
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(100, player));
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
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(100, player)){
                            if (!CooldownAPI.isOnCooldown("AOD", player)){
                                entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(100, player));
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
                                                if (entity instanceof Player){
                                                    if (isKillable((Player) entity)){
                                                        entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                        ((Damageable) entity).damage(0.01, player);
                                                    }
                                                } else {
                                                    entityMap.get(entity).dealDamage(entity, (entityMap.get(player).getAbilityPower()/1.3 * amount/2), false, entityMap.get(player).rollForCrit(player), entityMap.get(player).getCritDamage());
                                                    ((Damageable) entity).damage(0.01, player);
                                                    if (entityMap.get(entity).getHealth()<=0){
                                                        RareDropManager.rollForDrop(entity, player);
                                                        new OnEntityKilled(player, entity);
                                                    }
                                                }
                                                entity.setVelocity(player.getLocation().getDirection().multiply(3));
                                            }
                                        }
                                    }
                                }

                            } else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("AOD", player) + "s.");
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(tpCore.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() >= calcBaseManaWithBonuses(100, player)){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(100, player));
                            Location loc = player.getLocation();
                            Random rand = new Random();
                            loc.add(rand.nextInt(5)-2, rand.nextInt(5)-2, rand.nextInt(5)-2);
                            while (!(loc.getBlock().getType().equals(Material.AIR) || loc.getBlock().getType().equals(Material.WATER))){
                                loc.add(rand.nextInt(5)-2, rand.nextInt(5)-2, rand.nextInt(5)-2);
                            }
                            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                            player.teleport(loc);
                            afterTeleportation(player);
                        } else player.sendMessage(ChatColor.RED + "You dont have enough Mana!");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(berserkerAxe.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("BA", player)){
                            CooldownAPI.addCooldown("BA", player, 40);
                            String key = "baa";
                            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EVOKER_PREPARE_ATTACK, 1, 1);
                            if (entityMap.get(player).getBonusDamage().containsKey(key)){
                                entityMap.get(player).getBonusDamage().replace(key, 5.0);
                            } else {
                                entityMap.get(player).getBonusDamage().put(key, 5.0);
                            }
                            if (entityMap.get(player).getBonusSpeed().containsKey(key)){
                                entityMap.get(player).getBonusSpeed().replace(key, 20.0);
                            } else {
                                entityMap.get(player).getBonusSpeed().put(key, 20.0);
                            }
                            BukkitRunnable r1 = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (entityMap.get(player) != null){
                                        entityMap.get(player).getBonusDamage().replace(key, 0.0);
                                        entityMap.get(player).getBonusSpeed().replace(key, 0.0);
                                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BLAZE_BURN, 1F, 1.5F);
                                    }
                                }
                            };
                            r1.runTaskLater(plugin, 200);

                        } player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("BA", player) + "s.");
                    }

                    if (event.getItem().getItemMeta().getDisplayName().equals(emberRod.getItemMeta().getDisplayName())){
                        if (entityMap.get(player).getMana() > calcBaseManaWithBonuses(80, player)){
                            entityMap.get(player).setMana(entityMap.get(player).getMana() - calcBaseManaWithBonuses(80, player));

                            Projectile p = player.launchProjectile(Fireball.class, player.getLocation().getDirection().multiply(1.5));
                            p.setShooter(player);
                            p.setCustomName((entityMap.get(player).getAbilityPower()/1.3 * Items.getItemStats(player.getInventory().getItemInMainHand()).getDamage()/2)/2 + " ");
                            p.setCustomNameVisible(false);

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
                    if (entityMap.get(p).getBonusMana().containsKey(key)){
                        entityMap.get(p).getBonusMana().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getIntelligence());
                    }else {
                        entityMap.get(p).getBonusMana().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getIntelligence());
                    }
                    if (entityMap.get(p).getBonusSpeed().containsKey(key)){
                        entityMap.get(p).getBonusSpeed().replace(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getSpeed());
                    }else {
                        entityMap.get(p).getBonusSpeed().put(key, Items.getItemStats(p.getInventory().getItemInMainHand()).getSpeed());
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
            if (entityMap.get(p).getBonusMana().containsKey(key)){
                entityMap.get(p).getBonusMana().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusMana().put(key, 0.0);
            }
            if (entityMap.get(p).getBonusSpeed().containsKey(key)){
                entityMap.get(p).getBonusSpeed().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusSpeed().put(key, 0.0);
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
            if (entityMap.get(p).getBonusAbilityPower().containsKey(key)){
                entityMap.get(p).getBonusAbilityPower().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusAbilityPower().put(key, 0.0);
            }
        }
        for (Player p : Bukkit.getOnlinePlayers()){
            String key = "itemHeldOffHand";
            if (p.getInventory().getItemInOffHand().getItemMeta() != null){
                if (customItems.contains(p.getInventory().getItemInOffHand().getItemMeta().getDisplayName())){
                    if (entityMap.get(p).getBonusDefense().containsKey(key)){
                        entityMap.get(p).getBonusDefense().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getDefense());
                    }else {
                        entityMap.get(p).getBonusDefense().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getDefense());
                    }
                    if (entityMap.get(p).getBonusMana().containsKey(key)){
                        entityMap.get(p).getBonusMana().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getIntelligence());
                    }else {
                        entityMap.get(p).getBonusMana().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getIntelligence());
                    }
                    if (entityMap.get(p).getBonusSpeed().containsKey(key)){
                        entityMap.get(p).getBonusSpeed().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getSpeed());
                    }else {
                        entityMap.get(p).getBonusSpeed().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getSpeed());
                    }
                    if (entityMap.get(p).getBonusCritDamage().containsKey(key)){
                        entityMap.get(p).getBonusCritDamage().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getCritDamage());
                    }else {
                        entityMap.get(p).getBonusCritDamage().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getCritDamage());
                    }
                    if (entityMap.get(p).getBonusCritChance().containsKey(key)){
                        entityMap.get(p).getBonusCritChance().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getCritChance());
                    }else {
                        entityMap.get(p).getBonusCritChance().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getCritChance());
                    }
                    if (entityMap.get(p).getBonusMaxHealth().containsKey(key)){
                        entityMap.get(p).getBonusMaxHealth().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getHealth());
                    }else {
                        entityMap.get(p).getBonusMaxHealth().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getHealth());
                    }
                    if (entityMap.get(p).getBonusAbilityPower().containsKey(key)){
                        entityMap.get(p).getBonusAbilityPower().replace(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getAbilityPower());
                    }else {
                        entityMap.get(p).getBonusAbilityPower().put(key, Items.getItemStats(p.getInventory().getItemInOffHand()).getAbilityPower());
                    }
                    continue;
                }
            }
            if (entityMap.get(p).getBonusDefense().containsKey(key)){
                entityMap.get(p).getBonusDefense().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusDefense().put(key, 0.0);
            }
            if (entityMap.get(p).getBonusMana().containsKey(key)){
                entityMap.get(p).getBonusMana().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusMana().put(key, 0.0);
            }
            if (entityMap.get(p).getBonusSpeed().containsKey(key)){
                entityMap.get(p).getBonusSpeed().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusSpeed().put(key, 0.0);
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
            if (entityMap.get(p).getBonusAbilityPower().containsKey(key)){
                entityMap.get(p).getBonusAbilityPower().replace(key, 0.0);
            }else {
                entityMap.get(p).getBonusAbilityPower().put(key, 0.0);
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

            if (p.getInventory().getItemInMainHand().getType().equals(Material.LEATHER_HELMET)){
                p.getInventory().setItemInMainHand(leatherHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.LEATHER_CHESTPLATE)){
                p.getInventory().setItemInMainHand(leatherChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.LEATHER_LEGGINGS)){
                p.getInventory().setItemInMainHand(leatherLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.LEATHER_BOOTS)){
                p.getInventory().setItemInMainHand(leatherBoots);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.CHAINMAIL_HELMET)){
                p.getInventory().setItemInMainHand(chainmailHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.CHAINMAIL_CHESTPLATE)){
                p.getInventory().setItemInMainHand(chainmailChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.CHAINMAIL_LEGGINGS)){
                p.getInventory().setItemInMainHand(chainmailLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.CHAINMAIL_BOOTS)){
                p.getInventory().setItemInMainHand(chainmailBoots);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_HELMET)){
                p.getInventory().setItemInMainHand(ironHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_CHESTPLATE)){
                p.getInventory().setItemInMainHand(ironChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_LEGGINGS)){
                p.getInventory().setItemInMainHand(ironLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.IRON_BOOTS)){
                p.getInventory().setItemInMainHand(ironBoots);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_HELMET)){
                p.getInventory().setItemInMainHand(goldHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_CHESTPLATE)){
                p.getInventory().setItemInMainHand(goldChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_LEGGINGS)){
                p.getInventory().setItemInMainHand(goldLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.GOLDEN_BOOTS)){
                p.getInventory().setItemInMainHand(goldBoots);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_HELMET)){
                p.getInventory().setItemInMainHand(diamondHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_CHESTPLATE)){
                p.getInventory().setItemInMainHand(diamondChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_LEGGINGS)){
                p.getInventory().setItemInMainHand(diamondLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.DIAMOND_BOOTS)){
                p.getInventory().setItemInMainHand(diamondBoots);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_HELMET)){
                p.getInventory().setItemInMainHand(netheriteHelmet);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_CHESTPLATE)){
                p.getInventory().setItemInMainHand(netheriteChestplate);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_LEGGINGS)){
                p.getInventory().setItemInMainHand(netheriteLeggings);
            }
            else if (p.getInventory().getItemInMainHand().getType().equals(Material.NETHERITE_BOOTS)){
                p.getInventory().setItemInMainHand(netheriteBoots);
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
