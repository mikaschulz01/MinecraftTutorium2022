package de.otto.minecrafttutorium.exampleplugin.commands;

import com.google.common.base.Joiner;
import de.otto.minecrafttutorium.exampleplugin.Exampleplugin;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NicknameCommand implements CommandExecutor {

  private final Exampleplugin plugin;

  public NicknameCommand(Exampleplugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage("§cNur für Spieler");
      return true;
    }
    if (args.length < 1) {
      player.sendMessage(Component.text("§cBitte einen Nicknamen angeben."));
      return true;
    }
    String nick = Joiner.on(" ").join(args);
    nick = ChatColor.translateAlternateColorCodes('&', nick);
    player.displayName(Component.text(nick));
    plugin.getNicknamesMap().put(player.identity().uuid(), nick);
    player.sendMessage(Component.text("§cDein Nickname ist nun " + nick));
    return true;
  }


}
