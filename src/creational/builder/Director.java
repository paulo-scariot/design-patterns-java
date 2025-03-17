package creational.builder;

public class Director {
    public void constructGamerComputer(Builder builder) {
        builder.setCPU("Core I9");
        builder.setRAM(32);
        builder.setType(ComputerType.NOTEBOOK);
        builder.setMonitor(new Monitor("1920x1080", 21F));
    }

    public void constructGamerNotebook(Builder builder) {
        builder.setCPU("Core I7");
        builder.setRAM(16);
        builder.setType(ComputerType.NOTEBOOK);
    }

    public void constructComputer(Builder builder) {
        builder.setCPU("Core I5");
        builder.setRAM(8);
        builder.setType(ComputerType.NOTEBOOK);
        builder.setMonitor(new Monitor("1920x1080", 32F));
    }

    public void constructNotebook(Builder builder) {
        builder.setCPU("Core I3");
        builder.setRAM(4);
        builder.setType(ComputerType.NOTEBOOK);
    }
}
