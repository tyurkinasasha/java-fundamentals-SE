package Unit2.Task2;

public class Pen implements OfficeSupplies {
    private final float price=40f;

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pen";
    }
}
