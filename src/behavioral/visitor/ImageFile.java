package behavioral.visitor;

public class ImageFile implements FileElement {
    private String name;
    private int resolution;

    public ImageFile(String name, int resolution) {
        this.name = name;
        this.resolution = resolution;
    }

    public int getResolution() {
        return resolution;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }
}