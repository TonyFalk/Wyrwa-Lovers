package net.pullolo.wyrwalovers.entities.events;

import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.handlers.ArmourHandler.calcBaseManaWithBonuses;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntityDamaged(EntityDamageEvent e){
        if (!e.isCancelled()){
            if (e.getDamage() < 0.1){
                return;
            }
            if (e.getEntity() instanceof Player){
                if (((Player) e.getEntity()).getGameMode().equals(GameMode.CREATIVE)){
                    return;
                }
                if (((Player) e.getEntity()).isBlocking() && new Random().nextInt(20) > 0){
                    if (e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)
                            || e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)
                            || e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
                            || e.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
                            || e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK)){
                        return;
                    }
                }
                if (((Player) e.getEntity()).getInventory().getHelmet() != null && ((Player) e.getEntity()).getInventory().getChestplate() != null && ((Player) e.getEntity()).getInventory().getLeggings() != null && ((Player) e.getEntity()).getInventory().getBoots() != null){
                    if (((Player) e.getEntity()).getInventory().getHelmet().getItemMeta() != null && ((Player) e.getEntity()).getInventory().getChestplate().getItemMeta() != null
                            && ((Player) e.getEntity()).getInventory().getLeggings().getItemMeta() != null && ((Player) e.getEntity()).getInventory().getBoots().getItemMeta() != null){
                        if (customArmorItems.contains(((Player) e.getEntity()).getInventory().getHelmet().getItemMeta().getDisplayName()) && customArmorItems.contains(((Player) e.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName())
                                && customArmorItems.contains(((Player) e.getEntity()).getInventory().getLeggings().getItemMeta().getDisplayName()) && customArmorItems.contains(((Player) e.getEntity()).getInventory().getBoots().getItemMeta().getDisplayName())){
                            if (((Player) e.getEntity()).getInventory().getHelmet().getItemMeta().getDisplayName().equals(angelHelmet.getItemMeta().getDisplayName())
                                    && ((Player) e.getEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(angelChestplate.getItemMeta().getDisplayName())
                                    && ((Player) e.getEntity()).getInventory().getLeggings().getItemMeta().getDisplayName().equals(angelLeggings.getItemMeta().getDisplayName())
                                    && ((Player) e.getEntity()).getInventory().getBoots().getItemMeta().getDisplayName().equals(angelBoots.getItemMeta().getDisplayName())){
                                if (!CooldownAPI.isOnCooldown("AA", (Player) e.getEntity())){
                                    CooldownAPI.addCooldown("AA", (Player) e.getEntity(), 40);
                                    ((Player) e.getEntity()).playSound(e.getEntity(), Sound.ITEM_SHIELD_BLOCK, 1, 1);
                                    e.getEntity().getWorld().spawnParticle(Particle.FLASH, e.getEntity().getLocation(), 4, 0.1, 1, 0.1);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            if (e instanceof EntityDamageByEntityEvent){
                if (entities.contains(e.getEntity())){
                    if (((EntityDamageByEntityEvent) e).getDamager() instanceof Player){
                        if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta() != null){
                            if(Items.customItems.contains(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                                //Todo Run checks for custom items and add return statements
                                int skip = 0;
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(brutalityBlade.getItemMeta().getDisplayName())){
                                    if (entityMap.get(e.getEntity()).getHealth() <= entityMap.get(e.getEntity()).getMaxHealth()/2){
                                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage()/1.3 * Items.getItemStats(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand()).getDamage()/2)*2, true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                                        skip = 1;
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(moltenBlade.getItemMeta().getDisplayName())){
                                    e.getEntity().setFireTicks(60);
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(witchStaff.getItemMeta().getDisplayName())){
                                    if (e.getEntity() instanceof LivingEntity){
                                        if (new Random().nextInt(4)==0){
                                            int r = new Random().nextInt(4);
                                            if (r==0){
                                                ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 80, 1));
                                            } else if (r==1){
                                                ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 1));
                                            } else if (r==2){
                                                ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 80, 1));
                                            } else {
                                                ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 1));
                                            }
                                        }
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(silverSword.getItemMeta().getDisplayName())){
                                    if (entityMap.get(e.getEntity()).isUndead()){
                                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage()/1.3 * Items.getItemStats(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand()).getDamage()/2)*1.5, true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                                        skip = 1;
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(undeadSword.getItemMeta().getDisplayName())){
                                    if (entityMap.get(e.getEntity()).isUndead()){
                                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage()/1.3 * Items.getItemStats(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand()).getDamage()/2)*1.9, true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                                        skip = 1;
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(cleaver.getItemMeta().getDisplayName())){
                                    if (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getMana() >= calcBaseManaWithBonuses(35, (Player) ((EntityDamageByEntityEvent) e).getDamager())){
                                        int counter = 0;
                                        for (Entity en : ((EntityDamageByEntityEvent) e).getDamager().getWorld().getNearbyEntities(((EntityDamageByEntityEvent) e).getDamager().getLocation().add(((EntityDamageByEntityEvent) e).getDamager().getLocation().getDirection().multiply(2)), 4, 2, 4)){
                                            if (entityMap.containsKey(en) && !(en.equals(((EntityDamageByEntityEvent) e).getDamager())) && !(en.equals(e.getEntity()))){
                                                entityMap.get(en).dealDamage(en, (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage()/1.3 * Items.getItemStats(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand()).getDamage()/2)*0.7, false, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                                                if (e instanceof LivingEntity){
                                                    ((LivingEntity) e).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 30, 2));
                                                }
                                                en.setVelocity(en.getLocation().getDirection().multiply(-0.5));
                                                counter++;
                                                if (!(e.getEntity() instanceof Player)){
                                                    if (entityMap.get(e.getEntity()).getHealth()<=0){
                                                        RareDropManager.rollForDrop(e.getEntity(), (Player) ((EntityDamageByEntityEvent) e).getDamager());
                                                        new OnEntityKilled((Player) ((EntityDamageByEntityEvent) e).getDamager(), e.getEntity());
                                                    }
                                                }
                                            }
                                        }
                                        if (counter != 0){
                                            entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).setMana(entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getMana() - calcBaseManaWithBonuses(35, (Player) ((EntityDamageByEntityEvent) e).getDamager()));
                                        }
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(slimeSword.getItemMeta().getDisplayName())){
                                    if (!CooldownAPI.isOnCooldown("SS", (Player) ((EntityDamageByEntityEvent) e).getDamager())){
                                        if (e.getEntity() instanceof LivingEntity){
                                            ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 2));
                                            CooldownAPI.addCooldown("SS", (Player) ((EntityDamageByEntityEvent) e).getDamager(), 5);
                                        }
                                    }
                                }
                                if (((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(flingingSword.getItemMeta().getDisplayName())){
                                    if (e.getEntity() instanceof LivingEntity){
                                        if (!CooldownAPI.isOnCooldown("FS", (Player) ((EntityDamageByEntityEvent) e).getDamager())){
                                            CooldownAPI.addCooldown("FS", (Player) ((EntityDamageByEntityEvent) e).getDamager(), 5);
                                            BukkitRunnable r1 = new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    if (e.getEntity() != null){
                                                        e.getEntity().setVelocity(new Vector(0, 1.5, 0));
                                                    }
                                                }
                                            };
                                            r1.runTaskLater(plugin, 1);
                                        }
                                    }
                                }

                                if (skip == 0){
                                    entityMap.get(e.getEntity()).dealDamage(e.getEntity(), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage()/1.3 * Items.getItemStats(((Player) ((EntityDamageByEntityEvent) e).getDamager()).getInventory().getItemInMainHand()).getDamage()/2, true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                                }
                                //Well that's important, todo don't forget to add to abilities!
                                if (!(e.getEntity() instanceof Player)){
                                    if (entityMap.get(e.getEntity()).getHealth()<=0){
                                        RareDropManager.rollForDrop(e.getEntity(), (Player) ((EntityDamageByEntityEvent) e).getDamager());
                                        new OnEntityKilled((Player) ((EntityDamageByEntityEvent) e).getDamager(), e.getEntity());
                                    }
                                }
                                return;
                            }
                        }
                    }
                    if (entities.contains(((EntityDamageByEntityEvent) e).getDamager())){
                        if (!(((EntityDamageByEntityEvent) e).getDamager() instanceof Player)){
                            entityMap.get(e.getEntity()).dealDamage(e.getEntity(), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage(), true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                        }
                        else {
                            entityMap.get(e.getEntity()).dealDamage(e.getEntity(), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getDamage() + e.getDamage(), true, entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).rollForCrit(((EntityDamageByEntityEvent) e).getDamager()), entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getCritDamage());
                            if (!(e.getEntity() instanceof Player)){
                                if (entityMap.get(e.getEntity()).getHealth()<=0){
                                    RareDropManager.rollForDrop(e.getEntity(), (Player) ((EntityDamageByEntityEvent) e).getDamager());
                                    new OnEntityKilled((Player) ((EntityDamageByEntityEvent) e).getDamager(), e.getEntity());
                                }
                            }
                        }
                    }
                    else {
                        if(((EntityDamageByEntityEvent) e).getDamager() instanceof EvokerFangs){
                            entityMap.get(e.getEntity()).dealDamage(e.getEntity(), entityMap.get(((EvokerFangs) ((EntityDamageByEntityEvent) e).getDamager()).getOwner()).getDamage(), false, entityMap.get(((EvokerFangs) ((EntityDamageByEntityEvent) e).getDamager()).getOwner()).rollForCrit(((EvokerFangs) ((EntityDamageByEntityEvent) e).getDamager()).getOwner()), entityMap.get(((EvokerFangs) ((EntityDamageByEntityEvent) e).getDamager()).getOwner()).getCritDamage());
                            return;
                        }
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
                            return;
                        }
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)){
                            if (((EntityDamageByEntityEvent) e).getDamager() instanceof Fireball){
                                try {
                                    entityMap.get(e.getEntity()).dealDamage(e.getEntity(), Double.parseDouble(((EntityDamageByEntityEvent) e).getDamager().getCustomName()), false, false, 0);
                                } catch (Exception er){
                                    entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage()*EntityStats.DAMAGE_MULTIPLIER, false, false, 0);
                                }
                            }
                            return;
                        }
                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage(), true, false, 0);
                    }
                }
            } else{
                if (entities.contains(e.getEntity())){
                    if (e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
                        return;
                    }
                    if (e.getEntity() instanceof Player){
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.POISON) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) || e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)){
                            if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK) || e.getCause().equals(EntityDamageEvent.DamageCause.LAVA)){
                                entityMap.get(e.getEntity()).dealTrueDamage(e.getEntity(), entityMap.get(e.getEntity()).getMaxHealth()/20);
                            } else {
                                entityMap.get(e.getEntity()).dealTrueDamage(e.getEntity(), e.getDamage()*EntityStats.DAMAGE_MULTIPLIER);
                            }
                        } else {
                            entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage()* EntityStats.DAMAGE_MULTIPLIER, true, false, 0);
                        }
                    } else {
                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage()*EntityStats.DAMAGE_MULTIPLIER, true, false, 0);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event){
//        Bukkit.getServer().getConsoleSender().sendMessage(event.getHitEntity() + " " + event.getEntity().getShooter());
        if (event.getHitEntity() instanceof Player){
            if (((Player) event.getHitEntity()).getGameMode().equals(GameMode.CREATIVE)){
                return;
            }
            if (((Player) event.getHitEntity()).isBlocking()){
                return;
            }
            if (((Player) event.getHitEntity()).getInventory().getHelmet() != null && ((Player) event.getHitEntity()).getInventory().getChestplate() != null && ((Player) event.getHitEntity()).getInventory().getLeggings() != null && ((Player) event.getHitEntity()).getInventory().getBoots() != null){
                if (((Player) event.getHitEntity()).getInventory().getHelmet().getItemMeta() != null && ((Player) event.getHitEntity()).getInventory().getChestplate().getItemMeta() != null
                        && ((Player) event.getHitEntity()).getInventory().getLeggings().getItemMeta() != null && ((Player) event.getHitEntity()).getInventory().getBoots().getItemMeta() != null){
                    if (customArmorItems.contains(((Player) event.getHitEntity()).getInventory().getHelmet().getItemMeta().getDisplayName()) && customArmorItems.contains(((Player) event.getHitEntity()).getInventory().getChestplate().getItemMeta().getDisplayName())
                            && customArmorItems.contains(((Player) event.getHitEntity()).getInventory().getLeggings().getItemMeta().getDisplayName()) && customArmorItems.contains(((Player) event.getHitEntity()).getInventory().getBoots().getItemMeta().getDisplayName())){
                        if (((Player) event.getHitEntity()).getInventory().getHelmet().getItemMeta().getDisplayName().equals(angelHelmet.getItemMeta().getDisplayName())
                                && ((Player) event.getHitEntity()).getInventory().getChestplate().getItemMeta().getDisplayName().equals(angelChestplate.getItemMeta().getDisplayName())
                                && ((Player) event.getHitEntity()).getInventory().getLeggings().getItemMeta().getDisplayName().equals(angelLeggings.getItemMeta().getDisplayName())
                                && ((Player) event.getHitEntity()).getInventory().getBoots().getItemMeta().getDisplayName().equals(angelBoots.getItemMeta().getDisplayName())){
                            if (!CooldownAPI.isOnCooldown("AA", (Player) event.getHitEntity())){
                                CooldownAPI.addCooldown("AA", (Player) event.getHitEntity(), 40);
                                ((Player) event.getHitEntity()).playSound(event.getHitEntity(), Sound.ITEM_SHIELD_BLOCK, 1, 1);
                                event.getHitEntity().getWorld().spawnParticle(Particle.FLASH, event.getHitEntity().getLocation(), 4, 0.1, 1, 0.1);
                                return;
                            }
                        }
                    }
                }
            }
        }
        if (event.getHitEntity() instanceof Enderman){
            if (event.getEntity().getType().equals(EntityType.ARROW) || event.getEntity().getType().equals(EntityType.SPECTRAL_ARROW)){
                return;
            }
        }

        Entity e = (Entity) event.getEntity().getShooter();
        Entity hitEntity = event.getHitEntity();
        if (event.getHitEntity() instanceof EnderDragonPart){
            hitEntity = ((EnderDragonPart) event.getHitEntity()).getParent();
        }
        if (entities.contains(hitEntity)){
            if (entities.contains(e)){
                if (e instanceof Player){
                    if (((Player) e).getInventory().getItemInMainHand().getItemMeta() == null){
                        entityMap.get(hitEntity).dealDamage(hitEntity, entityMap.get(e).getDamage(), true, true, entityMap.get(e).getCritDamage());
                        if (!(hitEntity instanceof Player)){
                            if (entityMap.get(hitEntity).getHealth()<=0){
                                RareDropManager.rollForDrop(hitEntity, (Player) e);
                                new OnEntityKilled((Player) e, hitEntity);
                            }
                        }
                        return;
                    }

                    if (customItems.contains(((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                        boolean skip = false;
                        if (event.getEntity() instanceof Fireball){
                            if (((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(emberRod.getItemMeta().getDisplayName())){
                                skip = true;
                                entityMap.get(hitEntity).dealDamage(hitEntity, entityMap.get(e).getAbilityPower()/1.3 * Items.getItemStats(((Player) e).getInventory().getItemInMainHand()).getDamage()/2, false, entityMap.get(e).rollForCrit(e), entityMap.get(e).getCritDamage());
                            }
                        }
                        if (((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(flamingBow.getItemMeta().getDisplayName())){
                            if (hitEntity instanceof LivingEntity){
                                hitEntity.setFireTicks(60);
                            }
                        }
                        if (((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(pullingBow.getItemMeta().getDisplayName())){
                            BukkitRunnable r1 = new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if (event.getHitEntity() != null){
                                        event.getHitEntity().setVelocity(e.getLocation().getDirection().multiply(-1));
                                    }
                                }
                            };
                            r1.runTaskLater(plugin, 1);
                        }
                        if (!skip){
                            entityMap.get(hitEntity).dealDamage(hitEntity, entityMap.get(e).getDamage()/1.3 * Items.getItemStats(((Player) e).getInventory().getItemInMainHand()).getDamage()/2, true, true, entityMap.get(e).getCritDamage());
                        }
                        if (!(hitEntity instanceof Player)){
                            if (entityMap.get(hitEntity).getHealth()<=0){
                                RareDropManager.rollForDrop(hitEntity, (Player) e);
                                new OnEntityKilled((Player) e, hitEntity);
                            }
                        }
                        return;
                    }
                }
                entityMap.get(hitEntity).dealDamage(hitEntity, entityMap.get(e).getDamage(), true, true, entityMap.get(e).getCritDamage());
            } else {
                entityMap.get(hitEntity).dealDamage(hitEntity, 25.0, true, true, 0);
            }
        }
    }
}
