package creational.builder;

public class Monitor {
    private final String screenResolution;
    private final Float size;

    public Monitor(String screenResolution, Float size) {
        this.screenResolution = screenResolution;
        this.size = size;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public Float getSize() {
        return size;
    }

    public String showSpecification() {
        return "Monitor{" +
                "screenResolution='" + getScreenResolution() + '\'' +
                ", size=" + getSize() +
                '}';
    }
}
