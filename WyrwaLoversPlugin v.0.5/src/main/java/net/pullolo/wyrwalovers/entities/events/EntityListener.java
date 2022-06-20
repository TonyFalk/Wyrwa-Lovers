package net.pullolo.wyrwalovers.entities.events;

import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class EntityListener implements Listener {
    @EventHandler
    public void onEntityDamaged(EntityDamageEvent e){
        if (!e.isCancelled()){
            if (e.getEntity() instanceof Player){
                if (((Player) e.getEntity()).getGameMode().equals(GameMode.CREATIVE)){
                    return;
                }
                if (((Player) e.getEntity()).isBlocking()){
                    return;
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
                        if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                            entityMap.get(e.getEntity()).dealTrueDamage(e.getEntity(), e.getDamage()*EntityStats.DAMAGE_MULTIPLIER);
                        } else {
                            entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage()* EntityStats.DAMAGE_MULTIPLIER, true, false, 0);
                        }
                    } else {
                        entityMap.get(e.getEntity()).dealDamage(e.getEntity(), e.getDamage(), true, false, 0);
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
        }
        Entity e = (Entity) event.getEntity().getShooter();
        if (entities.contains(event.getHitEntity())){
            if (entities.contains(e)){
                if (e instanceof Player){
                    if (customItems.contains(((Player) e).getInventory().getItemInMainHand().getItemMeta().getDisplayName())){
                        entityMap.get(event.getHitEntity()).dealDamage(event.getHitEntity(), entityMap.get(e).getDamage()/1.3 * Items.getItemStats(((Player) e).getInventory().getItemInMainHand()).getDamage()/2, true, true, entityMap.get(e).getCritDamage());
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
