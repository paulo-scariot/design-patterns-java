package behavioral.visitor;

public class TextFile implements FileElement {
    private String name;
    private int size;

    public TextFile(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }
}