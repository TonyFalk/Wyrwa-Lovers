package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static net.pullolo.wyrwalovers.Main.dbManager;
import static net.pullolo.wyrwalovers.Main.plugin;
import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;

public class PlayerHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        //Todo load stats from db
        Player player = e.getPlayer();
        if (dbManager.isPlayerInDb(player.getName())){
            entityMap.put(player, dbManager.getPlayer(player.getName()));
            entities.add(player);
        } else {
            entityMap.put(player, new EntityStats(player, null));
            entities.add(player);
            dbManager.addPlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue());
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        //Todo save stats to db
        Player player = e.getPlayer();
        if (dbManager.isPlayerInDb(player.getName())){
            dbManager.updatePlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue());
        }
        entities.remove(e.getPlayer());
        entityMap.remove(e.getPlayer());
    }
}
