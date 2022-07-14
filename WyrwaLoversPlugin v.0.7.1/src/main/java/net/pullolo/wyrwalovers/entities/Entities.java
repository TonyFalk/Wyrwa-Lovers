package net.pullolo.wyrwalovers.entities;

import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.items.Items.customArmorItems;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class Entities {

    private static ItemStack lapisZombieChest;
    private static ItemStack lapisZombieLegs;
    private static ItemStack lapisZombieBoots;

    public static void itemsInit(){
        createLapisZombieArmor();
    }

    private static void createLapisZombieArmor(){
        ItemStack item1 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta am1 = (LeatherArmorMeta) item1.getItemMeta();
        am1.setColor(Color.BLUE);
        am1.setDisplayName("§fLapis Zombie Chest");
        item1.setItemMeta(am1);
        customArmorItems.add("§fLapis Zombie Chest");
        lapisZombieChest = item1;

        ItemStack item2 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta am2 = (LeatherArmorMeta) item2.getItemMeta();
        am2.setColor(Color.BLUE);
        am2.setDisplayName("§fLapis Zombie Leggings");
        item2.setItemMeta(am2);
        customArmorItems.add("§fLapis Zombie Leggings");
        lapisZombieLegs = item2;

        ItemStack item3 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta am3 = (LeatherArmorMeta) item3.getItemMeta();
        am3.setColor(Color.BLUE);
        am3.setDisplayName("§fLapis Zombie Boots");
        item3.setItemMeta(am3);
        customArmorItems.add("§fLapis Zombie Boots");
        lapisZombieBoots = item3;
    }

    public static Entity spawnLapisZombie(Entity e){
        entities.add(e);
        entityMap.put(e, new EntityStats(e, "Lapis_Zombie"));

        if (e instanceof LivingEntity){
            ((LivingEntity) e).getEquipment().setHelmet(new ItemStack(Material.BLUE_STAINED_GLASS));
            ((LivingEntity) e).getEquipment().setChestplate(lapisZombieChest);
            ((LivingEntity) e).getEquipment().setLeggings(lapisZombieLegs);
            ((LivingEntity) e).getEquipment().setBoots(lapisZombieBoots);
            ((LivingEntity) e).setCanPickupItems(false);
            ((LivingEntity) e).getEquipment().setHelmetDropChance(0);
            ((LivingEntity) e).getEquipment().setChestplateDropChance(0);
            ((LivingEntity) e).getEquipment().setLeggingsDropChance(0);
            ((LivingEntity) e).getEquipment().setBootsDropChance(0);
        }
        return e;
    }
}
