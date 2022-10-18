package de.otto.minecrafttutorium.exampleplugin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class JsonUtils {

  public static final Gson PRETTY_GSON = new GsonBuilder().setPrettyPrinting().create();

  public static <T extends Type> Map<String, String> parseFile(Path path, T typeToken)
      throws IOException {
    try (BufferedReader reader = Files.newBufferedReader(path)) {
      return PRETTY_GSON.fromJson(reader, typeToken);
    }
  }

  public static void toJson(Object src, Path path) throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(path)) {
      PRETTY_GSON.toJson(src, writer);
    }
  }


}
