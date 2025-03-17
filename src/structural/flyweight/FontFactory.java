package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private static final Map<String, FontStyle> fontPool = new HashMap<>();

    public static FontStyle getFont(String fontName, int size, String color) {
        String key = fontName + size + color;
        if (!fontPool.containsKey(key)) {
            fontPool.put(key, new ConcreteFont(fontName, size, color));
            System.out.println("Creating new Font: " + key);
        }
        return fontPool.get(key);
    }
}
