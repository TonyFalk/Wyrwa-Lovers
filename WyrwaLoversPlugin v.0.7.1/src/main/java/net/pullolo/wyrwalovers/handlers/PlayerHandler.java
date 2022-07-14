package net.pullolo.wyrwalovers.handlers;

import net.pullolo.wyrwalovers.stats.entities.EntityAttributes;
import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import net.pullolo.wyrwalovers.stats.entities.PlayerXp;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static net.pullolo.wyrwalovers.Main.dbManager;
import static net.pullolo.wyrwalovers.entities.converters.EntityConverter.entities;
import static net.pullolo.wyrwalovers.handlers.ArmourHandler.playerAttributes;
import static net.pullolo.wyrwalovers.stats.Stats.entityMap;
import static net.pullolo.wyrwalovers.stats.Stats.xpMap;

public class PlayerHandler implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        //Todo load stats from db
        Player player = e.getPlayer();
        if (dbManager.isPlayerInDb(player.getName())){
            entityMap.put(player, dbManager.getPlayer(player.getName()));
            entities.add(player);
            xpMap.put(player, dbManager.getPlayerXp(player.getName()));
        } else {
            entityMap.put(player, new EntityStats(player, null));
            entities.add(player);
            xpMap.put(player, new PlayerXp(0));
            dbManager.addPlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue(), xpMap.get(player).getXp());
        }
        playerAttributes.put(player, new EntityAttributes());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e){
        //Todo save stats to db
        Player player = e.getPlayer();
        if (dbManager.isPlayerInDb(player.getName())){
            dbManager.updatePlayer(player.getName(), entityMap.get(player).getLevel(), entityMap.get(player).getHealth().intValue(), entityMap.get(player).getMana().intValue(), xpMap.get(player).getXp());
        }
        entities.remove(e.getPlayer());
        entityMap.remove(e.getPlayer());
        xpMap.remove(e.getPlayer());
        playerAttributes.remove(player);
    }
}
