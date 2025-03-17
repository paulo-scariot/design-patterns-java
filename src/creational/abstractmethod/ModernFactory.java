package creational.abstractmethod;

import creational.abstractmethod.chair.Chair;
import creational.abstractmethod.chair.ModernChair;
import creational.abstractmethod.table.ModernTable;
import creational.abstractmethod.table.Table;

public class ModernFactory implements FurnitureFactory{
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Table createTable() {
        return new ModernTable();
    }
}
