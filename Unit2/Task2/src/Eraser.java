
public class Eraser implements OfficeSupplies {
    private final float price = 15f;

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Eraser";
    }
}
