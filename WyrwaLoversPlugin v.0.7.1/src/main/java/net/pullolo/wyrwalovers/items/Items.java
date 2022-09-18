package net.pullolo.wyrwalovers.items;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import java.util.ArrayList;
import java.util.List;

import static net.pullolo.wyrwalovers.Main.glow;

public class Items {
    public static ArrayList<String> customItems = new ArrayList<>();
    public static ArrayList<String> customArmorItems = new ArrayList<>();
    //Todo add ItemStacks
    public static ItemStack silver;
    public static ItemStack enchBone;
    public static ItemStack enchDiamond;
    public static ItemStack enchIron;
    public static ItemStack enchCoal;
    public static ItemStack enchGold;
    public static ItemStack enchGunPowder;
    public static ItemStack enchString;
    public static ItemStack enchLapis;
    public static ItemStack enchRottenFlesh;
    public static ItemStack enchEnderPearl;
    public static ItemStack enchSlime;
    public static ItemStack enchFeather;

    public static ItemStack boneSword;
    public static ItemStack steelSword;
    public static ItemStack silverSword;
    public static ItemStack healingWand;
    public static ItemStack heavyShield;
    public static ItemStack healingStaff;
    public static ItemStack witchStaff;
    public static ItemStack undeadSword;
    public static ItemStack cleaver;
    public static ItemStack golemSword;
    public static ItemStack slimeSword;
    public static ItemStack grapplingHook;
    public static ItemStack flingingSword;
    public static ItemStack heavySword;
    public static ItemStack berserkerAxe;
    public static ItemStack pullingBow;
    public static ItemStack EnderSword;

    public static ItemStack fieryCore;
    public static ItemStack tpCore;
    public static ItemStack flamingBow;
    public static ItemStack aspectOfEnd;
    public static ItemStack moltenBlade;
    public static ItemStack emberRod;
    public static ItemStack daysTouch;
    public static ItemStack hurricaneBow;
    public static ItemStack nightsEdge;
    public static ItemStack iceWand;
    public static ItemStack legolasBow;
    public static ItemStack jumperStar;
    public static ItemStack pigmanSword;
    public static ItemStack ace;
    public static ItemStack moonSaber;
    public static ItemStack leapingSword;
    public static ItemStack brutalityBlade;
    public static ItemStack midasPickaxe;

    public static ItemStack atomsplitKatana;
    public static ItemStack mjolnir;
    public static ItemStack darmathon;
    public static ItemStack midasSword;
    public static ItemStack aspectOfDragons;
    public static ItemStack shadowFury;
    public static ItemStack mosquitoBow;
    public static ItemStack orphanObliterator;

    public static ItemStack hyperion;

    public static ItemStack shadowGoggles;
    public static ItemStack heavyChestplate;

    public static ItemStack angelHelmet;
    public static ItemStack angelChestplate;
    public static ItemStack angelLeggings;
    public static ItemStack angelBoots;

    public static ItemStack shadowAssassinHelmet;
    public static ItemStack shadowAssassinChestplate;
    public static ItemStack shadowAssassinLeggings;
    public static ItemStack shadowAssassinBoots;

    public static ItemStack lunarHelmetDay;
    public static ItemStack lunarHelmetNight;
    public static ItemStack lunarChestplateDay;
    public static ItemStack lunarChestplateNight;
    public static ItemStack lunarleggingsDay;
    public static ItemStack lunarLeggingsNight;
    public static ItemStack lunarBootsDay;
    public static ItemStack lunarBootsNight;

    public static ItemStack netheriteSword;
    public static ItemStack diamondSword;
    public static ItemStack ironSword;
    public static ItemStack goldSword;
    public static ItemStack stoneSword;
    public static ItemStack woodenSword;
    public static ItemStack bow;

    public static ItemStack leatherBoots;
    public static ItemStack leatherLeggings;
    public static ItemStack leatherChestplate;
    public static ItemStack leatherHelmet;

    public static ItemStack chainmailBoots;
    public static ItemStack chainmailLeggings;
    public static ItemStack chainmailChestplate;
    public static ItemStack chainmailHelmet;

    public static ItemStack ironBoots;
    public static ItemStack ironLeggings;
    public static ItemStack ironChestplate;
    public static ItemStack ironHelmet;

    public static ItemStack goldBoots;
    public static ItemStack goldLeggings;
    public static ItemStack goldChestplate;
    public static ItemStack goldHelmet;

    public static ItemStack diamondBoots;
    public static ItemStack diamondLeggings;
    public static ItemStack diamondChestplate;
    public static ItemStack diamondHelmet;

    public static ItemStack netheriteBoots;
    public static ItemStack netheriteLeggings;
    public static ItemStack netheriteChestplate;
    public static ItemStack netheriteHelmet;

