package me.dark.merchant.moderationcommandsgui.listeners;

import me.dark.merchant.moderationcommandsgui.ModerationCommandsGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    private static ModerationCommandsGUI plugin;

    public JoinEvent(ModerationCommandsGUI p) {
        plugin = p;
    }



    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        for (int i = 0; i < plugin.invList.size(); i++){
            player.hidePlayer(plugin, plugin.invList.get(i));
        }
    }

}
