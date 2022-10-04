package de.otto.minecrafttutorium.exampleplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Exampleplugin extends JavaPlugin {

  @Override
  public void onEnable() {
    // Plugin startup logic
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }
}
