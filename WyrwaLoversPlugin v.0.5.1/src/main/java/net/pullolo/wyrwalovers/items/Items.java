package net.pullolo.wyrwalovers.items;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

import static net.pullolo.wyrwalovers.Main.glow;

public class Items {
    public static ArrayList<String> customItems = new ArrayList<>();
    public static ArrayList<String> customArmorItems = new ArrayList<>();

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
    public static ItemStack iceWand;
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

    public static ItemStack angelHelmet;
    public static ItemStack angelChestplate;
    public static ItemStack angelLeggings;
    public static ItemStack angelBoots;

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
        createHealingStaff();
        createUndeadSword();
        createCleaver();
        createSlimeSword();
        createGolemSword();

        createAspectOfEnd();
        createFlamingBow();
        createLeapingSword();

        createAspectOfDragons();
        createHyperion();

        createAngelArmor();
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
        lore.add("§5EPIC SWORD");

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
        lore.add("§6LEGENDARY SWORD");

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
        lore.add("§9RARE SWORD");

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
        lore.add("§dMYTHIC SWORD");

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
        lore.add("§6Item Ability: Iron Punch");
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

        lore1.add("§7Defense: §a+20");
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

        lore2.add("§7Defense: §a+50");
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

        lore3.add("§7Defense: §a+40");
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

        lore4.add("§7Defense: §a+30");
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

    private static ItemStack getSkull(String base64) {
        return SkullCreator.itemFromBase64(base64);
    }
}
