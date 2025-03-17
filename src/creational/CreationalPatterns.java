package creational;

import creational.abstractmethod.FurnitureApplication;
import creational.abstractmethod.FurnitureFactory;
import creational.abstractmethod.ModernFactory;
import creational.abstractmethod.VictorianFactory;
import creational.builder.Computer;
import creational.builder.ComputerBuilder;
import creational.builder.Director;
import creational.factorymethod.Logistic;
import creational.factorymethod.RoadLogistic;
import creational.factorymethod.SeaLogistic;
import creational.prototype.Circle;
import creational.prototype.Shape;
import creational.simplefactory.Vehicle;
import creational.simplefactory.VehicleSimpleFactory;
import creational.singleton.Singleton;

public class CreationalPatterns {
    public static void run() {

        // O Singleton garante que apenas um objeto desse tipo exista e forneça um único ponto de acesso a ele para qualquer outro código.
        System.out.println("Singleton");
        Singleton teste = Singleton.getInstance("teste");
        System.out.println(teste);
        teste = Singleton.getInstance("teste2");
        System.out.println(teste);

        System.out.println("\nSimple Factory");
        Vehicle vehicle1 = VehicleSimpleFactory.getVehicle("CAR");
        vehicle1.drive();
        Vehicle vehicle2 = VehicleSimpleFactory.getVehicle("BIKE");
        vehicle2.drive();

        // O Factory method resolve o problema de criar objetos de produtos sem especificar suas classes concretas.
        System.out.println("\nFactory Method");
        Logistic roadLogistic = new RoadLogistic();
        roadLogistic.deliverPackage();
        Logistic seaLogistic = new SeaLogistic();
        seaLogistic.deliverPackage();

        // O Abstract Factory resolve o problema de criar famílias inteiras de produtos sem especificar suas classes concretas.
        System.out.println("\nAbstract Method");
        FurnitureFactory modernFactory = new ModernFactory();
        FurnitureApplication modernApp = new FurnitureApplication(modernFactory);
        modernApp.build();
        FurnitureFactory victorianFactory = new VictorianFactory();
        FurnitureApplication victorianApp = new FurnitureApplication(victorianFactory);
        victorianApp.build();

        // O Builder permite a construção de objetos complexos passo a passo.
        System.out.println("\nBuilder Method");
        ComputerBuilder computerBuilder = new ComputerBuilder();
        Director director = new Director();
        director.constructGamerComputer(computerBuilder);
        Computer computer = computerBuilder.getResult();
        System.out.println(computer.showSpecification());
        System.out.println(computer.getMonitor().showSpecification());

        // O Prototype permite a clonagem de objetos, mesmo complexos, sem acoplamento à suas classes específicas.
        System.out.println("\nPrototype Method");
        Circle circle = new Circle();
        circle.setX(0);
        circle.setY(0);
        circle.setColor("red");
        circle.setRadius(1);
        Shape clone = circle.clone();
        System.out.println(circle);
        System.out.println(clone);
    }

}
