package creational.builder;

public class Computer {
    private final ComputerType computerType;
    private final String CPU;
    private final int RAM;
    private final Monitor monitor;

    public Computer(ComputerType computerType, String CPU, int RAM, Monitor monitor) {
        this.computerType = computerType;
        this.CPU = CPU;
        this.RAM = RAM;
        this.monitor = monitor;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public ComputerType getComputerType() {
        return computerType;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void turnOn(){
        System.out.println("Turning on computer");
    }

    public String showSpecification() {
        return "Computer{" +
                "computerType=" + getComputerType() +
                ", CPU='" + getCPU() + '\'' +
                ", RAM=" + getRAM() +
                '}';
    }
}
