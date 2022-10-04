[Zurück zur Hauptseite](../README.md)

# PaperMC Plugin exportieren

- Der Gradle "Jar" Task muss ausgeführt werden, um das Plugin in eine ".jar" Datei zu exportierten.
- Das Plugin findet ihr in eurem Projekt unter "build/libs".
- Diese Datei muss nun im Unterordner "plugins" eures Serverordners verschoben werden.
- Der Server kann jetzt neu gestartet / geladen werden
  (Siehe: [PaperMC nützliche Server Befehle](../docs/paperMcCommands.md))

**Tipp**:

In der "build.gradle" Datei lässt sich das Outputverzeichnis der ".jar" Datei anpassen.

So lässt sich der manuelle Schritt des Verschiebens sparen.

- Siehe dazu [hier](../build.gradle) bei "destinationDir".
- Passt den Pfad für euch an.
