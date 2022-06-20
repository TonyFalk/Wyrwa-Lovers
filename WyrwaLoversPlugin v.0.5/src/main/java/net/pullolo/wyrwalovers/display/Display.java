package net.pullolo.wyrwalovers.display;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.pullolo.wyrwalovers.entities.converters.EntityConverter;
import net.pullolo.wyrwalovers.stats.Stats;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Display extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e: EntityConverter.entities) {
            if (e != null){
                if (e instanceof Player){
                    Player p = (Player) e;
                    try{
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + Math.round(Stats.entityMap.get(p).getHealth()) + "/" + Math.round(Stats.entityMap.get(p).getMaxHealth())
                                + "❤     §a" + Math.round(Stats.entityMap.get(p).getDefense()) + "❈ Defense    §b" + Math.round(Stats.entityMap.get(p).getMana())
                                + "/" + Math.round(Stats.entityMap.get(p).getMaxMana()) + "✎ Mana"));
                    } catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}
