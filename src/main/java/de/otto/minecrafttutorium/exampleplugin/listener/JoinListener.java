package de.otto.minecrafttutorium.exampleplugin.listener;

import de.otto.minecrafttutorium.exampleplugin.Exampleplugin;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

  private final Exampleplugin plugin;

  public JoinListener(Exampleplugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
    if (plugin.getNicknamesMap().containsKey(e.getPlayer().identity().uuid())) {
      String nickname = plugin.getNicknamesMap().get(e.getPlayer().identity().uuid());
      e.getPlayer().displayName(Component.text(nickname));
    }
  }

}
