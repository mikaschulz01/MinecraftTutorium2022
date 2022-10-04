package de.otto.minecrafttutorium.exampleplugin.commands;

import de.otto.minecrafttutorium.exampleplugin.Exampleplugin;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class FireSwordCommand implements CommandExecutor {

  private final Exampleplugin plugin;

  public FireSwordCommand(Exampleplugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
      @NotNull String label, @NotNull String[] args) {
    if (!(sender instanceof Player player)) {
      sender.sendMessage("§cNur für Spieler");
      return true;
    }
    sender.sendMessage("§bDas Feuerschwert wird gleich erscheinen");
    AtomicInteger atomicStep = new AtomicInteger(-1);
    Bukkit.getScheduler().runTaskTimer(plugin, bukkitTask -> {
      int step = atomicStep.incrementAndGet();
      player.sendActionBar(Component.text("§bDas Schwert wird beschworen §e- §c" + step * 5 + " §c%"));
      if (step == 20) {
        bukkitTask.cancel();
        player.getInventory().addItem(getFireSword());
      }
    } , 0, 5);
    return true;
  }

  private ItemStack getFireSword() {
    ItemStack fireSword = new ItemStack(Material.DIAMOND_SWORD, 1);
    ItemMeta fireSwordMeta = fireSword.getItemMeta();
    fireSwordMeta.displayName(Component.text("§6§lFireSword"));
    fireSwordMeta.lore(List.of(Component.text(""),
        Component.text("§bEines der letzten Feuerschwerter")));
    fireSwordMeta.addEnchant(Enchantment.FIRE_ASPECT, 3, true);
    fireSwordMeta.setUnbreakable(true);
    fireSword.setItemMeta(fireSwordMeta);
    return fireSword;
  }

}
