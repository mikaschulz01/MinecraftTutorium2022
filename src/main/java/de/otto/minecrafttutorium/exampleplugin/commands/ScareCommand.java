package de.otto.minecrafttutorium.exampleplugin.commands;

import de.otto.minecrafttutorium.exampleplugin.utils.MappingUtils;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import net.kyori.adventure.title.Title.Times;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ScareCommand implements CommandExecutor {

  private final Random rdm = new Random();
  private final List<String> messages = List.of("§6BUHHH!", "§5HAAAAAAA!", "§4BAAAH!");

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage("§cNur für Spieler");
      return true;
    }
    if (args.length > 1) {
      sender.sendMessage("§cBitte nur eine Zahl angeben.");
      return true;
    }
    String msg;
    if (args.length == 0) {
      msg = messages.get(rdm.nextInt(0, 3));
    } else {
      Optional<Integer> arg = MappingUtils.parseInt(args[0]);
      if (arg.isEmpty()) {
        player.sendMessage("§cBitte nur Zahlen angeben.");
        return true;
      }
      int number = arg.get();
      if (number < 1 || number > 3) {
        player.sendMessage("§cBitte wähle eine Zahl zwischen 1 und 3.");
        return true;
      }
      msg = messages.get(number - 1);
    }
    player.sendMessage("§eDu wurdest erschreckt!");
    player.showTitle(Title.title(Component.text(msg), Component.empty(),
        Times.times(Duration.ofSeconds(0), Duration.ofSeconds(3), Duration.ofSeconds(1))));
    return true;
  }

}
