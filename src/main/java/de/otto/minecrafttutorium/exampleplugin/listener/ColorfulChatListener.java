package de.otto.minecrafttutorium.exampleplugin.listener;

import de.otto.minecrafttutorium.exampleplugin.Exampleplugin;
import io.papermc.paper.event.player.AsyncChatEvent;
import java.util.Locale;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ColorfulChatListener implements Listener {

  private final Exampleplugin plugin;

  public ColorfulChatListener(Exampleplugin plugin) {
    this.plugin = plugin;
  }

  // All Events must be annotated with @EventHandler
  @EventHandler
  public void onChat(AsyncChatEvent e) {
    if (e.originalMessage() instanceof TextComponent textComponent
        && textComponent.content().toLowerCase(Locale.ROOT).startsWith("###")) {
      e.message(MiniMessage.miniMessage()
          .deserialize("<rainbow>" + textComponent.content().replace("###", "") + "</rainbow>"));
      return;
    }
    if (plugin.getColorMap().containsKey(e.getPlayer())) {
      Component modifiedMessage = e.originalMessage()
          .color(plugin.getColorMap().get(e.getPlayer()));
      e.message(modifiedMessage);
    }
  }

}
