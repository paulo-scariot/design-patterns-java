package creational.abstractmethod;

import creational.abstractmethod.chair.Chair;
import creational.abstractmethod.table.Table;

public class FurnitureApplication {
    private final Chair chair;
    private final Table table;

    public FurnitureApplication(FurnitureFactory factory) {
        chair = factory.createChair();
        table = factory.createTable();
    }

    public void build() {
        chair.build();
        table.build();
    }
}
