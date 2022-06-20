package net.pullolo.wyrwalovers.handlers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.customItems;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class ArmourHandler extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e : entities){
            if (e instanceof LivingEntity){
                double bonusDefense = 0;
                if (((LivingEntity) e).getEquipment().getHelmet() != null || ((LivingEntity) e).getEquipment().getChestplate() != null || ((LivingEntity) e).getEquipment().getLeggings() != null || ((LivingEntity) e).getEquipment().getBoots() != null){
                    ItemStack helm = ((LivingEntity) e).getEquipment().getHelmet();
                    ItemStack chest = ((LivingEntity) e).getEquipment().getChestplate();
                    ItemStack legs = ((LivingEntity) e).getEquipment().getLeggings();
                    ItemStack boots = ((LivingEntity) e).getEquipment().getBoots();

                    if (helm != null){
                        if (helm.getItemMeta() != null){
                            if (customItems.contains(helm.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                            }
                            else {
                                if (helm.getType().toString().toLowerCase().contains("netherite")){
                                    bonusDefense += 3;
                                }
                                else if (helm.getType().toString().toLowerCase().contains("diamond")){
                                    bonusDefense += 3;
                                }
                                else if (helm.getType().toString().toLowerCase().contains("iron")){
                                    bonusDefense += 2;
                                }
                                else if (helm.getType().toString().toLowerCase().contains("golden")){
                                    bonusDefense += 2;
                                }
                                else if (helm.getType().toString().toLowerCase().contains("leather")){
                                    bonusDefense += 1;
                                }
                                else if (helm.getType().toString().toLowerCase().contains("chainmail")){
                                    bonusDefense += 2;
                                }
                            }
                        }
                    }
                    if (chest != null){
                        if (chest.getItemMeta() != null){
                            if (customItems.contains(chest.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                            }
                            else {
                                if (chest.getType().toString().toLowerCase().contains("netherite")){
                                    bonusDefense += 8;
                                }
                                else if (chest.getType().toString().toLowerCase().contains("diamond")){
                                    bonusDefense += 8;
                                }
                                else if (chest.getType().toString().toLowerCase().contains("iron")){
                                    bonusDefense += 6;
                                }
                                else if (chest.getType().toString().toLowerCase().contains("golden")){
                                    bonusDefense += 5;
                                }
                                else if (chest.getType().toString().toLowerCase().contains("leather")){
                                    bonusDefense += 3;
                                }
                                else if (chest.getType().toString().toLowerCase().contains("chainmail")){
                                    bonusDefense += 5;
                                }
                            }
                        }
                    }
                    if (legs != null){
                        if (legs.getItemMeta() != null){
                            if (customItems.contains(legs.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                            }
                            else {
                                if (legs.getType().toString().toLowerCase().contains("netherite")){
                                    bonusDefense += 6;
                                }
                                else if (legs.getType().toString().toLowerCase().contains("diamond")){
                                    bonusDefense += 6;
                                }
                                else if (legs.getType().toString().toLowerCase().contains("iron")){
                                    bonusDefense += 5;
                                }
                                else if (legs.getType().toString().toLowerCase().contains("golden")){
                                    bonusDefense += 3;
                                }
                                else if (legs.getType().toString().toLowerCase().contains("leather")){
                                    bonusDefense += 2;
                                }
                                else if (legs.getType().toString().toLowerCase().contains("chainmail")){
                                    bonusDefense += 4;
                                }
                            }
                        }
                    }
                    if (boots != null){
                        if (boots.getItemMeta() != null){
                            if (customItems.contains(boots.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                            }
                            else {
                                if (boots.getType().toString().toLowerCase().contains("netherite")){
                                    bonusDefense += 3;
                                }
                                else if (boots.getType().toString().toLowerCase().contains("diamond")){
                                    bonusDefense += 3;
                                }
                                else if (boots.getType().toString().toLowerCase().contains("iron")){
                                    bonusDefense += 2;
                                }
                                else if (boots.getType().toString().toLowerCase().contains("golden")){
                                    bonusDefense += 1;
                                }
                                else if (boots.getType().toString().toLowerCase().contains("leather")){
                                    bonusDefense += 1;
                                }
                                else if (boots.getType().toString().toLowerCase().contains("chainmail")){
                                    bonusDefense += 1;
                                }
                            }
                        }
                    }
                }
                if (entityMap.get(e).getBonusDefense().containsKey("armor")){
                    entityMap.get(e).getBonusDefense().replace("armor", bonusDefense);
                } else {
                    entityMap.get(e).getBonusDefense().put("armor", bonusDefense);
                }
            }
        }
    }
}
