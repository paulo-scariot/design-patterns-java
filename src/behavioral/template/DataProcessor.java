package behavioral.template;

public abstract class DataProcessor {
    public void process() {
        readData();
        processData();
        saveData();
    }

    abstract void readData();
    abstract void processData();

    void saveData() {
        System.out.println("Saving data to database...");
    }
}
