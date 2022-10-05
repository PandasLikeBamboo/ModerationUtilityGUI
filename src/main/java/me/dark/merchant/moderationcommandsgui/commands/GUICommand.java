package me.dark.merchant.moderationcommandsgui.commands;

import me.dark.merchant.moderationcommandsgui.GUIs.MainGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){



            /* if (args.length == 0) {
            }else{
                if(args[0] == "main"){
                    //opens main menu
                }
            }*/


        }

        return true;
    }
}
