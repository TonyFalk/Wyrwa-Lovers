package net.pullolo.wyrwalovers.stats;

import net.pullolo.wyrwalovers.stats.entities.EntityStats;
import net.pullolo.wyrwalovers.stats.entities.PlayerXp;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class Stats {
    public static HashMap<Entity, EntityStats> entityMap = new HashMap<>();
    public static HashMap<Player, PlayerXp> xpMap = new HashMap<>();
}
