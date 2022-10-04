package de.otto.minecrafttutorium.exampleplugin;

import de.otto.minecrafttutorium.exampleplugin.commands.FireSwordCommand;
import de.otto.minecrafttutorium.exampleplugin.commands.ScareCommand;
import de.otto.minecrafttutorium.exampleplugin.listener.ColorfulChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Exampleplugin extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    Exampleplugin instance = this;

    // Register a command
    getCommand("scare").setExecutor(new ScareCommand());

    getCommand("firesword").setExecutor(new FireSwordCommand(instance));

    // Register an event
    getServer().getPluginManager().registerEvents(new ColorfulChatListener(), instance);


    // Some console startup message
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic

    // Some console shutdown message
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }
}
