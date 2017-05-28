package Unit2.Task3.implementations;

import Unit2.Task3.interfaces.CanBeWrittenOn;
import Unit2.Task3.interfaces.CanErase;
import Unit2.Task3.interfaces.CanWrite;

import java.awt.*;

public class PencilWithEraser implements CanErase, CanWrite {
    private Color color;
    private final String name = "pencilWithEraser";
    private final int price = 30;

    @Override
    public String toString() {
        return "PencilWithEraser{" +
                "name='" + name + '\'' +
                ", price=" + +price +
                '}';
    }

    @Override
    public void erase() {
        //implement here
    }

    @Override
    public void write(CanBeWrittenOn paperType) {
        //implement here
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {

        return color;
    }
}
