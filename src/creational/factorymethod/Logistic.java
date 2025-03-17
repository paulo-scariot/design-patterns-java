package creational.factorymethod;

import creational.factorymethod.transport.Transport;

public abstract class Logistic {

    public void deliverPackage() {
        Transport transport = createTransport();
        transport.deliver();
    }

    public abstract Transport createTransport();
}
