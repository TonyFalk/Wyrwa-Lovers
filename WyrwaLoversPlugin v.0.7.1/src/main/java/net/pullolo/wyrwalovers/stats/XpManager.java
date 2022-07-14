package net.pullolo.wyrwalovers.stats;

import net.pullolo.wyrwalovers.display.Scoreboards;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.Main.*;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static net.pullolo.wyrwalovers.stats.Stats.xpMap;

public class XpManager extends BukkitRunnable {
    @Override
    public void run() {
        for (Player p: Bukkit.getOnlinePlayers()){
            if (xpMap.get(p)!=null){
                if (xpMap.get(p).getXp() >= getAmountToLevelUp(p)){
                    levelUp(p);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + "&7Level Up, your level is now: &c" + entityMap.get(p).getLevel()));
                    if (econ!=null){
                        econ.depositPlayer(p, 1000*entityMap.get(p).getLevel());
                        p.sendMessage( ChatColor.GREEN + "+ " + 1000*entityMap.get(p).getLevel() + " coins!");
                        scoreboards.showAddCoins(p, 1000*entityMap.get(p).getLevel());
                    }
                }
            }
        }
    }

    public void levelUp(Player p){
        if (entityMap.get(p)!=null){
            entityMap.get(p).setLevel(entityMap.get(p).getLevel()+1);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2);
        }
    }

    public double getAmountToLevelUp(Player p){
        double amount = 0;
        if (entityMap.get(p)!=null && xpMap.get(p)!=null){
            int level = entityMap.get(p).getLevel();
            amount = Math.pow(1.3, level)*423;
        }

        return amount;
    }
}
