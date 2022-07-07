package net.pullolo.wyrwalovers.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.wyrwalovers.items.Items.*;
import static org.bukkit.Bukkit.getServer;

public class GiveCustomItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("giveitem")){
            if (args.length > 1){
                Player target = getServer().getPlayer(args[0]);
                if(target == null){
                    sender.sendMessage(ChatColor.RED + "This player is not online!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("list")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent(ChatColor.GRAY + "List 1");
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto show the list!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " list1")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent(ChatColor.GRAY + "List 2");
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto show the list!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " list2")));
                    target.spigot().sendMessage(m2);

                    TextComponent m3 = new TextComponent(ChatColor.GRAY + "List 3");
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto show the list!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " list3")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent(ChatColor.GRAY + "List 4");
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto show the list!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " list4")));
                    target.spigot().sendMessage(m4);

                    TextComponent m5 = new TextComponent(ChatColor.GRAY + "List 5");
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto show the list!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " list5")));
                    target.spigot().sendMessage(m5);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list1")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent ms2 = new TextComponent(silver.getItemMeta().getDisplayName());
                    ms2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " silver")));
                    target.spigot().sendMessage(ms2);

                    TextComponent m1 = new TextComponent(enchDiamond.getItemMeta().getDisplayName());
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchDiamond")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent(enchIron.getItemMeta().getDisplayName());
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchIron")));
                    target.spigot().sendMessage(m2);

                    TextComponent ms1 = new TextComponent(enchBone.getItemMeta().getDisplayName());
                    ms1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchbone")));
                    target.spigot().sendMessage(ms1);

                    //todo start

                    TextComponent ms10 = new TextComponent(enchCoal.getItemMeta().getDisplayName());
                    ms10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchcoal")));
                    target.spigot().sendMessage(ms10);

                    TextComponent ms9 = new TextComponent(enchGold.getItemMeta().getDisplayName());
                    ms9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchgold")));
                    target.spigot().sendMessage(ms9);

                    TextComponent ms8 = new TextComponent(enchGunPowder.getItemMeta().getDisplayName());
                    ms8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchgp")));
                    target.spigot().sendMessage(ms8);

                    TextComponent ms7 = new TextComponent(enchString.getItemMeta().getDisplayName());
                    ms7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchstring")));
                    target.spigot().sendMessage(ms7);

                    TextComponent ms6 = new TextComponent(enchLapis.getItemMeta().getDisplayName());
                    ms6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchlapis")));
                    target.spigot().sendMessage(ms6);

                    TextComponent ms5 = new TextComponent(enchRottenFlesh.getItemMeta().getDisplayName());
                    ms5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchrf")));
                    target.spigot().sendMessage(ms5);

                    TextComponent ms4 = new TextComponent(enchEnderPearl.getItemMeta().getDisplayName());
                    ms4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchep")));
                    target.spigot().sendMessage(ms4);

                    TextComponent ms3 = new TextComponent(enchSlime.getItemMeta().getDisplayName());
                    ms3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchslime")));
                    target.spigot().sendMessage(ms3);

                    TextComponent ms11 = new TextComponent(enchFeather.getItemMeta().getDisplayName());
                    ms11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms11.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchfeather")));
                    target.spigot().sendMessage(ms11);

                    //stop

                    TextComponent m3 = new TextComponent(woodenSword.getItemMeta().getDisplayName());
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " woodensword")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent(stoneSword.getItemMeta().getDisplayName());
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " stonesword")));
                    target.spigot().sendMessage(m4);

                    TextComponent m5 = new TextComponent(goldSword.getItemMeta().getDisplayName());
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " goldsword")));
                    target.spigot().sendMessage(m5);

                    TextComponent m6 = new TextComponent(ironSword.getItemMeta().getDisplayName());
                    m6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " ironsword")));
                    target.spigot().sendMessage(m6);

                    TextComponent m7 = new TextComponent(diamondSword.getItemMeta().getDisplayName());
                    m7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " diamondsword")));
                    target.spigot().sendMessage(m7);

                    TextComponent m8 = new TextComponent(netheriteSword.getItemMeta().getDisplayName());
                    m8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " netheritesword")));
                    target.spigot().sendMessage(m8);

                    TextComponent m9 = new TextComponent(bow.getItemMeta().getDisplayName());
                    m9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " bow")));
                    target.spigot().sendMessage(m9);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list2")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent(boneSword.getItemMeta().getDisplayName());
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " bonesword")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent(silverSword.getItemMeta().getDisplayName());
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " silversword")));
                    target.spigot().sendMessage(m2);

                    TextComponent m3 = new TextComponent(steelSword.getItemMeta().getDisplayName());
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " steelsword")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent(healingWand.getItemMeta().getDisplayName());
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " healingwand")));
                    target.spigot().sendMessage(m4);

                    TextComponent ms1 = new TextComponent(heavyShield.getItemMeta().getDisplayName());
                    ms1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " hshield")));
                    target.spigot().sendMessage(ms1);

                    TextComponent ms2 = new TextComponent(witchStaff.getItemMeta().getDisplayName());
                    ms2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " wstaff")));
                    target.spigot().sendMessage(ms2);

                    TextComponent m5 = new TextComponent(healingStaff.getItemMeta().getDisplayName());
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " healingstaff")));
                    target.spigot().sendMessage(m5);

                    TextComponent m6 = new TextComponent(undeadSword.getItemMeta().getDisplayName());
                    m6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " undeadsword")));
                    target.spigot().sendMessage(m6);

                    TextComponent m7 = new TextComponent(cleaver.getItemMeta().getDisplayName());
                    m7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " cleaver")));
                    target.spigot().sendMessage(m7);

                    TextComponent m8 = new TextComponent(slimeSword.getItemMeta().getDisplayName());
                    m8.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m8.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " slimesword")));
                    target.spigot().sendMessage(m8);

                    TextComponent m9 = new TextComponent(golemSword.getItemMeta().getDisplayName());
                    m9.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m9.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " golemsword")));
                    target.spigot().sendMessage(m9);

                    TextComponent m10 = new TextComponent(grapplingHook.getItemMeta().getDisplayName());
                    m10.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m10.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " ghook")));
                    target.spigot().sendMessage(m10);

                    TextComponent m11 = new TextComponent(flingingSword.getItemMeta().getDisplayName());
                    m11.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m11.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " fsword")));
                    target.spigot().sendMessage(m11);

                    TextComponent m12 = new TextComponent(heavySword.getItemMeta().getDisplayName());
                    m12.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m12.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " hsword")));
                    target.spigot().sendMessage(m12);

                    TextComponent m13 = new TextComponent(berserkerAxe.getItemMeta().getDisplayName());
                    m13.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m13.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " baxe")));
                    target.spigot().sendMessage(m13);

                    TextComponent m14 = new TextComponent(heavyChestplate.getItemMeta().getDisplayName());
                    m14.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m14.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " hchest")));
                    target.spigot().sendMessage(m14);

                    TextComponent m15 = new TextComponent(pullingBow.getItemMeta().getDisplayName());
                    m15.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m15.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " pbow")));
                    target.spigot().sendMessage(m15);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list3")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent(aspectOfEnd.getItemMeta().getDisplayName());
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " aspectofend")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent(flamingBow.getItemMeta().getDisplayName());
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " flamebow")));
                    target.spigot().sendMessage(m2);

                    TextComponent m3 = new TextComponent(fieryCore.getItemMeta().getDisplayName());
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " fierycore")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent(tpCore.getItemMeta().getDisplayName());
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " tpcore")));
                    target.spigot().sendMessage(m4);

                    TextComponent m5 = new TextComponent(moltenBlade.getItemMeta().getDisplayName());
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " moltenblade")));
                    target.spigot().sendMessage(m5);

                    TextComponent m6 = new TextComponent(emberRod.getItemMeta().getDisplayName());
                    m6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " embrod")));
                    target.spigot().sendMessage(m6);

                    TextComponent m7 = new TextComponent(hurricaneBow.getItemMeta().getDisplayName());
                    m7.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m7.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " hcbow")));
                    target.spigot().sendMessage(m7);

                    TextComponent ms1 = new TextComponent(brutalityBlade.getItemMeta().getDisplayName());
                    ms1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " brutalityblade")));
                    target.spigot().sendMessage(ms1);

                    TextComponent ms2 = new TextComponent(leapingSword.getItemMeta().getDisplayName());
                    ms2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " leapingsword")));
                    target.spigot().sendMessage(ms2);

                    TextComponent ms3 = new TextComponent(midasPickaxe.getItemMeta().getDisplayName());
                    ms3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    ms3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " midaspick")));
                    target.spigot().sendMessage(ms3);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list4")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent(shadowGoggles.getItemMeta().getDisplayName());
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " shadowgoggles")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent("§9Angel Armour");
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " angelarmor")));
                    target.spigot().sendMessage(m2);

                    TextComponent m3 = new TextComponent("§5Shadow Assassin Armour");
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " shadowaarmor")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent("§5Lunar Armour (Day)");
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " lunararmor")));
                    target.spigot().sendMessage(m4);

                    TextComponent m5 = new TextComponent("§5Lunar Armour (Night)");
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " lunararmorn")));
                    target.spigot().sendMessage(m5);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list5")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent("§fLeather Armour");
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " leatherarmor")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent("§fChainmail Armour");
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " chainmailarmor")));
                    target.spigot().sendMessage(m2);

                    TextComponent m3 = new TextComponent("§fIron Armour");
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " ironarmor")));
                    target.spigot().sendMessage(m3);

                    TextComponent m4 = new TextComponent("§fGolden Armour");
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " goldenarmor")));
                    target.spigot().sendMessage(m4);

                    TextComponent m5 = new TextComponent("§aDiamond Armour");
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " diamondarmor")));
                    target.spigot().sendMessage(m5);

                    TextComponent m6 = new TextComponent("§aNetherite Armour");
                    m6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " netheritearmor")));
                    target.spigot().sendMessage(m6);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("enchdiamond")){
                    target.getInventory().addItem(enchDiamond);
                }
                if (args[1].equalsIgnoreCase("enchiron")){
                    target.getInventory().addItem(enchIron);
                }
                if (args[1].equalsIgnoreCase("enchbone")){
                    target.getInventory().addItem(enchBone);
                }
                if (args[1].equalsIgnoreCase("silver")){
                    target.getInventory().addItem(silver);
                }
                if (args[1].equalsIgnoreCase("enchcoal")){
                    target.getInventory().addItem(enchCoal);
                }
                if (args[1].equalsIgnoreCase("enchgold")){
                    target.getInventory().addItem(enchGold);
                }
                if (args[1].equalsIgnoreCase("enchgp")){
                    target.getInventory().addItem(enchGunPowder);
                }
                if (args[1].equalsIgnoreCase("enchstring")){
                    target.getInventory().addItem(enchString);
                }
                if (args[1].equalsIgnoreCase("enchlapis")){
                    target.getInventory().addItem(enchLapis);
                }
                if (args[1].equalsIgnoreCase("enchrf")){
                    target.getInventory().addItem(enchRottenFlesh);
                }
                if (args[1].equalsIgnoreCase("enchep")){
                    target.getInventory().addItem(enchEnderPearl);
                }
                if (args[1].equalsIgnoreCase("enchslime")){
                    target.getInventory().addItem(enchSlime);
                }
                if (args[1].equalsIgnoreCase("enchfeather")){
                    target.getInventory().addItem(enchFeather);
                }
                if (args[1].equalsIgnoreCase("woodensword")){
                    target.getInventory().addItem(woodenSword);
                }
                if (args[1].equalsIgnoreCase("stonesword")){
                    target.getInventory().addItem(stoneSword);
                }
                if (args[1].equalsIgnoreCase("goldsword")){
                    target.getInventory().addItem(goldSword);
                }
                if (args[1].equalsIgnoreCase("ironsword")){
                    target.getInventory().addItem(ironSword);
                }
                if (args[1].equalsIgnoreCase("diamondsword")){
                    target.getInventory().addItem(diamondSword);
                }
                if (args[1].equalsIgnoreCase("netheritesword")){
                    target.getInventory().addItem(netheriteSword);
                }
                if (args[1].equalsIgnoreCase("bow")){
                    target.getInventory().addItem(bow);
                }
                if (args[1].equalsIgnoreCase("bonesword")){
                    target.getInventory().addItem(boneSword);
                }
                if (args[1].equalsIgnoreCase("steelsword")){
                    target.getInventory().addItem(steelSword);
                }
                if (args[1].equalsIgnoreCase("silversword")){
                    target.getInventory().addItem(silverSword);
                }
                if (args[1].equalsIgnoreCase("healingwand")){
                    target.getInventory().addItem(healingWand);
                }
                if (args[1].equalsIgnoreCase("wstaff")){
                    target.getInventory().addItem(witchStaff);
                }
                if (args[1].equalsIgnoreCase("hshield")){
                    target.getInventory().addItem(heavyShield);
                }
                if (args[1].equalsIgnoreCase("healingstaff")){
                    target.getInventory().addItem(healingStaff);
                }
                if (args[1].equalsIgnoreCase("undeadsword")){
                    target.getInventory().addItem(undeadSword);
                }
                if (args[1].equalsIgnoreCase("cleaver")){
                    target.getInventory().addItem(cleaver);
                }
                if (args[1].equalsIgnoreCase("slimesword")){
                    target.getInventory().addItem(slimeSword);
                }
                if (args[1].equalsIgnoreCase("golemsword")){
                    target.getInventory().addItem(golemSword);
                }
                if (args[1].equalsIgnoreCase("ghook")){
                    target.getInventory().addItem(grapplingHook);
                }
                if (args[1].equalsIgnoreCase("fsword")){
                    target.getInventory().addItem(flingingSword);
                }
                if (args[1].equalsIgnoreCase("hsword")){
                    target.getInventory().addItem(heavySword);
                }
                if (args[1].equalsIgnoreCase("baxe")){
                    target.getInventory().addItem(berserkerAxe);
                }
                if (args[1].equalsIgnoreCase("pbow")){
                    target.getInventory().addItem(pullingBow);
                }
                if (args[1].equalsIgnoreCase("aspectofend")){
                    target.getInventory().addItem(aspectOfEnd);
                }
                if (args[1].equalsIgnoreCase("flamebow")){
                    target.getInventory().addItem(flamingBow);
                }
                if (args[1].equalsIgnoreCase("leapingsword")){
                    target.getInventory().addItem(leapingSword);
                }
                if (args[1].equalsIgnoreCase("brutalityblade")){
                    target.getInventory().addItem(brutalityBlade);
                }
                if (args[1].equalsIgnoreCase("aspectofdragons")){
                    target.getInventory().addItem(aspectOfDragons);
                }
                if (args[1].equalsIgnoreCase("hyperion")){
                    target.getInventory().addItem(hyperion);
                }
                if (args[1].equalsIgnoreCase("shadowgoggles")){
                    target.getInventory().addItem(shadowGoggles);
                }
                if (args[1].equalsIgnoreCase("hchest")){
                    target.getInventory().addItem(heavyChestplate);
                }
                if (args[1].equalsIgnoreCase("fierycore")){
                    target.getInventory().addItem(fieryCore);
                }
                if (args[1].equalsIgnoreCase("tpcore")){
                    target.getInventory().addItem(tpCore);
                }
                if (args[1].equalsIgnoreCase("moltenblade")){
                    target.getInventory().addItem(moltenBlade);
                }
                if (args[1].equalsIgnoreCase("embrod")){
                    target.getInventory().addItem(emberRod);
                }
                if (args[1].equalsIgnoreCase("midaspick")){
                    target.getInventory().addItem(midasPickaxe);
                }
                if (args[1].equalsIgnoreCase("hcbow")){
                    target.getInventory().addItem(hurricaneBow);
                }
                if (args[1].equalsIgnoreCase("angelarmor")){
                    target.getInventory().addItem(angelHelmet);
                    target.getInventory().addItem(angelChestplate);
                    target.getInventory().addItem(angelLeggings);
                    target.getInventory().addItem(angelBoots);
                }
                if (args[1].equalsIgnoreCase("shadowaarmor")){
                    target.getInventory().addItem(shadowAssassinHelmet);
                    target.getInventory().addItem(shadowAssassinChestplate);
                    target.getInventory().addItem(shadowAssassinLeggings);
                    target.getInventory().addItem(shadowAssassinBoots);
                }
                if (args[1].equalsIgnoreCase("leatherarmor")){
                    target.getInventory().addItem(leatherHelmet);
                    target.getInventory().addItem(leatherChestplate);
                    target.getInventory().addItem(leatherLeggings);
                    target.getInventory().addItem(leatherBoots);
                }
                if (args[1].equalsIgnoreCase("chainmailarmor")){
                    target.getInventory().addItem(chainmailHelmet);
                    target.getInventory().addItem(chainmailChestplate);
                    target.getInventory().addItem(chainmailLeggings);
                    target.getInventory().addItem(chainmailBoots);
                }
                if (args[1].equalsIgnoreCase("ironarmor")){
                    target.getInventory().addItem(ironHelmet);
                    target.getInventory().addItem(ironChestplate);
                    target.getInventory().addItem(ironLeggings);
                    target.getInventory().addItem(ironBoots);
                }
                if (args[1].equalsIgnoreCase("goldenarmor")){
                    target.getInventory().addItem(goldHelmet);
                    target.getInventory().addItem(goldChestplate);
                    target.getInventory().addItem(goldLeggings);
                    target.getInventory().addItem(goldBoots);
                }
                if (args[1].equalsIgnoreCase("diamondarmor")){
                    target.getInventory().addItem(diamondHelmet);
                    target.getInventory().addItem(diamondChestplate);
                    target.getInventory().addItem(diamondLeggings);
                    target.getInventory().addItem(diamondBoots);
                }
                if (args[1].equalsIgnoreCase("netheritearmor")){
                    target.getInventory().addItem(netheriteHelmet);
                    target.getInventory().addItem(netheriteChestplate);
                    target.getInventory().addItem(netheriteLeggings);
                    target.getInventory().addItem(netheriteBoots);
                }
                if (args[1].equalsIgnoreCase("lunararmor")){
                    target.getInventory().addItem(lunarHelmetDay);
                    target.getInventory().addItem(lunarChestplateDay);
                    target.getInventory().addItem(lunarleggingsDay);
                    target.getInventory().addItem(lunarBootsDay);
                }
                if (args[1].equalsIgnoreCase("lunararmorn")){
                    target.getInventory().addItem(lunarHelmetNight);
                    target.getInventory().addItem(lunarChestplateNight);
                    target.getInventory().addItem(lunarLeggingsNight);
                    target.getInventory().addItem(lunarBootsNight);
                }
                //TODO add if statements for items
            }
            else {
                sender.sendMessage(ChatColor.RED + "Usage: /<command> <player> <args>");
            }
        }
        return true;
    }
}
