package net.pullolo.wyrwalovers.display;

import dev.jcsoftware.jscoreboards.JPerPlayerMethodBasedScoreboard;
import net.pullolo.wyrwalovers.misc.TimeHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static net.pullolo.wyrwalovers.Main.econ;
import static net.pullolo.wyrwalovers.Main.xpManager;
import static net.pullolo.wyrwalovers.stats.Stats.xpMap;

public class Scoreboards extends BukkitRunnable implements Listener {
    private final JPerPlayerMethodBasedScoreboard scoreboard;
    private final String title;

    public Scoreboards(String title){
        this.title = title;
        scoreboard = new JPerPlayerMethodBasedScoreboard();
        for (Player p: Bukkit.getOnlinePlayers()) {
            addToScoreBoard(p);
        }
    }


    @Override
    public void run() {
        for (Player p: Bukkit.getOnlinePlayers()){
            setContent(p);
            scoreboard.updateScoreboard();
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        addToScoreBoard(e.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        scoreboard.removePlayer(e.getPlayer());
    }

    public void addToScoreBoard(Player p){
        scoreboard.addPlayer(p);
        setContent(p);
        scoreboard.updateScoreboard();
    }

    public JPerPlayerMethodBasedScoreboard getScoreboard() {
        return scoreboard;
    }

    public void setContent(Player p){
        scoreboard.setTitle(p, title);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String timeSymbol;

        ArrayList<String> text = new ArrayList<>();
        text.add(ChatColor.translateAlternateColorCodes('&', "&7" + format.format(date)));
        text.add("");

        if (TimeHandler.isDay(p.getWorld())){
            timeSymbol = ChatColor.translateAlternateColorCodes('&', "&e☀");
        } else timeSymbol = ChatColor.translateAlternateColorCodes('&', "&9☽");

        text.add(ChatColor.translateAlternateColorCodes('&', " &fTime: &7" + TimeHandler.getTime(p.getWorld()) + " " + timeSymbol));

        text.add(ChatColor.translateAlternateColorCodes('&', " &7⌖ &a" + getWorldName(p)));
        text.add("");
        DecimalFormat df = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.GERMAN));
        if (econ!=null){
            text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &6" + df.format(econ.getBalance(p))));
        } else text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &c" + "Loading..."));
        String xp = "";
        String ofXp = "";
        if (xpMap.get(p) != null){
            if (xpMap.get(p).getXp() >= 1000000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000000) + "B";
            } else if (xpMap.get(p).getXp() >= 1000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000) + "M";
            } else if (xpMap.get(p).getXp() >= 1000) xp = Math.round(xpMap.get(p).getXp()/1000) + "k";
            else xp = Math.round(xpMap.get(p).getXp()) + "";

