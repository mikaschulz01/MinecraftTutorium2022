package de.otto.minecrafttutorium.exampleplugin.commands;

import de.otto.minecrafttutorium.exampleplugin.Exampleplugin;
import de.otto.minecrafttutorium.exampleplugin.utils.MappingUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatcolorCommand implements CommandExecutor {

  private final Exampleplugin plugin;

  public ChatcolorCommand(Exampleplugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage("§cNur für Spieler");
      return true;
    }
    TextColor color = null;
    if (args.length == 1) {
      if (!args[0].startsWith("#")) {
        player.sendMessage(Component.text("§cDer Hex Code muss mit §6\"§b#§6\" §cbeginnen"));
        return true;
      }
      color = TextColor.fromHexString(args[0]);
    } else if (args.length == 3) {
      List<Integer> colors = new ArrayList<>();
      for (int i = 0; i < args.length; i++) {
        Optional<Integer> colorPart = MappingUtils.parseInt(args[i]);
        if (colorPart.isEmpty()) {
          player.sendMessage(
              Component.text("§cDas Argument an der Stelle §6" + (i + 1) + " §cInput ist ungültig"));
          return true;
        }
        colors.add(colorPart.get());
      }
      color = TextColor.color(colors.get(0), colors.get(1), colors.get(2));
    }
    if (color == null) {
      player.sendMessage(Component.text("§cDer Input ist ungültig"));
      return true;
    }
    player.sendMessage(Component.text("Du hast die Farbe gesetzt!", color));
    plugin.getColorMap().put(player, color);
    return true;
  }


}
