package behavioral.visitor;

public class VideoFile implements FileElement {
    private String name;
    private int duration;

    public VideoFile(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void accept(FileVisitor visitor) {
        visitor.visit(this);
    }
}