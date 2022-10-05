package me.dark.merchant.moderationcommandsgui;

import me.dark.merchant.moderationcommandsgui.GUIs.MainGUI;
import me.dark.merchant.moderationcommandsgui.listeners.MainListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModerationCommandsGUI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("mcg").setExecutor(new MainGUI());

        getServer().getPluginManager().registerEvents(new MainListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
