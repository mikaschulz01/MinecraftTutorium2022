package de.otto.minecrafttutorium.exampleplugin.utils;

import java.util.Optional;
import java.util.function.Supplier;

public class MappingUtils {

  public static Optional<Integer> parseInt(String string) {
    return parseType(() -> Integer.parseInt(string));
  }

  public static Optional<Double> parseDouble(String string) {
    return parseType(() -> Double.parseDouble(string));
  }

  public static Optional<Float> parseFloat(String string) {
    return parseType(() -> Float.parseFloat(string));
  }

  private static <T> Optional<T> parseType(Supplier<T> supplier) {
    try {
      return Optional.of(supplier.get());
    } catch (NumberFormatException e) {
      return Optional.empty();
    }
  }

}
