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

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list1")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");
                    TextComponent m1 = new TextComponent(enchDiamond.getItemMeta().getDisplayName());
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchDiamond")));
                    target.spigot().sendMessage(m1);

                    TextComponent m2 = new TextComponent(enchIron.getItemMeta().getDisplayName());
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the item!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " enchIron")));
                    target.spigot().sendMessage(m2);

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

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("list4")){
                    target.sendMessage(ChatColor.GRAY + "------------" + ChatColor.WHITE + "Items List" + ChatColor.GRAY + "-----------");

                    TextComponent m1 = new TextComponent("§9Angel Armour");
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("§e§lClick §eto get the items!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " angelarmor")));
                    target.spigot().sendMessage(m1);

                    target.sendMessage(ChatColor.GRAY + "-------------------------------");
                }
                if (args[1].equalsIgnoreCase("enchdiamond")){
                    target.getInventory().addItem(enchDiamond);
                }
                if (args[1].equalsIgnoreCase("enchiron")){
                    target.getInventory().addItem(enchIron);
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
                if (args[1].equalsIgnoreCase("aspectofend")){
                    target.getInventory().addItem(aspectOfEnd);
                }
                if (args[1].equalsIgnoreCase("flamebow")){
                    target.getInventory().addItem(flamingBow);
                }
                if (args[1].equalsIgnoreCase("leapingsword")){
                    target.getInventory().addItem(leapingSword);
                }
                if (args[1].equalsIgnoreCase("aspectofdragons")){
                    target.getInventory().addItem(aspectOfDragons);
                }
                if (args[1].equalsIgnoreCase("hyperion")){
                    target.getInventory().addItem(hyperion);
                }
                if (args[1].equalsIgnoreCase("angelarmor")){
                    target.getInventory().addItem(angelHelmet);
                    target.getInventory().addItem(angelChestplate);
                    target.getInventory().addItem(angelLeggings);
                    target.getInventory().addItem(angelBoots);
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
