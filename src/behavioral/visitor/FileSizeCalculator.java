package behavioral.visitor;

public class FileSizeCalculator implements FileVisitor {
    private int totalSize = 0;

    @Override
    public void visit(TextFile textFile) {
        totalSize += textFile.getSize();
    }

    @Override
    public void visit(ImageFile imageFile) {
        totalSize += imageFile.getResolution() * 10;
    }

    @Override
    public void visit(VideoFile videoFile) {
        totalSize += videoFile.getDuration() * 5;
    }

    public int getTotalSize() {
        return totalSize;
    }
}