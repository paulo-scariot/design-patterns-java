package structural.flyweight;

public class ConcreteFont implements FontStyle {
    private String fontName;
    private int size;
    private String color;

    public ConcreteFont(String fontName, int size, String color) {
        this.fontName = fontName;
        this.size = size;
        this.color = color;
    }

    @Override
    public void applyStyle(String character) {
        System.out.println("Rendering character '" + character + "' with Font: " +
                fontName + ", Size: " + size + ", Color: " + color);
    }
}