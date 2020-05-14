package de.simpleolli.delaycommand;

import de.simpleolli.delaycommand.command.FlyCommand;
import de.simpleolli.delaycommand.command.HelpCommand;
import de.simpleolli.delaycommand.listener.PlayerCommandListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DelayCommand extends JavaPlugin {

    private static DelayCommand instance;

    @Override
    public void onEnable() {
        registerCommands();
        registerListener();
    }

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("help").setExecutor(new HelpCommand());
    }

    private void registerListener() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerCommandListener(),this);
    }

    public static DelayCommand getInstance() {
        return instance;
    }
}
