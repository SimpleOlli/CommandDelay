package de.simpleolli.delaycommand.listener;

import de.simpleolli.delaycommand.utility.DelayUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandListener implements Listener {

    @EventHandler
    public void handle(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        final String command = event.getMessage().split(" ")[0];

        if(!DelayUtil.isDelayed(player.getName(),command)) {
            DelayUtil.setDelayed(player,command,15);
        }else {
            player.sendMessage("§cBitte warte einen Augenblick");
            event.setCancelled(true);
        }
    }

}
