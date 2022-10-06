package me.dark.merchant.moderationcommandsgui;

import me.dark.merchant.moderationcommandsgui.GUIs.MainGUI;
import me.dark.merchant.moderationcommandsgui.listeners.MainListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ModerationCommandsGUI extends JavaPlugin {

    public ArrayList<Player> invList = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        MainListener.injectPlugin(this);

        getCommand("mcg").setExecutor(new MainGUI());

        getServer().getPluginManager().registerEvents(new MainListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
