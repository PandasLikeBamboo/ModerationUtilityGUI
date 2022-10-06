package me.dark.merchant.moderationcommandsgui.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


public class MainGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;


        /*
        Inventory sizes:
        9 - 18 - 27 - 36 - 45 - 54
        */



        Inventory inventory = Bukkit.createInventory( p, 27, ChatColor.DARK_RED + "Main Menu");

        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemStack feather = new ItemStack(Material.FEATHER);
        ItemStack ghastTear = new ItemStack(Material.GHAST_TEAR);

        ItemStack tp = new ItemStack(Material.ARROW);

        ItemMeta totemMeta = totem.getItemMeta();
        ItemMeta fthMeta = feather.getItemMeta();
        ItemMeta tearMeta = ghastTear.getItemMeta();

        ItemMeta tpMeta = tp.getItemMeta();


        totemMeta.setDisplayName(ChatColor.GOLD + "God");
        fthMeta.setDisplayName(ChatColor.GRAY + "Fly");
        tearMeta.setDisplayName(ChatColor.RED + "Vanish");

        tpMeta.setDisplayName(ChatColor.GRAY + "Next Page");

        ArrayList<String> lore = new ArrayList<>();
        lore.add("-> teleport all to you");
        lore.add("-> soon");
        tpMeta.setLore(lore);


        if (p.isInvulnerable()) {
            totemMeta.addEnchant(Enchantment.MENDING, 1, true);
        } else if (p.getAllowFlight()) {
            fthMeta.addEnchant(Enchantment.MENDING, 1, true);
        }



        totem.setItemMeta(totemMeta);
        feather.setItemMeta(fthMeta);
        ghastTear.setItemMeta(tearMeta);
        tp.setItemMeta(tpMeta);



        p.openInventory(inventory);

        inventory.setItem(11, totem);
        inventory.setItem(13, feather);
        inventory.setItem(15, ghastTear);

        inventory.setItem(26, tp);


        return true;
    }

}
