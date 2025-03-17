package creational.factorymethod.transport;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Deliver by ship.");
    }
}
