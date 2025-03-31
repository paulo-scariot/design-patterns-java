package behavioral.template;

public class CsvProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data...");
    }
}