    public static void init(){
        //Todo initialize those ItemStacks
        createVanillaSwords();
        createVanillaArmor();
        createEnchDiamond();
        createEnchIron();
        createEnchBone();
        createSilver();
        createEnchCoal();
        createEnchGold();
        createEnchGunPowder();
        createEnchString();
        createEnchLapis();
        createEnchRottenFlesh();
        createEnchEnderPearl();
        createEnchSlime();
        createEnchFeather();

        createBoneSword();
        createSteelSword();
        createSilverSword();
        createHealingWand();
        createHeavyShield();
        createHealingStaff();
        createWitchStaff();
        createUndeadSword();
        createCleaver();
        createSlimeSword();
        createGolemSword();
        createGrapplingHook();
        createFlingingSword();
        createHeavySword();
        createBerserkerAxe();
        createPullingBow();
        createEnderSword();

        createAspectOfEnd();
        createFlamingBow();
        createFieryCore();
        createTeleportationCore();
        createHurricaneBow();
        createMoltenBlade();
        createEmberRod();
        createLeapingSword();
        createBrutalityBlade();
        createMidasPickaxe();

        createAspectOfDragons();
        createHyperion();

        createShadowGoggles();
        createHeavyChestplate();
        createAngelArmor();
        createShadowAssassinArmor();
        createLunarArmor();
    }

