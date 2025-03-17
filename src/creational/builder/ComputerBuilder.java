package creational.builder;

public class ComputerBuilder implements Builder{
    private ComputerType computerType;
    private String CPU;
    private int RAM;
    private Monitor monitor;


    @Override
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    @Override
    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    @Override
    public void setType(ComputerType type) {
        this.computerType = type;
    }

    @Override
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Computer getResult() {
        return new Computer(computerType, CPU, RAM, monitor);
    }
}
