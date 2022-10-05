package me.dark.merchant.moderationcommandsgui.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class MainListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();



        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "Main Menu")) {

            Material item = e.getCurrentItem().getType();

            if (e.getCurrentItem() == null) {
                return;
            }

            if (item == Material.TOTEM_OF_UNDYING) {

                if (p.isInvulnerable()){
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God off");
                    e.getCurrentItem().removeEnchantment(Enchantment.MENDING);
                }else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "God on");
                    e.getCurrentItem().addUnsafeEnchantment(Enchantment.MENDING, 1);

                }

            }
            if (item == Material.FEATHER) {

                if (p.getAllowFlight()){
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.RED + "Fly off");
                    e.getCurrentItem().removeEnchantment(Enchantment.MENDING);
                }else {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "Fly on");
                    e.getCurrentItem().addUnsafeEnchantment(Enchantment.MENDING, 1);

                }

            }
            e.setCancelled(true);
        }
    }
}
