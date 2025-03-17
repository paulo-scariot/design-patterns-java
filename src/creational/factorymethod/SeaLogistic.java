package creational.factorymethod;

import creational.factorymethod.transport.Ship;
import creational.factorymethod.transport.Transport;

public class SeaLogistic extends Logistic{
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