            if (xpManager.getAmountToLevelUp(p) >= 1000000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000000) + "B";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000) + "M";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000) ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000) + "k";
            else ofXp = Math.round(xpManager.getAmountToLevelUp(p)) + "";
        } else{
            xp = "&cLoading...";
            ofXp = "&cLoading...";
        }

        text.add(ChatColor.translateAlternateColorCodes('&', "&fXP: &3" + xp + "&7/&3" + ofXp));

        text.add("");
        text.add(ChatColor.translateAlternateColorCodes('&', "&eepickastrona.ddns.net"));

        scoreboard.setLines(p, text);
    }

    public void showAddCoins(Player p, double coins){
        scoreboard.setTitle(p, title);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String timeSymbol;

        ArrayList<String> text = new ArrayList<>();
        text.add(ChatColor.translateAlternateColorCodes('&', "&7" + format.format(date)));
        text.add("");

        if (TimeHandler.isDay(p.getWorld())){
            timeSymbol = ChatColor.translateAlternateColorCodes('&', "&e☀");
        } else timeSymbol = ChatColor.translateAlternateColorCodes('&', "&9☽");

        text.add(ChatColor.translateAlternateColorCodes('&', " &fTime: &7" + TimeHandler.getTime(p.getWorld()) + " " + timeSymbol));

        text.add(ChatColor.translateAlternateColorCodes('&', " &7⌖ &a" + getWorldName(p)));
        text.add("");
        DecimalFormat df = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.GERMAN));

        String finalCoins = "";
        if (coins >= 1000000000){
            finalCoins = Math.round(coins/1000000000) + "B";
        } else if (coins >= 1000000){
            finalCoins = Math.round(coins/1000000) + "M";
        } else if (coins >= 1000) finalCoins = Math.round(coins/1000) + "k";
        else if (coins >= 1) finalCoins = Math.round(coins) + "";
        else finalCoins = coins + "";

        if (econ!=null){
            text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &6" + df.format(econ.getBalance(p)) + " &7(+" + finalCoins + ")"));
        } else text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &c" + "Loading..."));
        String xp = "";
        String ofXp = "";
        if (xpMap.get(p) != null){
            if (xpMap.get(p).getXp() >= 1000000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000000) + "B";
            } else if (xpMap.get(p).getXp() >= 1000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000) + "M";
            } else if (xpMap.get(p).getXp() >= 1000) xp = Math.round(xpMap.get(p).getXp()/1000) + "k";
            else xp = Math.round(xpMap.get(p).getXp()) + "";

            if (xpManager.getAmountToLevelUp(p) >= 1000000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000000) + "B";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000) + "M";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000) ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000) + "k";
            else ofXp = Math.round(xpManager.getAmountToLevelUp(p)) + "";
        } else{
            xp = "&cLoading...";
            ofXp = "&cLoading...";
        }

        text.add(ChatColor.translateAlternateColorCodes('&', "&fXP: &3" + xp + "&7/&3" + ofXp));

        text.add("");
        text.add(ChatColor.translateAlternateColorCodes('&', "&eepickastrona.ddns.net"));

        scoreboard.setLines(p, text);
    }

    public void showAddXp(Player p ,double exp){
        scoreboard.setTitle(p, title);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String timeSymbol;

        ArrayList<String> text = new ArrayList<>();
        text.add(ChatColor.translateAlternateColorCodes('&', "&7" + format.format(date)));
        text.add("");

        if (TimeHandler.isDay(p.getWorld())){
            timeSymbol = ChatColor.translateAlternateColorCodes('&', "&e☀");
        } else timeSymbol = ChatColor.translateAlternateColorCodes('&', "&9☽");

        text.add(ChatColor.translateAlternateColorCodes('&', " &fTime: &7" + TimeHandler.getTime(p.getWorld()) + " " + timeSymbol));

        text.add(ChatColor.translateAlternateColorCodes('&', " &7⌖ &a" + getWorldName(p)));
        text.add("");
        DecimalFormat df = new DecimalFormat("#,###.##", new DecimalFormatSymbols(Locale.GERMAN));
        if (econ!=null){
            text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &6" + df.format(econ.getBalance(p))));
        } else text.add(ChatColor.translateAlternateColorCodes('&', "&fPurse: &c" + "Loading..."));
        String xp = "";
        String ofXp = "";
        if (xpMap.get(p) != null){
            if (xpMap.get(p).getXp() >= 1000000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000000) + "B";
            } else if (xpMap.get(p).getXp() >= 1000000){
                xp = Math.round(xpMap.get(p).getXp()/1000000) + "M";
            } else if (xpMap.get(p).getXp() >= 1000) xp = Math.round(xpMap.get(p).getXp()/1000) + "k";
            else xp = Math.round(xpMap.get(p).getXp()) + "";

            if (xpManager.getAmountToLevelUp(p) >= 1000000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000000) + "B";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000000){
                ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000000) + "M";
            } else if (xpManager.getAmountToLevelUp(p) >= 1000) ofXp = Math.round(xpManager.getAmountToLevelUp(p)/1000) + "k";
            else ofXp = Math.round(xpManager.getAmountToLevelUp(p)) + "";
        } else{
            xp = "&cLoading...";
            ofXp = "&cLoading...";
        }

        String finalExp = "";
        if (exp >= 1000000000){
            finalExp = Math.round(exp/1000000000) + "B";
        } else if (exp >= 1000000){
            finalExp = Math.round(exp/1000000) + "M";
        } else if (exp >= 1000) finalExp = Math.round(exp/1000) + "k";
        else if (exp >= 1) finalExp = Math.round(exp) + "";
        else finalExp = exp + "";

        text.add(ChatColor.translateAlternateColorCodes('&', "&fXP: &3" + xp + "&7/&3" + ofXp + " &7(+" + finalExp + ")"));

        text.add("");
        text.add(ChatColor.translateAlternateColorCodes('&', "&eepickastrona.ddns.net"));

        scoreboard.setLines(p, text);
    }

    private String getWorldName(Player p){
        String name = "";
        if (p.getWorld().getName().endsWith("_nether")){
            name = ChatColor.translateAlternateColorCodes('&', "&cNether");
        }
        else if (p.getWorld().getName().endsWith("_end")){
            name = ChatColor.translateAlternateColorCodes('&', "&9End");
        }
        else {
            name = ChatColor.translateAlternateColorCodes('&', "&aOverworld");
        }
        return name;
    }
}
