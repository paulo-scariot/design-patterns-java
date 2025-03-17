package creational.builder;

public interface Builder {
    void setCPU(String CPU);
    void setRAM(int RAM);
    void setType(ComputerType type);
    void setMonitor(Monitor monitor);
}
