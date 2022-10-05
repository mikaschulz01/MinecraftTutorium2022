[Zurück zur Hauptseite](../README.md)

# Java Dokumentation zu PaperMC

## Übersicht

Dies ist die Übersicht über der PaperMC JavaDocs

https://jd.papermc.io/paper/1.19/org/bukkit/package-summary.html

## JavaPlugin

In jedem PaperMC Plugin muss es eine Klasse geben, die von der "JavaPlugin" Klasse vererbt.
Sie ist eure "Hauptklasse", die von PaperMC als erstes gelesen wird.

In dieser Klasse registriert ihr alle eure Erweiterungen, wie Events, oder Befehle.
Die Klasse muss in der "plugin.yml" Datei unter "main" angegeben werden.

https://jd.papermc.io/paper/1.17/org/bukkit/plugin/java/JavaPlugin.html

## plugin.yml

Die "plugin.yml" muss sich in jedem PaperMC-Plugin in dem Root-Verzeichnis befinden.
Siehe hier in "src/resources".

https://jd.papermc.io/paper/1.14/org/bukkit/plugin/PluginDescriptionFile.html

## Events

Für die meisten Aktionen, die auf dem Server pasieren, gibt es ein Event.
Diese lassen sich über Listener abfangen und manipulieren.

https://jd.papermc.io/paper/1.19/org/bukkit/event/package-summary.html

## Commands

Commands sind Chatnachrichten, die mit "/" beginnen. Sie werden an Server gesendet und erzeugen
je nach Befehl eine Aktion. Das Ausführen des Befehls ist für andere Spieler im Chat nicht
sichtbar, in der Console des Servers allerdings schon.

https://jd.papermc.io/paper/1.16/org/bukkit/command/CommandExecutor.html

## Scheduler

Scheduler sind "Zeitplaner". Mit ihnen lassen sich Ereignisse erst nach einer definierten Zeit
ausführen. Auch können Ereignisse ab einem definierten Zeitpunkt nach einer definierten Zeit
wiederholt werden.

Die zeitliche Einheit der Scheduler ist in Ticks. Ein lagfreier Minecraft Server wird sekündlich
20-mal "ticken".

https://jd.papermc.io/paper/1.19/org/bukkit/scheduler/package-summary.html

## ItemStack
Alle Items im Inventar sind ItemStacks. Ein ItemStack besteht unter anderem aus einem Material,
einer Menge und einer ItemMeta.

https://jd.papermc.io/paper/1.19/org/bukkit/inventory/ItemStack.html

## ItemMeta
Die ItemMeta eines Items beinhaltet unter anderem die Verzauberungen, den Namen und die Lore.
Wird sie modifiziert, muss sie anschließend wieder an den ItemStack gesetzt werden.

https://jd.papermc.io/paper/1.19/org/bukkit/inventory/meta/ItemMeta.html

## Material

Das Material ist der Typ des Items. Hier gibt es zum Beispiel eine Reihe von
Blöcken (Erde, Stein, Ziegel und co.) oder auch Ausrüstung (Schwerter, Äxte, Helme und co.).

https://jd.papermc.io/paper/1.19/org/bukkit/Material.html

## Enchantments
Verzauberungen können nur auf Ausrüstung gelegt werden.
Eine Liste von Verzauberungen findet ihr hier:

https://jd.papermc.io/paper/1.19/org/bukkit/enchantments/Enchantment.html

## Farbcodes
Die Farbcodes können in Chatnachrichten, im Scoreboard, in der Actionbar und co. verwendet werden.
In den neuen Versionen von Minecraft ist allerdings auch alle anderen Farben möglich
(über RGB oder HSV).

https://minecraft.fandom.com/wiki/Formatting_codes