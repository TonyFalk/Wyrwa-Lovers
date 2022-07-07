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

public class Scoreboards extends BukkitRunnable implements Listener {
    private final JPerPlayerMethodBasedScoreboard scoreboard;
    private final String title;
    //Todo idk guess you'll have to find out

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
