package creational.factorymethod;

import creational.factorymethod.transport.Transport;
import creational.factorymethod.transport.Truck;

public class RoadLogistic extends Logistic{
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
