package Unit2.Task1;

import java.awt.*;

public class Pen {
    private Color color;
    private String brand;
    private float width;
    private float inkLeft;
    private final float inkMax=5.0f;

    public Pen(Color color, String brand, float width) {
        this.color = color;
        this.brand = brand;
        this.width = width;
        this.inkLeft=inkMax;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setInkLeft(float inkLeft) {
        this.inkLeft = inkLeft;
    }

    public String getBrand() {
        return brand;
    }

    public float getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public float getInkLeft() {
        return inkLeft;
    }

    public void write(){
        if (inkLeft==0.0){
            System.out.println("The pen is empty");
            return;
        }
        inkLeft-=1.0;
        System.out.println("Writing ;)");
    }

    public void refill(){
        inkLeft=inkMax;
        System.out.println("Pen refilled");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (Float.compare(pen.width, width) != 0) return false;
        if (Float.compare(pen.inkLeft, inkLeft) != 0) return false;
        if (color != null ? !color.equals(pen.color) : pen.color != null) return false;
        return brand != null ? brand.equals(pen.brand) : pen.brand == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (width != +0.0f ? Float.floatToIntBits(width) : 0);
        result = 31 * result + (inkLeft != +0.0f ? Float.floatToIntBits(inkLeft) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color=" + color +
                ", brand='" + brand + '\'' +
                ", width=" + width +
                ", inkLeft=" + inkLeft +
                '}';
    }
}