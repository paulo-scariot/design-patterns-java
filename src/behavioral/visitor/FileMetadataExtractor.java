package behavioral.visitor;

public class FileMetadataExtractor implements FileVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Text File Metadata: Size = " + textFile.getSize() + "KB");
    }

    @Override
    public void visit(ImageFile imageFile) {
        System.out.println("Image File Metadata: Resolution = " + imageFile.getResolution() + "MP");
    }

    @Override
    public void visit(VideoFile videoFile) {
        System.out.println("Video File Metadata: Duration = " + videoFile.getDuration() + " seconds");
    }
}