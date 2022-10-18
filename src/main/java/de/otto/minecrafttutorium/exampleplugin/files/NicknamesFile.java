package de.otto.minecrafttutorium.exampleplugin.files;

import com.google.gson.JsonNull;
import com.google.gson.reflect.TypeToken;
import de.otto.minecrafttutorium.exampleplugin.utils.JsonUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class NicknamesFile {

  private final Path keybinds;
  private static final JsonNull JSON_NULL = JsonNull.INSTANCE;

  public NicknamesFile(Path modfolder) {
    this.keybinds = modfolder.resolve("nicknames.json");
  }

  public Map<String, String> getNicknamesFileMap() {

    Map<String, String> map;
    Type empMapType = new TypeToken<Map<String, String>>() {}.getType();
    try {
      map = JsonUtils.parseFile(keybinds, empMapType);
    } catch (NoSuchFileException e) {
      save(JSON_NULL);
      map = new HashMap<>();
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    return map;
  }

  public void save(Object keybindsJson) {
    try {
      JsonUtils.toJson(keybindsJson, keybinds);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
