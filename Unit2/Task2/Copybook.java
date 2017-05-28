package Unit2.Task2;

public class Copybook implements OfficeSupplies {
    private final float price=70f;

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Copybook";
    }
}
