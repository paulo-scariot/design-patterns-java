package behavioral.template;

public class JsonProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("Reading data from JSON file...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing JSON data...");
    }
}