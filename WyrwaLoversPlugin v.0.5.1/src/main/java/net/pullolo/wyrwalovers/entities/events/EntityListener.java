package net.pullolo.wyrwalovers.entities.events;

import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
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
                if (((Player) e.getEntity()).isBlocking()){
                    return;
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
                                    if (entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getMana() >= 35){
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
                                            entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).setMana(entityMap.get(((EntityDamageByEntityEvent) e).getDamager()).getMana() - 35);
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
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE)){
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
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE) || e.getCause().equals(EntityDamageEvent.DamageCause.POISON) || e.getCause().equals(EntityDamageEvent.DamageCause.FIRE_TICK)){
                            entityMap.get(e.getEntity()).dealTrueDamage(e.getEntity(), e.getDamage()*EntityStats.DAMAGE_MULTIPLIER);
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
        Entity e = (Entity) event.getEntity().getShooter();
        if (entities.contains(event.getHitEntity())){
            if (entities.contains(e)){
                if (e instanceof Player){
                    if (customItems.contains(((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                        boolean skip = false;
                        if (((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(flamingBow.getItemMeta().getDisplayName())){
                            if (event.getHitEntity() instanceof LivingEntity){
                                event.getHitEntity().setFireTicks(60);
                            }
                        }

                        if (!skip){
                            entityMap.get(event.getHitEntity()).dealDamage(event.getHitEntity(), entityMap.get(e).getDamage()/1.3 * Items.getItemStats(((Player) e).getInventory().getItemInMainHand()).getDamage()/2, true, true, entityMap.get(e).getCritDamage());
                        }
                        if (!(event.getHitEntity() instanceof Player)){
                            if (entityMap.get(event.getHitEntity()).getHealth()<=0){
                                RareDropManager.rollForDrop(event.getHitEntity(), (Player) e);
                                new OnEntityKilled((Player) e, event.getHitEntity());
                            }
                        }
                        return;
                    }
                }
                entityMap.get(event.getHitEntity()).dealDamage(event.getHitEntity(), entityMap.get(e).getDamage(), true, true, entityMap.get(e).getCritDamage());
            } else {
                entityMap.get(event.getHitEntity()).dealDamage(event.getHitEntity(), 25.0, true, true, 0);
            }
        }
    }
}
