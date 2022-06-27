package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.items.Items;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.customArmorItems;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class ArmourHandler extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e : entities){
            if (e instanceof LivingEntity){
                String key = "armor";
                double bonusDefense = 0;
                double bonusDamage = 0;
                double bonusCritDamage = 0;
                double bonusCritChance = 0;

                if (((LivingEntity) e).getEquipment().getHelmet() != null || ((LivingEntity) e).getEquipment().getChestplate() != null || ((LivingEntity) e).getEquipment().getLeggings() != null || ((LivingEntity) e).getEquipment().getBoots() != null){
                    ItemStack helm = ((LivingEntity) e).getEquipment().getHelmet();
                    ItemStack chest = ((LivingEntity) e).getEquipment().getChestplate();
                    ItemStack legs = ((LivingEntity) e).getEquipment().getLeggings();
                    ItemStack boots = ((LivingEntity) e).getEquipment().getBoots();

                    if (helm != null){
                        if (helm.getItemMeta() != null){
                            if (customArmorItems.contains(helm.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                                bonusDefense += Items.getItemStats(helm).getDefense();
                                bonusDamage += Items.getItemStats(helm).getDamage();
                                bonusCritDamage += Items.getItemStats(helm).getCritDamage();
                                bonusCritChance += Items.getItemStats(helm).getCritChance();
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
                            if (customArmorItems.contains(chest.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                                bonusDefense += Items.getItemStats(chest).getDefense();
                                bonusDamage += Items.getItemStats(chest).getDamage();
                                bonusCritDamage += Items.getItemStats(chest).getCritDamage();
                                bonusCritChance += Items.getItemStats(chest).getCritChance();
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
                            if (customArmorItems.contains(legs.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                                bonusDefense += Items.getItemStats(legs).getDefense();
                                bonusDamage += Items.getItemStats(legs).getDamage();
                                bonusCritDamage += Items.getItemStats(legs).getCritDamage();
                                bonusCritChance += Items.getItemStats(legs).getCritChance();
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
                            if (customArmorItems.contains(boots.getItemMeta().getDisplayName())){
                                //Todo add custom items values
                                bonusDefense += Items.getItemStats(boots).getDefense();
                                bonusDamage += Items.getItemStats(boots).getDamage();
                                bonusCritDamage += Items.getItemStats(boots).getCritDamage();
                                bonusCritChance += Items.getItemStats(boots).getCritChance();
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

                if (entityMap.get(e).getBonusDefense().containsKey(key)){
                    entityMap.get(e).getBonusDefense().replace(key, bonusDefense);
                } else {
                    entityMap.get(e).getBonusDefense().put(key, bonusDefense);
                }
                if (entityMap.get(e).getBonusDamage().containsKey(key)){
                    entityMap.get(e).getBonusDamage().replace(key, bonusDamage);
                } else {
                    entityMap.get(e).getBonusDamage().put(key, bonusDamage);
                }
                if (entityMap.get(e).getBonusCritDamage().containsKey(key)){
                    entityMap.get(e).getBonusCritDamage().replace(key, bonusCritDamage);
                } else {
                    entityMap.get(e).getBonusCritDamage().put(key, bonusCritDamage);
                }
                if (entityMap.get(e).getBonusCritChance().containsKey(key)){
                    entityMap.get(e).getBonusCritChance().replace(key, bonusCritChance);
                } else {
                    entityMap.get(e).getBonusCritChance().put(key, bonusCritChance);
                }
            }
        }
    }
}
