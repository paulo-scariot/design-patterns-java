package creational.abstractmethod;

import creational.abstractmethod.chair.Chair;
import creational.abstractmethod.chair.VictorianChair;
import creational.abstractmethod.table.Table;
import creational.abstractmethod.table.VictorianTable;

public class VictorianFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Table createTable() {
        return new VictorianTable();
    }
}
