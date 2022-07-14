package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import net.pullolo.wyrwalovers.misc.TimeHandler;
import net.pullolo.wyrwalovers.stats.entities.EntityAttributes;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.*;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class ArmourHandler extends BukkitRunnable implements Listener {

    public static HashMap<Player, EntityAttributes> playerAttributes = new HashMap<>();

    @Override
    public void run() {
        for (Entity e : entities){
            if (e instanceof LivingEntity){
                String key = "armor";
                double bonusDefense = 0;
                double bonusDamage = 0;
                double bonusCritDamage = 0;
                double bonusCritChance = 0;
                double bonusResistance = 0;
                double bonusIntelligence = 0;
                double bonusSpeed = 0;
                double bonusHealth = 0;

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
                                bonusResistance += Items.getItemStats(helm).getResistance();
                                bonusIntelligence += Items.getItemStats(helm).getIntelligence();
                                bonusSpeed += Items.getItemStats(helm).getSpeed();
                                bonusHealth += Items.getItemStats(helm).getHealth();
                            }
                            else {
                                if (helm.getType().toString().toLowerCase().contains("netherite")){
                                    ((LivingEntity) e).getEquipment().setHelmet(netheriteHelmet);
                                }
                                else if (helm.getType().toString().toLowerCase().contains("diamond")){
                                    ((LivingEntity) e).getEquipment().setHelmet(diamondHelmet);
                                }
                                else if (helm.getType().toString().toLowerCase().contains("iron")){
                                    ((LivingEntity) e).getEquipment().setHelmet(ironHelmet);
                                }
                                else if (helm.getType().toString().toLowerCase().contains("golden")){
                                    ((LivingEntity) e).getEquipment().setHelmet(goldHelmet);
                                }
                                else if (helm.getType().toString().toLowerCase().contains("leather")){
                                    ((LivingEntity) e).getEquipment().setHelmet(leatherHelmet);
                                }
                                else if (helm.getType().toString().toLowerCase().contains("chainmail")){
                                    ((LivingEntity) e).getEquipment().setHelmet(chainmailHelmet);
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
                                bonusResistance += Items.getItemStats(chest).getResistance();
                                bonusIntelligence += Items.getItemStats(chest).getIntelligence();
                                bonusSpeed += Items.getItemStats(chest).getSpeed();
                                bonusHealth += Items.getItemStats(chest).getHealth();

                                if (chest.getItemMeta().getDisplayName().equals(shadowAssassinChestplate.getItemMeta().getDisplayName())){
                                    int amount = 30;
                                    bonusDefense += amount;
                                    if (legs != null && legs.getItemMeta() != null && legs.getItemMeta().getDisplayName().equals(shadowAssassinLeggings.getItemMeta().getDisplayName())){
                                        bonusDefense += amount;
                                    }
                                    if (boots != null && boots.getItemMeta() != null && boots.getItemMeta().getDisplayName().equals(shadowAssassinBoots.getItemMeta().getDisplayName())){
                                        bonusDefense += amount;
                                    }
                                    if (helm != null && helm.getItemMeta() != null && helm.getItemMeta().getDisplayName().equals(shadowAssassinHelmet.getItemMeta().getDisplayName())){
                                        bonusDefense += amount;
                                    }
                                }
                                if (chest.getItemMeta().getDisplayName().equals(lunarChestplateNight.getItemMeta().getDisplayName())){
                                    if (!TimeHandler.isDay(e.getWorld())){
                                        bonusCritDamage += 70;
                                    }
                                }
                                if (chest.getItemMeta().getDisplayName().equals(lunarChestplateDay.getItemMeta().getDisplayName())){
                                    if (TimeHandler.isDay(e.getWorld())){
                                        bonusDefense += 90;
                                    }
                                }
                            }
                            else {
                                if (chest.getType().toString().toLowerCase().contains("netherite")){
                                    ((LivingEntity) e).getEquipment().setChestplate(netheriteChestplate);
                                }
                                else if (chest.getType().toString().toLowerCase().contains("diamond")){
                                    ((LivingEntity) e).getEquipment().setChestplate(diamondChestplate);
                                }
                                else if (chest.getType().toString().toLowerCase().contains("iron")){
                                    ((LivingEntity) e).getEquipment().setChestplate(ironChestplate);
                                }
                                else if (chest.getType().toString().toLowerCase().contains("golden")){
                                    ((LivingEntity) e).getEquipment().setChestplate(goldChestplate);
                                }
                                else if (chest.getType().toString().toLowerCase().contains("leather")){
                                    ((LivingEntity) e).getEquipment().setChestplate(leatherChestplate);
                                }
                                else if (chest.getType().toString().toLowerCase().contains("chainmail")){
                                    ((LivingEntity) e).getEquipment().setChestplate(chainmailChestplate);
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
                                bonusResistance += Items.getItemStats(legs).getResistance();
                                bonusIntelligence += Items.getItemStats(legs).getIntelligence();
                                bonusSpeed += Items.getItemStats(legs).getSpeed();
                                bonusHealth += Items.getItemStats(legs).getHealth();

                                if (legs.getItemMeta().getDisplayName().equals(lunarLeggingsNight.getItemMeta().getDisplayName())){
                                    if (!TimeHandler.isDay(e.getWorld())){
                                        bonusSpeed += 50;
                                    }
                                }
                                if (legs.getItemMeta().getDisplayName().equals(lunarleggingsDay.getItemMeta().getDisplayName())){
                                    if (TimeHandler.isDay(e.getWorld())){
                                        bonusIntelligence += 120;
                                    }
                                }
                            }
                            else {
                                if (legs.getType().toString().toLowerCase().contains("netherite")){
                                    ((LivingEntity) e).getEquipment().setLeggings(netheriteLeggings);
                                }
                                else if (legs.getType().toString().toLowerCase().contains("diamond")){
                                    ((LivingEntity) e).getEquipment().setLeggings(diamondLeggings);
                                }
                                else if (legs.getType().toString().toLowerCase().contains("iron")){
                                    ((LivingEntity) e).getEquipment().setLeggings(ironLeggings);
                                }
                                else if (legs.getType().toString().toLowerCase().contains("golden")){
                                    ((LivingEntity) e).getEquipment().setLeggings(goldLeggings);
                                }
                                else if (legs.getType().toString().toLowerCase().contains("leather")){
                                    ((LivingEntity) e).getEquipment().setLeggings(leatherLeggings);
                                }
                                else if (legs.getType().toString().toLowerCase().contains("chainmail")){
                                    ((LivingEntity) e).getEquipment().setLeggings(chainmailLeggings);
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
                                bonusResistance += Items.getItemStats(boots).getResistance();
                                bonusIntelligence += Items.getItemStats(boots).getIntelligence();
                                bonusSpeed += Items.getItemStats(boots).getSpeed();
                                bonusHealth += Items.getItemStats(boots).getHealth();
                            }
                            else {
                                if (boots.getType().toString().toLowerCase().contains("netherite")){
                                    ((LivingEntity) e).getEquipment().setBoots(netheriteBoots);
                                }
                                else if (boots.getType().toString().toLowerCase().contains("diamond")){
                                    ((LivingEntity) e).getEquipment().setBoots(diamondBoots);
                                }
                                else if (boots.getType().toString().toLowerCase().contains("iron")){
                                    ((LivingEntity) e).getEquipment().setBoots(ironBoots);
                                }
                                else if (boots.getType().toString().toLowerCase().contains("golden")){
                                    ((LivingEntity) e).getEquipment().setBoots(goldBoots);
                                }
                                else if (boots.getType().toString().toLowerCase().contains("leather")){
                                    ((LivingEntity) e).getEquipment().setBoots(leatherBoots);
                                }
                                else if (boots.getType().toString().toLowerCase().contains("chainmail")){
                                    ((LivingEntity) e).getEquipment().setBoots(chainmailBoots);
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
                if (entityMap.get(e).getBonusResistance().containsKey(key)){
                    entityMap.get(e).getBonusResistance().replace(key, bonusResistance);
                } else {
                    entityMap.get(e).getBonusResistance().put(key, bonusResistance);
                }
                if (entityMap.get(e).getBonusMana().containsKey(key)){
                    entityMap.get(e).getBonusMana().replace(key, bonusIntelligence);
                } else {
                    entityMap.get(e).getBonusMana().put(key, bonusIntelligence);
                }
                if (entityMap.get(e).getBonusSpeed().containsKey(key)){
                    entityMap.get(e).getBonusSpeed().replace(key, bonusSpeed);
                } else {
                    entityMap.get(e).getBonusSpeed().put(key, bonusSpeed);
                }
                if (entityMap.get(e).getBonusMaxHealth().containsKey(key)){
                    entityMap.get(e).getBonusMaxHealth().replace(key, bonusHealth);
                } else {
                    entityMap.get(e).getBonusMaxHealth().put(key, bonusHealth);
                }
            }
        }
    }

    //Todo this is where the fun begins!
    //yep
    @EventHandler
    public void onShift(PlayerToggleSneakEvent event){
        Player p = event.getPlayer();

        if (p.getInventory().getBoots() != null){
            if (p.getInventory().getBoots().getItemMeta() != null){
                if (p.getInventory().getBoots().getItemMeta().getDisplayName().equals(shadowAssassinBoots.getItemMeta().getDisplayName())){
                    if(playerAttributes.get(p).isCanDoubleJump()){
                        p.setVelocity(p.getLocation().getDirection().multiply(1.3));
                        p.getWorld().spawnParticle(Particle.CLOUD, p.getLocation(), 10, 0.1, 0, 0.1, 0.1);
                        playerAttributes.get(p).setCanDoubleJump(false);
                        return;
                    }
                }
            }
        }

        if (event.isSneaking()){
            if (p.getInventory().getHelmet() != null && p.getInventory().getChestplate() != null &&
                    p.getInventory().getLeggings() != null && p.getInventory().getBoots() != null){
                if (p.getInventory().getHelmet().getItemMeta() != null && p.getInventory().getChestplate().getItemMeta() != null
                        && p.getInventory().getLeggings().getItemMeta() != null && p.getInventory().getBoots().getItemMeta() != null){
                    if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals(lunarHelmetDay.getItemMeta().getDisplayName()) &&
                            p.getInventory().getChestplate().getItemMeta().getDisplayName().equals(lunarChestplateDay.getItemMeta().getDisplayName()) &&
                            p.getInventory().getLeggings().getItemMeta().getDisplayName().equals(lunarleggingsDay.getItemMeta().getDisplayName()) &&
                            p.getInventory().getBoots().getItemMeta().getDisplayName().equals(lunarBootsDay.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("LA", p)){
                            CooldownAPI.addCooldown("LA", p, 5);
                            p.getInventory().setHelmet(lunarHelmetNight);
                            p.getInventory().setChestplate(lunarChestplateNight);
                            p.getInventory().setLeggings(lunarLeggingsNight);
                            p.getInventory().setBoots(lunarBootsNight);
                            return;
                        } else p.sendMessage(ChatColor.RED + "This ability is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("LA", p) + "s.");
                    }
                    if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals(lunarHelmetNight.getItemMeta().getDisplayName()) &&
                            p.getInventory().getChestplate().getItemMeta().getDisplayName().equals(lunarChestplateNight.getItemMeta().getDisplayName()) &&
                            p.getInventory().getLeggings().getItemMeta().getDisplayName().equals(lunarLeggingsNight.getItemMeta().getDisplayName()) &&
                            p.getInventory().getBoots().getItemMeta().getDisplayName().equals(lunarBootsNight.getItemMeta().getDisplayName())){
                        if (!CooldownAPI.isOnCooldown("LA", p)){
                            CooldownAPI.addCooldown("LA", p, 5);
                            p.getInventory().setHelmet(lunarHelmetDay);
                            p.getInventory().setChestplate(lunarChestplateDay);
                            p.getInventory().setLeggings(lunarleggingsDay);
                            p.getInventory().setBoots(lunarBootsDay);
                        } else p.sendMessage(ChatColor.RED + "This ability is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("LA", p) + "s.");
                    }
                }
            }
        }
    }

    public static int calcBaseManaWithBonuses(int mana, Player player){
        if (player.getInventory().getHelmet() != null && player.getInventory().getChestplate() != null &&
                player.getInventory().getLeggings() != null && player.getInventory().getBoots() != null){
            if (player.getInventory().getHelmet().getItemMeta() != null && player.getInventory().getChestplate().getItemMeta() != null
                    && player.getInventory().getLeggings().getItemMeta() != null && player.getInventory().getBoots().getItemMeta() != null){
                if (player.getInventory().getHelmet().getItemMeta().getDisplayName().equals(shadowAssassinHelmet.getItemMeta().getDisplayName()) &&
                        player.getInventory().getChestplate().getItemMeta().getDisplayName().equals(shadowAssassinChestplate.getItemMeta().getDisplayName()) &&
                        player.getInventory().getLeggings().getItemMeta().getDisplayName().equals(shadowAssassinLeggings.getItemMeta().getDisplayName()) &&
                        player.getInventory().getBoots().getItemMeta().getDisplayName().equals(shadowAssassinBoots.getItemMeta().getDisplayName())){
                    return mana/2;
                }
            }
        }
        return mana;
    }

    public static void afterTeleportation(Player p){
        if (p.getInventory().getHelmet() != null){
            if (p.getInventory().getHelmet().getItemMeta() != null){
                if (p.getInventory().getHelmet().getItemMeta().getDisplayName().equals(shadowAssassinHelmet.getItemMeta().getDisplayName())){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 200, 0, false, false, true));
                }
            }
        }
        if (p.getInventory().getLeggings() != null){
            if (p.getInventory().getLeggings().getItemMeta() != null){
                if (p.getInventory().getLeggings().getItemMeta().getDisplayName().equals(shadowAssassinLeggings.getItemMeta().getDisplayName())){
                    String key = "saa";
                    if (entityMap.get(p).getBonusSpeed().containsKey(key)){
                        entityMap.get(p).getBonusSpeed().replace(key, 100.0);
                    } else {
                        entityMap.get(p).getBonusSpeed().put(key, 100.0);
                    }
                    playerAttributes.get(p).setTps2((short) (playerAttributes.get(p).getTps2()+1));
                    BukkitRunnable r1 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (entityMap.get(p)!=null){
                                if (playerAttributes.get(p).getTps2() > 1){
                                    playerAttributes.get(p).setTps2((short) (playerAttributes.get(p).getTps2()-1));
                                } else {
                                    entityMap.get(p).getBonusSpeed().replace(key, 0.0);
                                    playerAttributes.get(p).setTps2((short) 0);
                                }
                            }
                        }
                    };
                    r1.runTaskLater(plugin, 100);
                }
            }
        }
        if (p.getInventory().getBoots() != null){
            if (p.getInventory().getBoots().getItemMeta() != null){
                if (p.getInventory().getBoots().getItemMeta().getDisplayName().equals(shadowAssassinBoots.getItemMeta().getDisplayName())){
                    playerAttributes.get(p).setCanDoubleJump(true);
                    playerAttributes.get(p).setTps((short) (playerAttributes.get(p).getTps()+1));
                    BukkitRunnable r1 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (playerAttributes.get(p)!=null){
                                if (playerAttributes.get(p).getTps() > 1){
                                    playerAttributes.get(p).setTps((short) (playerAttributes.get(p).getTps()-1));
                                } else {
                                    playerAttributes.get(p).setCanDoubleJump(false);
                                    playerAttributes.get(p).setTps((short) 0);
                                }
                            }
                        }
                    };
                    r1.runTaskLater(plugin, 200);
                }
            }
        }
    }

    @EventHandler
    public void onTp(PlayerTeleportEvent event){
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.CHORUS_FRUIT) ||
                event.getCause().equals(PlayerTeleportEvent.TeleportCause.ENDER_PEARL)){
            afterTeleportation(event.getPlayer());
        }
    }
}
