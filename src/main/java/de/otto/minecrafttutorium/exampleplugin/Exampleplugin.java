package de.otto.minecrafttutorium.exampleplugin;

import de.otto.minecrafttutorium.exampleplugin.commands.ChatcolorCommand;
import de.otto.minecrafttutorium.exampleplugin.commands.FireSwordCommand;
import de.otto.minecrafttutorium.exampleplugin.commands.NicknameCommand;
import de.otto.minecrafttutorium.exampleplugin.commands.ScareCommand;
import de.otto.minecrafttutorium.exampleplugin.commands.TpWorld;
import de.otto.minecrafttutorium.exampleplugin.files.NicknamesFile;
import de.otto.minecrafttutorium.exampleplugin.listener.ColorfulChatListener;
import de.otto.minecrafttutorium.exampleplugin.listener.JoinListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Exampleplugin extends JavaPlugin {

  private final Map<Player, TextColor> colorMap = new HashMap<>();
  private Map<UUID, String> nicknamesMap = new HashMap<>();
  private NicknamesFile nicknamesFile;

  @Override
  public void onEnable() {
    // Plugin startup logic
    Exampleplugin instance = this;

    Path pluginDirectory = createPluginDirectory();
    nicknamesFile = new NicknamesFile(pluginDirectory);
    loadNicknames();

    // Register a command
    getCommand("scare").setExecutor(new ScareCommand());

    getCommand("firesword").setExecutor(new FireSwordCommand(instance));
    getCommand("chatcolor").setExecutor(new ChatcolorCommand(instance));
    getCommand("nickname").setExecutor(new NicknameCommand(instance));
    getCommand("tpworld").setExecutor(new TpWorld());


    // Register an event
    getServer().getPluginManager().registerEvents(new ColorfulChatListener(instance), instance);
    getServer().getPluginManager().registerEvents(new JoinListener(instance), instance);

    createWorld();

    // Some console startup message
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
    saveNicknames();

    // Some console shutdown message
    getServer().getConsoleSender().sendMessage("§bExampleplugin aktiviert");
  }

  private void loadNicknames() {
    nicknamesMap = nicknamesFile.getNicknamesFileMap().entrySet()
        .stream()
        .collect(Collectors.toMap(
            e -> UUID.fromString(e.getKey()),
            Entry::getValue));
  }

  public void createWorld() {
    if (this.getServer().getWorld("flatworld") != null) {
      return;
    }
    WorldCreator worldCreator = new WorldCreator("flatworld");
    worldCreator.environment(Environment.NORMAL);
    worldCreator.type(WorldType.FLAT);
    worldCreator.generateStructures(false);
    worldCreator.generatorSettings("{\"layers\": [{\"block\": \"air\", \"height\": 1}], \"biome\":\"plains\"}");
    worldCreator.createWorld();
  }
  private void saveNicknames() {
    // Only save when server shuts down
    getNicknamesFile().save(getJsonNicknamesMap());
  }

  public NicknamesFile getNicknamesFile() {
    return nicknamesFile;
  }

  public Map<Player, TextColor> getColorMap() {
    return colorMap;
  }

  public Map<UUID, String> getNicknamesMap() {
    return nicknamesMap;
  }


  public Map<String, String> getJsonNicknamesMap() {
    return getNicknamesMap().entrySet().stream().collect(Collectors.toMap(
        e -> e.getKey().toString(),
        Entry::getValue));
  }

  private Path createPluginDirectory() {
    Path modFolder = getDataFolder().toPath().normalize();

    try {
      Files.createDirectories(modFolder);
    } catch (IOException e) {
      throw new RuntimeException("Couldn't create plugin folder.", e);
    }

    return modFolder;
  }
}
