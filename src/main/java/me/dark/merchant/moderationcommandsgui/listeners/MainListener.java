package me.dark.merchant.moderationcommandsgui.listeners;
import me.dark.merchant.moderationcommandsgui.ModerationCommandsGUI;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Objects;


public class MainListener implements Listener {

    private static ModerationCommandsGUI plugin;

    public static void injectPlugin(ModerationCommandsGUI p) {
        plugin = p;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        Material item = Objects.requireNonNull(e.getCurrentItem()).getType();


        String name = p.getName();




        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Main Menu")) {


            if (e.getCurrentItem() == null) {
                return;
            }

            switch (item){
                case TOTEM_OF_UNDYING:
                    if (p.isInvulnerable()){
                        p.setInvulnerable(false);
                        p.sendMessage(ChatColor.RED + "God off");
                        e.getCurrentItem().removeEnchantment(Enchantment.MENDING);

                        p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.G));
                    }else {
                        p.setInvulnerable(true);
                        p.sendMessage(ChatColor.GREEN + "God on");
                        e.getCurrentItem().addUnsafeEnchantment(Enchantment.MENDING, 1);

                        p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.C));

                    }
                    break;

                case FEATHER:
                    if (p.getAllowFlight()){
                        p.setAllowFlight(false);
                        p.sendMessage(ChatColor.RED + "Fly off");
                        e.getCurrentItem().removeEnchantment(Enchantment.MENDING);

                       p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.G));
                    }else {
                        p.setAllowFlight(true);
                        p.sendMessage(ChatColor.GREEN + "Fly on");
                        e.getCurrentItem().addUnsafeEnchantment(Enchantment.MENDING, 1);

                        p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.C));
                    }
                    break;
                case GHAST_TEAR:
                    if(plugin.invList.contains(p)){

                        for(Player people1 : Bukkit.getOnlinePlayers()){
                            people1.showPlayer(plugin, p);
                        }
                        plugin.invList.remove(p);
                        p.sendMessage(ChatColor.RED + "Vanish off");
                        Bukkit.broadcastMessage(ChatColor.YELLOW + name + " joined the game");
                        e.getCurrentItem().removeEnchantment(Enchantment.MENDING);

                        p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.G));

                    } else if(!plugin.invList.contains(p)){

                        for(Player people2 : Bukkit.getOnlinePlayers()){
                            people2.hidePlayer(plugin, p);
                        }
                        plugin.invList.add(p);
                        p.sendMessage(ChatColor.GREEN + "Vanish on");
                        Bukkit.broadcastMessage(ChatColor.YELLOW + name + " left the game");
                        e.getCurrentItem().addUnsafeEnchantment(Enchantment.MENDING, 1);

                        p.playNote(p.getEyeLocation(), Instrument.XYLOPHONE , Note.natural(1, Note.Tone.C));
                    }
                    break;

                default:

            }

            e.setCancelled(true);
        }
    }
}
