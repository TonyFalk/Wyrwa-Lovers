package net.pullolo.wyrwalovers.items;

import net.pullolo.wyrwalovers.misc.Glow;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static net.pullolo.wyrwalovers.Main.glow;

public class Items {
    public static ArrayList<String> customItems = new ArrayList<>();

    //Todo add ItemStacks
    public static ItemStack enchDiamond;
    public static ItemStack enchIron;

    public static ItemStack boneSword;
    public static ItemStack steelSword;
    public static ItemStack silverSword;
    public static ItemStack healingWand;
    public static ItemStack healingStaff;
    public static ItemStack undeadSword;
    public static ItemStack cleaver;
    public static ItemStack golemSword;
    public static ItemStack slimeSword;

    public static ItemStack fieryCore;
    public static ItemStack tpCore;
    public static ItemStack flamingBow;
    public static ItemStack aspectOfEnd;
    public static ItemStack moltenBlade;
    public static ItemStack emberRod;
    public static ItemStack daysTouch;
    public static ItemStack nightsEdge;
    public static ItemStack aspectOfVoid;
    public static ItemStack legolasBow;
    public static ItemStack jumperStar;
    public static ItemStack pigmanSword;
    public static ItemStack ace;
    public static ItemStack moonSaber;
    public static ItemStack leapingSword;

    public static ItemStack atomsplitKatana;
    public static ItemStack mjolnir;
    public static ItemStack darmathon;
    public static ItemStack midasSword;
    public static ItemStack aspectOfDragons;
    public static ItemStack shadowFury;
    public static ItemStack mosquitoBow;

    public static ItemStack hyperion;

    public static ItemStack netheriteSword;
    public static ItemStack diamondSword;
    public static ItemStack ironSword;
    public static ItemStack goldSword;
    public static ItemStack stoneSword;
    public static ItemStack woodenSword;
    public static ItemStack bow;

    public static void init(){
        //Todo initialize those ItemStacks
        createVanillaSwords();
        createEnchDiamond();
        createEnchIron();

        createBoneSword();
        createSteelSword();
        createSilverSword();
        createHealingWand();
    }

    private static void createHealingWand(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fHealing Wand");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§6Item Ability: Small Heal §eRIGHT CLICK");
        lore.add("§7Gives you regeneration for §a5s.");
        lore.add("§8Mana Cost: §360");
        lore.add("§8Cooldown: §a10s");
        lore.add("");
        lore.add("§fCOMMON WAND");

        meta.setLore(lore);
        item.setItemMeta(meta);
        healingWand = item;
        customItems.add("§fHealing Wand");
    }

    private static void createBoneSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fBone Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+17");
        lore.add("§7Defense: §a+2");
        lore.add("");
        lore.add("§7This weapons was made of");
        lore.add("§7bones to crush bones.");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        boneSword = item;
        customItems.add("§fBone Sword");
    }

    private static void createSteelSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSteel Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+20");
        lore.add("§7Critical Damage: §c+10");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        steelSword = item;
        customItems.add("§fSteel Sword");
    }

    private static void createSilverSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSilver Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+19");
        lore.add("§7Critical Damage: §c+10");
        lore.add("");
        lore.add("§6Item Ability: Undead Slayer");
        lore.add("§7You deal §a150% §7more damage to all undead");
        lore.add("§7monsters.");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        silverSword = item;
        customItems.add("§fSilver Sword");
    }

    //Todo define and create those ItemStacks
    private static void createEnchDiamond(){
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Diamond");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchDiamond = item;
    }
    private static void createEnchIron(){
        ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Iron");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchIron = item;
    }

    private static void createVanillaSwords(){
        createNetheriteSword();
        createDiamondSword();
        createGoldSword();
        createIronSword();
        createStoneSword();
        createWoodenSword();
        createBow();
    }
    private static void createBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fBow");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+15");
        lore.add("");
        lore.add("§f§lCOMMON BOW");

        meta.setLore(lore);
        item.setItemMeta(meta);
        bow = item;
        customItems.add("§fBow");
    }
    private static void createNetheriteSword(){
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aNetherite Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+22");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        netheriteSword = item;
        customItems.add("§aNetherite Sword");
    }
    private static void createDiamondSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aDiamond Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+18");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        diamondSword = item;
        customItems.add("§aDiamond Sword");
    }
    private static void createIronSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fIron Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+13");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        ironSword = item;
        customItems.add("§fIron Sword");
    }
    private static void createGoldSword(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fGolden Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+8");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        goldSword = item;
        customItems.add("§fGolden Sword");
    }
    private static void createStoneSword(){
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fStone Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+6");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        stoneSword = item;
        customItems.add("§fStone Sword");
    }
    private static void createWoodenSword(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fWooden Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+4");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        woodenSword = item;
        customItems.add("§fWooden Sword");
    }

    public static ItemStats getItemStats(ItemStack item){
        if (item.getItemMeta().getLore() == null){
            return null;
        }
        List<String> lore = item.getItemMeta().getLore();
        double damage = 0;
        double intelligence = 0;
        double health = 0;
        double defense = 0;
        double abilityPower = 0;
        double critDamage = 0;
        double critChance = 0;
        double resistance = 0;
        double speed = 0;
        for (String s : lore){
            try{
                if (s.contains("§7Damage: ")){
                    String[] ss = s.split("§c\\+");
                    damage = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Intelligence: ")){
                    String[] ss = s.split("§b\\+");
                    intelligence = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Health: ")){
                    String[] ss = s.split("§4\\+");
                    health = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Defense: ")){
                    String[] ss = s.split("§a\\+");
                    defense = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Ability Damage: ")){
                    String[] ss = s.split("§3\\+");
                    abilityPower = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Critical Chance: ")){
                    String[] ss = s.split("§c\\+");
                    critChance = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Critical Damage: ")){
                    String[] ss = s.split("§c\\+");
                    critDamage = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Resistance: ")){
                    String[] ss = s.split("§3\\+");
                    resistance = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Speed: ")){
                    String[] ss = s.split("§f\\+");
                    speed = Double.parseDouble(ss[1]);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return new ItemStats(damage, intelligence, health, defense, abilityPower, critDamage, critChance, resistance, speed);
    }
}