    private static void createHurricaneBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Hurricane Bow");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+50");
        lore.add("");
        lore.add("§6Item Ability: Triple Shot");
        lore.add("§7Shoot 3 arrows.");
        lore.add("");
        lore.add("§9§lRARE BOW");

        meta.setLore(lore);
        item.setItemMeta(meta);
        hurricaneBow = item;
        customItems.add("§9Hurricane Bow");
    }

    private static void createMidasPickaxe(){
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Midas Pickaxe");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§6Item Ability: Riches");
        lore.add("§7While mining gold you have a §a4%");
        lore.add("§7chance to find diamonds.");
        lore.add("");
        lore.add("§5§lEPIC TOOL");

        meta.setLore(lore);
        item.setItemMeta(meta);
        midasPickaxe = item;
        customItems.add("§5Midas Pickaxe");
    }

    private static void createEmberRod(){
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Ember Rod");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+48");
        lore.add("§7Intelligence: §b+50");
        lore.add("§7Ability Damage: §3+30");
        lore.add("");
        lore.add("§6Item Ability: Fireball §eRIGHT CLICK");
        lore.add("§7Shoot out a fire ball witch §aexplodes §7on impact");
        lore.add("§7dealing lots of damage.");
        lore.add("§8Mana Cost: §380");
        lore.add("");
        lore.add("§9§lRARE SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        emberRod = item;
        customItems.add("§9Ember Rod");
    }

    private static void createMoltenBlade(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Molten Blade");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+50");
        lore.add("");
        lore.add("§6Item Ability: Ignition");
        lore.add("§7Set your target on fire.");
        lore.add("");
        lore.add("§9§lRARE SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        moltenBlade = item;
        customItems.add("§9Molten Blade");
    }

    private static void createEnchFeather(){
        ItemStack item = new ItemStack(Material.FEATHER, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Feather");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchFeather = item;
    }

    private static void createEnchSlime(){
        ItemStack item = new ItemStack(Material.SLIME_BALL, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Slime");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchSlime = item;
    }

    private static void createEnchEnderPearl(){
        ItemStack item = new ItemStack(Material.ENDER_PEARL, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Ender Pearl");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchEnderPearl = item;
    }

    private static void createEnchRottenFlesh(){
        ItemStack item = new ItemStack(Material.ROTTEN_FLESH, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Rotten Flesh");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchRottenFlesh = item;
    }

    private static void createEnchLapis(){
        ItemStack item = new ItemStack(Material.LAPIS_LAZULI, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Lapis");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchLapis = item;
    }

    private static void createEnchString(){
        ItemStack item = new ItemStack(Material.STRING, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted String");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchString = item;
    }

    private static void createEnchGunPowder(){
        ItemStack item = new ItemStack(Material.GUNPOWDER, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Gunpowder");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchGunPowder = item;
    }

    private static void createEnchGold(){
        ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Gold");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchGold = item;
    }

    private static void createEnchCoal(){
        ItemStack item = new ItemStack(Material.COAL, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Coal");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchCoal = item;
    }

    private static void createPullingBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aPulling Bow");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+25");
        lore.add("");
        lore.add("§6Item Ability: Pull");
        lore.add("§7Pull enemies towards you.");
        lore.add("");
        lore.add("§a§lUNCOMMON BOW");

        meta.setLore(lore);
        item.setItemMeta(meta);
        pullingBow = item;
        customItems.add("§aPulling Bow");
    }

    private static void createWitchStaff(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fWitch's Staff");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+20");
        lore.add("");
        lore.add("§6Item Ability: Negative Effects");
        lore.add("§7You have a §a25% §7chance to inflict §anegative §7effects.");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        witchStaff = item;
        customItems.add("§fWitch's Staff");
    }

    private static void createBrutalityBlade(){
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Brutality Blade");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+75");
        lore.add("");
        lore.add("§6Item Ability: Brutality");
        lore.add("§7If the target is below §a50% §7health");
        lore.add("§7deal §a100% §7more damage.");
        lore.add("");
        lore.add("§5§lEPIC SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        brutalityBlade = item;
        customItems.add("§5Brutality Blade");
    }

    private static void createHeavyChestplate(){
        ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aHeavy Chestplate");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Defense: §a+65");
        lore.add("§7Health: §4+30");
        lore.add("§7Speed: §f-10");
        lore.add("");
        lore.add("§a§lUNCOMMON CHESTPLATE");

        meta.setLore(lore);
        item.setItemMeta(meta);
        heavyChestplate = item;
        customArmorItems.add("§aHeavy Chestplate");
    }

    private static void createBerserkerAxe(){
        ItemStack item = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aBerserker's Axe");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+25");
        lore.add("");
        lore.add("§6Item Ability: Rage §eRIGHT CLICK");
        lore.add("§7Get additional §a5 §7base damage");
        lore.add("§7and §a20 §7speed for 10 seconds.");
        lore.add("§8Cooldown: §a40s");
        lore.add("");
        lore.add("§a§lUNCOMMON AXE");

        meta.setLore(lore);
        item.setItemMeta(meta);
        berserkerAxe = item;
        customItems.add("§aBerserker's Axe");
    }

    private static void createHeavySword(){
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aHeavy Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+40");
        lore.add("§7Speed: §f-20");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        heavySword = item;
        customItems.add("§aHeavy Sword");
    }

    private static void createHeavyShield(){
        ItemStack item = new ItemStack(Material.SHIELD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fHeavy Shield");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("§7Defense: §a+30");
        lore.add("§7Speed: §f-10");
        lore.add("");
        lore.add("§f§lCOMMON SHIELD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        heavyShield = item;
        customItems.add("§fHeavy Shield");
    }

    private static void createFlingingSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aFlinging Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+25");
        lore.add("");
        lore.add("§6Item Ability: Fling");
        lore.add("§7Launch your enemies into the air!");
        lore.add("§8Cooldown: §a5s");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        flingingSword = item;
        customItems.add("§aFlinging Sword");
    }

    private static void createGrapplingHook(){
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aGrappling Hook");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§6Item Ability: Grapple §eRIGHT CLICK");
        lore.add("§7Throw your self ahead where was");
        lore.add("§7your grappling hook.");
        lore.add("§8Cooldown: §a2s");
        lore.add("");
        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        grapplingHook = item;
        customItems.add("§aGrappling Hook");
    }

    private static void createLunarArmor(){
        createLunarArmorDay();
        createLunarArmorNight();
    }

    private static void createLunarArmorNight(){
        ItemStack item1 = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTk1MmM2YjAyM2I3ZjE5YjA4Yjc3NDlkZGMzNGQ5NTc4ZDAyODc3N2JiZGQ2MDAxMmUwMTgzZTY5NjUxYWQ4OSJ9fX0=");
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§5Lunar Helmet (Night)");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+60");
        lore1.add("§7Resistance: §3+60");
        lore1.add("§7Health: §4+40");
        lore1.add("§7Critical Damage: §c+20");
        lore1.add("§7Critical Chance: §c+10");
        lore1.add("");
        lore1.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore1.add("§7Your armour will change state to §aday.");
        lore1.add("§8Cooldown: §a5s");
        lore1.add("");
        lore1.add("§5§lEPIC HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        lunarHelmetNight = item1;
        customArmorItems.add("§5Lunar Helmet (Night)");

        ItemStack item2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) item2.getItemMeta();
        meta2.setColor(Color.fromBGR(15, 15, 15));
        meta2.setDisplayName("§5Lunar Chestplate (Night)");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta2.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+120");
        lore2.add("§7Resistance: §3+100");
        lore2.add("§7Health: §4+40");
        lore2.add("§7Critical Damage: §c+50");
        lore2.add("§7Critical Chance: §c+10");
        lore2.add("");
        lore2.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore2.add("§7Your armour will change state to §aday.");
        lore2.add("§8Cooldown: §a5s");
        lore2.add("");
        lore2.add("§6Piece Bonus: Night's edge");
        lore2.add("§7Gain §a70 §7Crit Damage during the night.");
        lore2.add("");
        lore2.add("§5§lEPIC CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        lunarChestplateNight = item2;
        customArmorItems.add("§5Lunar Chestplate (Night)");

        ItemStack item3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta3 = (LeatherArmorMeta) item3.getItemMeta();
        meta3.setColor(Color.fromBGR(7, 7, 7));
        meta3.setDisplayName("§5Lunar Leggings (Night)");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta3.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+70");
        lore3.add("§7Resistance: §3+60");
        lore3.add("§7Health: §4+40");
        lore3.add("§7Critical Damage: §c+40");
        lore3.add("§7Critical Chance: §c+10");
        lore3.add("");
        lore3.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore3.add("§7Your armour will change state to §aday.");
        lore3.add("§8Cooldown: §a5s");
        lore3.add("");
        lore3.add("§6Piece Bonus: Moons rush");
        lore3.add("§7Gain §a50 §7speed during the night.");
        lore3.add("");
        lore3.add("§5§lEPIC LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        lunarLeggingsNight = item3;
        customArmorItems.add("§5Lunar Leggings (Night)");

        ItemStack item4 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta4 = (LeatherArmorMeta) item4.getItemMeta();
        meta4.setColor(Color.fromBGR(0, 0, 0));
        meta4.setDisplayName("§5Lunar Boots (Night)");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta4.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+30");
        lore4.add("§7Resistance: §3+30");
        lore4.add("§7Health: §4+40");
        lore4.add("§7Critical Damage: §c+30");
        lore4.add("§7Critical Chance: §c+10");
        lore4.add("");
        lore4.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore4.add("§7Your armour will change state to §aday.");
        lore4.add("§8Cooldown: §a5s");
        lore4.add("");
        lore4.add("§5§lEPIC BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        lunarBootsNight = item4;
        customArmorItems.add("§5Lunar Boots (Night)");
    }

    private static void createLunarArmorDay(){
        ItemStack item1 = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDU4NWJjNzU3ZGY1MDhhN2MyZWY3MDU1ZmY0ZDliYmQ2OWIxYmE4MGIzNTRjOWUzOWJjNTUyY2VjYmQ3ZTVjIn19fQ==");
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§5Lunar Helmet (Day)");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+140");
        lore1.add("§7Resistance: §3+90");
        lore1.add("§7Health: §4+100");
        lore1.add("§7Damage: §c+1");
        lore1.add("");
        lore1.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore1.add("§7Your armour will change state to §anight.");
        lore1.add("§8Cooldown: §a5s");
        lore1.add("");
        lore1.add("§5§lEPIC HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        lunarHelmetDay = item1;
        customArmorItems.add("§5Lunar Helmet (Day)");

        ItemStack item2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) item2.getItemMeta();
        meta2.setColor(Color.YELLOW);
        meta2.setDisplayName("§5Lunar Chestplate (Day)");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta2.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+220");
        lore2.add("§7Resistance: §3+200");
        lore2.add("§7Health: §4+100");
        lore2.add("§7Damage: §c+2");
        lore2.add("");
        lore2.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore2.add("§7Your armour will change state to §anight.");
        lore2.add("§8Cooldown: §a5s");
        lore2.add("");
        lore2.add("§6Piece Bonus: Reflecting");
        lore2.add("§7Gain §a90 §7Defense during the day.");
        lore2.add("");
        lore2.add("§5§lEPIC CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        lunarChestplateDay = item2;
        customArmorItems.add("§5Lunar Chestplate (Day)");

        ItemStack item3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta3 = (LeatherArmorMeta) item3.getItemMeta();
        meta3.setColor(Color.YELLOW);
        meta3.setDisplayName("§5Lunar Leggings (Day)");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta3.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+170");
        lore3.add("§7Resistance: §3+110");
        lore3.add("§7Health: §4+100");
        lore3.add("§7Damage: §c+1");
        lore3.add("");
        lore3.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore3.add("§7Your armour will change state to §anight.");
        lore3.add("§8Cooldown: §a5s");
        lore3.add("");
        lore3.add("§6Piece Bonus: Solar Energy");
        lore3.add("§7Gain §a120 §7intelligence during the day.");
        lore3.add("");
        lore3.add("§5§lEPIC LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        lunarleggingsDay = item3;
        customArmorItems.add("§5Lunar Leggings (Day)");

        ItemStack item4 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta4 = (LeatherArmorMeta) item4.getItemMeta();
        meta4.setColor(Color.YELLOW);
        meta4.setDisplayName("§5Lunar Boots (Day)");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta4.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+130");
        lore4.add("§7Resistance: §3+90");
        lore4.add("§7Health: §4+100");
        lore4.add("§7Damage: §c+1");
        lore4.add("");
        lore4.add("§6Full Set Bonus: Phase Switch §ePRESS SHIFT");
        lore4.add("§7Your armour will change state to §anight.");
        lore4.add("§8Cooldown: §a5s");
        lore4.add("");
        lore4.add("§5§lEPIC BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        lunarBootsDay = item4;
        customArmorItems.add("§5Lunar Boots (Day)");
    }

    private static void createVanillaArmor(){
        createLeatherArmor();
        createChainmailArmor();
        createIronArmor();
        createGoldenArmor();
        createDiamondArmor();
        createNetheriteArmor();
    }

    private static void createNetheriteArmor(){
        ItemStack item1 = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§aNetherite Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+30");
        lore1.add("");
        lore1.add("§a§lUNCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        netheriteHelmet = item1;
        customArmorItems.add("§aNetherite Helmet");

        ItemStack item2 = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§aNetherite Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+45");
        lore2.add("");
        lore2.add("§a§lUNCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        netheriteChestplate = item2;
        customArmorItems.add("§aNetherite Chestplate");

        ItemStack item3 = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§aNetherite Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+32");
        lore3.add("");
        lore3.add("§a§lUNCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        netheriteLeggings = item3;
        customArmorItems.add("§aNetherite Leggings");

        ItemStack item4 = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§aNetherite Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+30");
        lore4.add("");
        lore4.add("§a§lUNCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        netheriteBoots = item4;
        customArmorItems.add("§aNetherite Boots");
    }

    private static void createDiamondArmor(){
        ItemStack item1 = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§aDiamond Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+20");
        lore1.add("");
        lore1.add("§a§lUNCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        diamondHelmet = item1;
        customArmorItems.add("§aDiamond Helmet");

        ItemStack item2 = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§aDiamond Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+38");
        lore2.add("");
        lore2.add("§a§lUNCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        diamondChestplate = item2;
        customArmorItems.add("§aDiamond Chestplate");

        ItemStack item3 = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§aDiamond Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+28");
        lore3.add("");
        lore3.add("§a§lUNCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        diamondLeggings = item3;
        customArmorItems.add("§aDiamond Leggings");

        ItemStack item4 = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§aDiamond Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+20");
        lore4.add("");
        lore4.add("§a§lUNCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        diamondBoots = item4;
        customArmorItems.add("§aDiamond Boots");
    }

    private static void createGoldenArmor(){
        ItemStack item1 = new ItemStack(Material.GOLDEN_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§fGolden Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+11");
        lore1.add("");
        lore1.add("§f§lCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        goldHelmet = item1;
        customArmorItems.add("§fGolden Helmet");

        ItemStack item2 = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§fGolden Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+22");
        lore2.add("");
        lore2.add("§f§lCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        goldChestplate = item2;
        customArmorItems.add("§fGolden Chestplate");

        ItemStack item3 = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§fGolden Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+17");
        lore3.add("");
        lore3.add("§f§lCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        goldLeggings = item3;
        customArmorItems.add("§fGolden Leggings");

        ItemStack item4 = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§fGolden Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+10");
        lore4.add("");
        lore4.add("§f§lCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        goldBoots = item4;
        customArmorItems.add("§fGolden Boots");
    }

    private static void createIronArmor(){
        ItemStack item1 = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§fIron Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+12");
        lore1.add("");
        lore1.add("§f§lCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        ironHelmet = item1;
        customArmorItems.add("§fIron Helmet");

        ItemStack item2 = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§fIron Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+24");
        lore2.add("");
        lore2.add("§f§lCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        ironChestplate = item2;
        customArmorItems.add("§fIron Chestplate");

        ItemStack item3 = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§fIron Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+18");
        lore3.add("");
        lore3.add("§f§lCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        ironLeggings = item3;
        customArmorItems.add("§fIron Leggings");

        ItemStack item4 = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§fIron Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+11");
        lore4.add("");
        lore4.add("§f§lCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        ironBoots = item4;
        customArmorItems.add("§fIron Boots");
    }

    private static void createChainmailArmor(){
        ItemStack item1 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§fChainmail Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+6");
        lore1.add("");
        lore1.add("§f§lCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        chainmailHelmet = item1;
        customArmorItems.add("§fChainmail Helmet");

        ItemStack item2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§fChainmail Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+18");
        lore2.add("");
        lore2.add("§f§lCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        chainmailChestplate = item2;
        customArmorItems.add("§fChainmail Chestplate");

        ItemStack item3 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§fChainmail Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+14");
        lore3.add("");
        lore3.add("§f§lCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        chainmailLeggings = item3;
        customArmorItems.add("§fChainmail Leggings");

        ItemStack item4 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§fChainmail Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+8");
        lore4.add("");
        lore4.add("§f§lCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        chainmailBoots = item4;
        customArmorItems.add("§fChainmail Boots");
    }

    private static void createLeatherArmor(){
        ItemStack item1 = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§fLeather Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+5");
        lore1.add("");
        lore1.add("§f§lCOMMON HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        leatherHelmet = item1;
        customArmorItems.add("§fLeather Helmet");

        ItemStack item2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§fLeather Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+15");
        lore2.add("");
        lore2.add("§f§lCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        leatherChestplate = item2;
        customArmorItems.add("§fLeather Chestplate");

        ItemStack item3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§fLeather Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+10");
        lore3.add("");
        lore3.add("§f§lCOMMON LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        leatherLeggings = item3;
        customArmorItems.add("§fLeather Leggings");

        ItemStack item4 = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§fLeather Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+4");
        lore4.add("");
        lore4.add("§f§lCOMMON BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        leatherBoots = item4;
        customArmorItems.add("§fLeather Boots");
    }

    private static void createTeleportationCore(){
        ItemStack item = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2MwZGFlNDdhNzY3NWJhMDczZDdlZjU1NzQxZjBmYTVjY2U4YjYzNGUwMGFjZTY1NDUxYzU1NzZjMjdhY2M3OCJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Teleportation Core");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§6Item Ability: Teleport §eRIGHT CLICK");
        lore.add("§7This item will teleport you to random location.");
        lore.add("§8Mana Cost: §3100");
        lore.add("");
        lore.add("§9§lRARE ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        tpCore = item;
        customItems.add("§9Teleportation Core");
    }

    private static void createFieryCore(){
        ItemStack item = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRiNjYyZDNiNTI5YTE4NzI2MWNhYjg2YzZlNTY0MjNiZjg3NmFhMjQ5ZDAzMGZhZWFmMzQzNjJmMzQ0NzI3NyJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Fiery Core");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§7This item is used in crafting many");
        lore.add("§7weapons based on fire.");
        lore.add("");
        lore.add("§9§lRARE ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        fieryCore = item;
        customItems.add("§9Fiery Core");
    }

    private static void createShadowGoggles(){
        ItemStack item = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzQ2NWE4NDdlMTE0ZWY2MmU3ODMzY2JmYjJmZTVkZTU3NjRiYWI1ZjEwYWYxMjVmZDJkMzE2MjM4MjY4Mjc5ZiJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Shadow Goggles");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Defense: §a+30");
        lore.add("§7Resistance: §3+30");
        lore.add("§7Intelligence: §b+400");
        lore.add("");
        lore.add("§9§lRARE HELMET");

        meta.setLore(lore);
        item.setItemMeta(meta);
        shadowGoggles = item;
        customArmorItems.add("§9Shadow Goggles");
    }

    private static void createShadowAssassinArmor(){
        ItemStack item1 = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWI4YWY1MmVmMmY3MmMzYmY1ZWNlNmU3MGE4MmYxMzcxOTU5Y2UzZmNiNzM2YzUwMDMwNWNhZGRjNTA1YzVlMiJ9fX0=");
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§5Shadow Assassin Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+40");
        lore1.add("§7Resistance: §3+30");
        lore1.add("§7Health: §4+30");
        lore1.add("§7Damage: §c+2");
        lore1.add("§7Critical Damage: §c+50");
        lore1.add("§7Critical Chance: §c+15");
        lore1.add("");
        lore1.add("§6Full Set Bonus: Simple Assassination");
        lore1.add("§7All of your abilities cost §a50%§7 less mana.");
        lore1.add("");
        lore1.add("§6Piece Bonus: Going Dark");
        lore1.add("§7After teleportation you go invisible for §a10 §7seconds.");
        lore1.add("");
        lore1.add("§5§lEPIC HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        shadowAssassinHelmet = item1;
        customArmorItems.add("§5Shadow Assassin Helmet");

        ItemStack item2 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) item2.getItemMeta();
        meta2.setColor(Color.BLACK);
        meta2.setDisplayName("§5Shadow Assassin Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta2.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+80");
        lore2.add("§7Resistance: §3+40");
        lore2.add("§7Health: §4+30");
        lore2.add("§7Damage: §c+3");
        lore2.add("§7Critical Damage: §c+90");
        lore2.add("§7Critical Chance: §c+15");
        lore2.add("");
        lore2.add("§6Full Set Bonus: Simple Assassination");
        lore2.add("§7All of your abilities cost §a50%§7 less mana.");
        lore2.add("");
        lore2.add("§6Piece Bonus: Preparing");
        lore2.add("§7For every piece of this armor get §a30§7 Defense.");
        lore2.add("");
        lore2.add("§5§lEPIC CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        shadowAssassinChestplate = item2;
        customArmorItems.add("§5Shadow Assassin Chestplate");

        ItemStack item3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta3 = (LeatherArmorMeta) item3.getItemMeta();
        meta3.setColor(Color.BLACK);
        meta3.setDisplayName("§5Shadow Assassin Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta3.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+60");
        lore3.add("§7Resistance: §3+30");
        lore3.add("§7Health: §4+30");
        lore3.add("§7Damage: §c+3");
        lore3.add("§7Critical Damage: §c+70");
        lore3.add("§7Critical Chance: §c+15");
        lore3.add("");
        lore3.add("§6Full Set Bonus: Simple Assassination");
        lore3.add("§7All of your abilities cost §a50%§7 less mana.");
        lore3.add("");
        lore3.add("§6Piece Bonus: Swiftness");
        lore3.add("§7After teleportation gain §a100 §7speed.");
        lore3.add("");
        lore3.add("§5§lEPIC LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        shadowAssassinLeggings = item3;
        customArmorItems.add("§5Shadow Assassin Leggings");

        ItemStack item4 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta4 = (LeatherArmorMeta) item4.getItemMeta();
        meta4.setColor(Color.BLACK);
        meta4.setDisplayName("§5Shadow Assassin Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta4.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+40");
        lore4.add("§7Resistance: §3+20");
        lore4.add("§7Health: §4+30");
        lore4.add("§7Damage: §c+2");
        lore4.add("§7Critical Damage: §c+40");
        lore4.add("§7Critical Chance: §c+15");
        lore4.add("");
        lore4.add("§6Full Set Bonus: Simple Assassination");
        lore4.add("§7All of your abilities cost §a50%§7 less mana.");
        lore4.add("");
        lore4.add("§6Piece Bonus: Agility §ePRESS SHIFT");
        lore4.add("§7After teleportation gain an ability to");
        lore4.add("§7Double jump §a1 §7time.");
        lore4.add("");
        lore4.add("§5§lEPIC BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        shadowAssassinBoots = item4;
        customArmorItems.add("§5Shadow Assassin Boots");
    }

    private static void createFlamingBow(){
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Flaming Bow");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+48");
        lore.add("");
        lore.add("§6Item Ability: Ignition");
        lore.add("§7Set your target on fire.");
        lore.add("");
        lore.add("§9§lRARE BOW");

        meta.setLore(lore);
        item.setItemMeta(meta);
        flamingBow = item;
        customItems.add("§9Flaming Bow");
    }

    private static void createLeapingSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Leaping Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+95");
        lore.add("");
        lore.add("§6Item Ability: Leap §eRIGHT CLICK");
        lore.add("§7Leap into the air and deal §a80");
        lore.add("§7base damage to nearby enemies.");
        lore.add("§8Mana Cost: §3100");
        lore.add("§8Cooldown: §a10s");
        lore.add("");
        lore.add("§5§lEPIC SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        leapingSword = item;
        customItems.add("§5Leaping Sword");
    }

    private static void createAspectOfDragons(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Aspect of the Dragons");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+150");
        lore.add("");
        lore.add("§6Item Ability: Dragon Rage §eRIGHT CLICK");
        lore.add("§7All monsters in front of you");
        lore.add("§7take §a130 §7base damage. §7Hit monsters");
        lore.add("§7take large knockback.");
        lore.add("§8Mana Cost: §3100");
        lore.add("§8Cooldown: §a5s");
        lore.add("");
        lore.add("§6§lLEGENDARY SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        aspectOfDragons = item;
        customItems.add("§6Aspect of the Dragons");
    }

    private static void createAspectOfEnd(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Aspect of the End");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+60");
        lore.add("");
        lore.add("§6Item Ability: Instant Transmission §eRIGHT CLICK");
        lore.add("§7Teleport §a8 blocks §7ahead of you.");
        lore.add("§8Mana Cost: §350");
        lore.add("");
        lore.add("§9§lRARE SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        aspectOfEnd = item;
        customItems.add("§9Aspect of the End");
    }

    private static void createHyperion(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dHyperion");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+230");
        lore.add("§7Ability Damage: §3+100");
        lore.add("");
        lore.add("§6Item Ability: Wither Impact §eRIGHT CLICK");
        lore.add("§7Teleport §a10 blocks §7forward and ");
        lore.add("§7deal §a100% §7 base damage to nearby enemies.");
        lore.add("§8Mana Cost: §3300");
        lore.add("");
        lore.add("§d§lMYTHIC SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        hyperion = item;
        customItems.add("§dHyperion");
    }

    private static void createGolemSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aGolem Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+27");
        lore.add("");
        lore.add("§6Item Ability: Iron Punch §eRIGHT CLICK");
        lore.add("§7A giant pile of iron appears above you");
        lore.add("§7and powerfully slams the ground dealing §a90% §7damage");
        lore.add("§7of the base weapon.");
        lore.add("§8Mana Cost: §3140");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        golemSword = item;
        customItems.add("§aGolem Sword");
    }

    private static void createSlimeSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aSlime Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+27");
        lore.add("§7Health: §4+20");
        lore.add("");
        lore.add("§6Item Ability: Stickiness");
        lore.add("§7Slow down your enemies by punching them.");
        lore.add("§8Cooldown: §a5s");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        slimeSword = item;
        customItems.add("§aSlime Sword");
    }

    private static void createAngelArmor(){
        ItemStack item1 = getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2ZlNWRjNTEyZGQ1OTFhYjAyZWJkMzcyYzI4NWY0ODFjODc2YjQ5MWNiYWQyMDU2NjUzZGQxMTg5Yzg0ZGVmZiJ9fX0=");
        ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§9Angel Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("§7Defense: §a+90");
        lore1.add("§7Resistance: §3+80");
        lore1.add("§7Health: §4+70");
        lore1.add("§7Critical Damage: §c+20");
        lore1.add("§7Critical Chance: §c+5");
        lore1.add("");
        lore1.add("§6Full Set Bonus: Salvation");
        lore1.add("§7You negate the §a1st§7 hit.");
        lore1.add("§8Cooldown: §a40s");
        lore1.add("");
        lore1.add("§9§lRARE HELMET");

        meta1.setLore(lore1);
        item1.setItemMeta(meta1);
        angelHelmet = item1;
        customArmorItems.add("§9Angel Helmet");

        ItemStack item2 = new ItemStack(Material.GOLDEN_CHESTPLATE, 1);
        ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§9Angel Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("§7Defense: §a+200");
        lore2.add("§7Resistance: §3+180");
        lore2.add("§7Health: §4+70");
        lore2.add("§7Critical Damage: §c+20");
        lore2.add("§7Critical Chance: §c+5");
        lore2.add("");
        lore2.add("§6Full Set Bonus: Salvation");
        lore2.add("§7You negate the §a1st§7 hit.");
        lore2.add("§8Cooldown: §a40s");
        lore2.add("");
        lore2.add("§9§lRARE CHESTPLATE");

        meta2.setLore(lore2);
        item2.setItemMeta(meta2);
        angelChestplate = item2;
        customArmorItems.add("§9Angel Chestplate");

        ItemStack item3 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta meta3 = (LeatherArmorMeta) item3.getItemMeta();
        meta3.setColor(Color.WHITE);
        meta3.setDisplayName("§9Angel Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta3.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("§7Defense: §a+140");
        lore3.add("§7Resistance: §3+120");
        lore3.add("§7Health: §4+70");
        lore3.add("§7Critical Damage: §c+20");
        lore3.add("§7Critical Chance: §c+5");
        lore3.add("");
        lore3.add("§6Full Set Bonus: Salvation");
        lore3.add("§7You negate the §a1st§7 hit.");
        lore3.add("§8Cooldown: §a40s");
        lore3.add("");
        lore3.add("§9§lRARE LEGGINGS");

        meta3.setLore(lore3);
        item3.setItemMeta(meta3);
        angelLeggings = item3;
        customArmorItems.add("§9Angel Leggings");

        ItemStack item4 = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta meta4 = (LeatherArmorMeta) item4.getItemMeta();
        meta4.setColor(Color.WHITE);
        meta4.setDisplayName("§9Angel Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta4.addItemFlags(ItemFlag.HIDE_DYE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("§7Defense: §a+90");
        lore4.add("§7Resistance: §3+80");
        lore4.add("§7Health: §4+70");
        lore4.add("§7Critical Damage: §c+20");
        lore4.add("§7Critical Chance: §c+5");
        lore4.add("");
        lore4.add("§6Full Set Bonus: Salvation");
        lore4.add("§7You negate the §a1st§7 hit.");
        lore4.add("§8Cooldown: §a40s");
        lore4.add("");
        lore4.add("§9§lRARE BOOTS");

        meta4.setLore(lore4);
        item4.setItemMeta(meta4);
        angelBoots = item4;
        customArmorItems.add("§9Angel Boots");
    }

    private static void createCleaver(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aCleaver");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+26");
        lore.add("§7Critical Damage: §c+10");
        lore.add("§7Critical Chance: §c+8");
        lore.add("");
        lore.add("§6Item Ability: Cleave");
        lore.add("§7You deal §a70% §7damage to all monsters");
        lore.add("§7around as long as you have mana.");
        lore.add("§8Mana Cost: §335");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        cleaver = item;
        customItems.add("§aCleaver");
    }

    private static void createUndeadSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aUndead Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+24");
        lore.add("§7Critical Damage: §c+5");
        lore.add("");
        lore.add("§6Item Ability: Undead Slayer");
        lore.add("§7You deal §a190% §7damage to all undead");
        lore.add("§7monsters.");
        lore.add("");
        lore.add("§a§lUNCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        undeadSword = item;
        customItems.add("§aUndead Sword");
    }

    private static void createHealingStaff(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aHealing Staff");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+1");
        lore.add("");
        lore.add("§6Item Ability: Medium Heal §eRIGHT CLICK");
        lore.add("§7Gives you regeneration for §a5s.");
        lore.add("§8Mana Cost: §340");
        lore.add("§8Cooldown: §a18s");
        lore.add("");
        lore.add("§aUNCOMMON WAND");

        meta.setLore(lore);
        item.setItemMeta(meta);
        healingStaff = item;
        customItems.add("§aHealing Staff");
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
        lore.add("§8Cooldown: §a20s");
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
        lore.add("§7You deal §a150% §7damage to all undead");
        lore.add("§7monsters.");
        lore.add("");
        lore.add("§f§lCOMMON SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        silverSword = item;
        customItems.add("§fSilver Sword");
    }
    private static void createSilver(){
        ItemStack item = new ItemStack(Material.IRON_NUGGET, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSilver");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§f§lCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        silver = item;
    }
    private static void createEnchBone(){
        ItemStack item = new ItemStack(Material.BONE, 1);
        item.addEnchantment(glow, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aEnchanted Bone");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();

        lore.add("§a§lUNCOMMON ITEM");

        meta.setLore(lore);
        item.setItemMeta(meta);
        enchBone = item;
    }
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

        lore.add("§7Damage: §c+28");
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
        private static void createEnderSword(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dEnder Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("§7Damage: §c+20");
        lore.add("§7Critical Damage: §c+10");
        lore.add("");
        lore.add("§6Item Ability: End enchanced");
        lore.add("§7You can teleport randomly");
        lore.add("§7On Right Click");
        lore.add("§d§lMythic SWORD");
        meta.setLore(lore);
        item.setItemMeta(meta);
        EnderSword= item;
        customItems.add("§fEndSword Sword");
    }

    public static ItemStats getItemStats(ItemStack item){
        if (item.getItemMeta() == null || item.getItemMeta().getLore() == null){
            return new ItemStats(1.0, 0.0,0.0,0.0,0.0, 0.0, 0.0, 0.0, 0.0);
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
                    String[] ss = s.split("§c");
                    damage = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Intelligence: ")){
                    String[] ss = s.split("§b");
                    intelligence = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Health: ")){
                    String[] ss = s.split("§4");
                    health = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Defense: ")){
                    String[] ss = s.split("§a");
                    defense = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Ability Damage: ")){
                    String[] ss = s.split("§3");
                    abilityPower = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Critical Chance: ")){
                    String[] ss = s.split("§c");
                    critChance = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Critical Damage: ")){
                    String[] ss = s.split("§c");
                    critDamage = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Resistance: ")){
                    String[] ss = s.split("§3");
                    resistance = Double.parseDouble(ss[1]);
                }
                if (s.contains("§7Speed: ")){
                    String[] ss = s.split("§f");
                    speed = Double.parseDouble(ss[1]);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return new ItemStats(damage, intelligence, health, defense, abilityPower, critDamage, critChance, resistance, speed);
    }

    private static ItemStack getSkull(String base64) {
        return SkullCreator.itemFromBase64(base64);
    }
}
