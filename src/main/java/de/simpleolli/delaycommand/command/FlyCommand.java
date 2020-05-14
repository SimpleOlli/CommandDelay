package de.simpleolli.delaycommand.command;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            final Player player = (Player) commandSender;
            if(player.hasPermission("System.command.fly")) {
                if(strings.length == 0) {
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage("§aDu kannst nun fliegen");
                    } else {
                        player.setFlying(false);
                        player.setAllowFlight(false);
                        player.sendMessage("§cDu kannst nun nicht mehr fliegen");
                    }
                }else {
                    player.sendMessage("§cBenutze nur /fly");
                }
            }else {
                player.sendMessage("§cKeine Rechte!");
            }
        }
        return false;
    }
}
