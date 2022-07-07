package net.pullolo.wyrwalovers;

import net.milkbowl.vault.economy.Economy;
import net.pullolo.wyrwalovers.commands.*;
import net.pullolo.wyrwalovers.datastorage.DbManager;
import net.pullolo.wyrwalovers.display.Display;
import net.pullolo.wyrwalovers.display.Scoreboards;
import net.pullolo.wyrwalovers.entities.converters.EntityConverter;
import net.pullolo.wyrwalovers.entities.events.EntityListener;
import net.pullolo.wyrwalovers.entities.events.RareDropManager;
import net.pullolo.wyrwalovers.events.OnJoin;
import net.pullolo.wyrwalovers.handlers.ArmourHandler;
import net.pullolo.wyrwalovers.handlers.ItemHandler;
import net.pullolo.wyrwalovers.handlers.PlayerHandler;
import net.pullolo.wyrwalovers.items.Items;
import net.pullolo.wyrwalovers.misc.CooldownAPI;
import net.pullolo.wyrwalovers.misc.EverySecondClock;
import net.pullolo.wyrwalovers.misc.Glow;
import net.pullolo.wyrwalovers.stats.entities.EntityAttributes;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.logging.Logger;

import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.handlers.ArmourHandler.playerAttributes;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public final class Main extends JavaPlugin {

    public static FileConfiguration config;
    private static final Logger log = Logger.getLogger("Minecraft");
    public static DbManager dbManager = new DbManager();
    public static final String prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Wyrwa" + ChatColor.DARK_GRAY +"Lovers" + ChatColor.GRAY +"] ";
    public static Plugin plugin;
    public static Glow glow;
    public static Economy econ;

    @Override
    public void onEnable() {
        plugin = this;
        dbManager.init();
        saveDefaultConfig();
        config = getConfig();
        registerGlow();
        Items.init();
        createCooldowns();
        doubleJumpRegisterer(true);

        //Initialize commands
        getCommand("giveitem").setExecutor(new GiveCustomItems());
        getCommand("set").setExecutor(new Set());
        getCommand("heal").setExecutor(new Heal());
        getCommand("stats").setExecutor(new Stats());
        getCommand("time").setExecutor(new Time());
        getCommand("ehp").setExecutor(new Ehp());
        getCommand("invis").setExecutor(new Invis());

        //Initialize eventListeners
        ArmourHandler ah = new ArmourHandler();
        ItemHandler ih = new ItemHandler();
        Scoreboards scoreboards = new Scoreboards(prefix);
        getServer().getPluginManager().registerEvents(scoreboards, this);
        getServer().getPluginManager().registerEvents(ih, this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHandler(), this);
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(ah, this);
        getServer().getPluginManager().registerEvents(new RareDropManager(), this);

        //Initialize clocks
        scoreboards.runTaskTimer(this, 0, 20);
        new EntityConverter().runTaskTimer(this, 0, 1);
        ah.runTaskTimer(this, 0 , 1);
        new Display().runTaskTimer(this, 0, 2);
        new EverySecondClock().runTaskTimer(this, 0, 20);
        ih.runTaskTimer(this, 0, 1);

        setupVault();
        getServer().getConsoleSender().sendMessage(prefix + "Plugin Enabled!");
        if (dbManager.isDbEnabled()){
            log.info("[WyrwaLovers] " + "Database is enabled!");
        } else {
            log.warning("[WyrwaLovers] " + "Database is not loaded which may cause some issues!");
        }

        loadStatsOfOnlinePlayers();
    }

    @Override
    public void onDisable() {
        doubleJumpRegisterer(false);
        getServer().getConsoleSender().sendMessage(prefix + "Plugin Disabled!");
        for (Entity e:entities){
            if (!(e instanceof Player)) {
                e.setCustomName(entityMap.get(e).getName());
                e.setCustomNameVisible(false);
            } else {
                Player player = (Player) e;
                if (dbManager.isPlayerInDb(player.getName())){
                    dbManager.updatePlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue());
                }
            }
        }
        for (World w:getServer().getWorlds()){
            for (Entity e:w.getEntities()){
                if (e instanceof ArmorStand){
                    if (e.isCustomNameVisible()){
                        e.remove();
                    }
                }
            }
        }
    }

    private void doubleJumpRegisterer(boolean onEnable){
        if (onEnable){
            for (Player p : Bukkit.getOnlinePlayers()){
                playerAttributes.put(p, new EntityAttributes());
            }
        } else {
            for (Player p : Bukkit.getOnlinePlayers()){
                playerAttributes.remove(p);
            }
        }
    }

    private void createCooldowns(){
        //Todo reference CooldownAPI to init cooldowns for items
        CooldownAPI.createCooldown("HW", 20);
        CooldownAPI.createCooldown("HS", 18);
        CooldownAPI.createCooldown("AA", 40);
        CooldownAPI.createCooldown("SS", 5);
        CooldownAPI.createCooldown("LS", 10);
        CooldownAPI.createCooldown("AOD", 5);
        CooldownAPI.createCooldown("LA", 5);
        CooldownAPI.createCooldown("GH", 2);
        CooldownAPI.createCooldown("FS", 5);
        CooldownAPI.createCooldown("BA", 40);
    }

    private void registerGlow() {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            glow = new Glow(new NamespacedKey(this, this.getDescription().getName()));
            Enchantment.registerEnchantment(glow);
        } catch (IllegalArgumentException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadStatsOfOnlinePlayers(){
        for (Player player: Bukkit.getOnlinePlayers()){
            if (dbManager.isPlayerInDb(player.getName())){
                entityMap.put(player, dbManager.getPlayer(player.getName()));
                entities.add(player);
            } else {
                entityMap.put(player, new EntityStats(player, null));
                entities.add(player);
                dbManager.addPlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue());
            }
        }
    }

    private void setupVault(){
        if (!setupEconomy()){
            log.warning("You don't have Vault installed or main economy plugin installed!");
        }
    }

    private boolean setupEconomy() {
        //Todo add money and so on
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Logger get_Logger(){
        return log;
    }
}
