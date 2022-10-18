package de.otto.minecrafttutorium.exampleplugin.commands;

import com.google.common.base.Joiner;
import de.otto.minecrafttutorium.exampleplugin.utils.MappingUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

public class TpWorld implements CommandExecutor {

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage("§cNur für Spieler");
      return true;
    }
    if (args.length != 4) {
      player.sendMessage("§cUsage: §b/tpworld <world> <x> <y> <z>");
      sendWorlds(player);
      return true;
    }
    World world = Bukkit.getWorld(args[0]);
    if (world == null) {
      player.sendMessage("§cDie Welt existiert nicht.");
      sendWorlds(player);
      return true;
    }
    List<Integer> coordinates = new ArrayList<>();
    for (int i = 1; i < args.length; i++) {
      Optional<Integer> coordinatePart = MappingUtils.parseInt(args[i]);
      if (coordinatePart.isEmpty()) {
        player.sendMessage(
            Component.text("§cDas Argument an der Stelle §6" + (i + 1) + " §cInput ist ungültig"));
        return true;
      }
      coordinates.add(coordinatePart.get());
    }
    player.teleport(
        new Location(world, coordinates.get(0), coordinates.get(1), coordinates.get(2)));
    return true;
  }

  public void sendWorlds(Player player) {
    player.sendMessage("§cVerfügbare Welten: ");
    String worlds = Joiner.on("§e, §b")
        .join(Bukkit.getWorlds().stream().map(WorldInfo::getName).collect(Collectors.toList()));
    player.sendMessage("§c\u27A4 §b" + worlds);
  }
}
