package creational.abstractmethod;

import creational.abstractmethod.chair.Chair;
import creational.abstractmethod.table.Table;

public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
}
