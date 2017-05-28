package Unit2.Task3.implementations;

import Unit2.Task3.interfaces.CanBeWrittenOn;

/**
 * Created by TyurkinaAlexandra on 10.05.2017.
 */
public class Copybook implements CanBeWrittenOn {
    private final String name="copybook";
    private final int price = 40;
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Copybook{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int getPrice() {
        return price;
    }
}
