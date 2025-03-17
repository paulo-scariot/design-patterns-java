package creational.simplefactory;

public class VehicleSimpleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equalsIgnoreCase("CAR")) {
            return new Car();
        } else if (type.equalsIgnoreCase("BIKE")) {
            return new Bike();
        }
        return null;
    }
}