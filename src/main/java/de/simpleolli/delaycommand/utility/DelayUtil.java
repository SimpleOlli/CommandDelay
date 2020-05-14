package de.simpleolli.delaycommand.utility;

import com.google.gson.internal.$Gson$Preconditions;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class DelayUtil {

    private static HashMap<String,Long> delayed = new HashMap<>();

    public static void setDelayed(final Player player, final String command, final Integer delayTime) {
        final Long nextUse = System.currentTimeMillis() + delayTime*1000;
        delayed.put(player.getName() + ":" + command,nextUse);
    }

    public static boolean isDelayed(final String playerName, final String command) {
        if(delayed.containsKey(playerName + ":" + command)) {
            if(delayed.get(playerName + ":" + command) <= System.currentTimeMillis()) {
                delayed.remove(playerName + ":" + command);
                return false;
            }else {
                return true;
            }
        }else {
            return false;
        }
    }

}
