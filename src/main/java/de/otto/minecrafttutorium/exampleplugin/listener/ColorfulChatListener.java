package de.otto.minecrafttutorium.exampleplugin.listener;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ColorfulChatListener implements Listener {

  // All Events must be annotated with @EventHandler
  @EventHandler
  public void onChat(AsyncChatEvent e) {
    Component modifiedMessage = e.originalMessage().color(TextColor.color(255, 0, 0));
    e.message(modifiedMessage);
  }

}
