package Unit2.Task3.implementations;

import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.ArrayList;
import java.util.List;

public class StarterKit{
    private final int count=3;
    public List<OfficeSupplies> officeSuppliesList=new ArrayList<>();
    public StarterKit() throws InstantiationException, IllegalAccessException {
        addSuppliesToList(Pen.class,count);
        addSuppliesToList(Eraser.class,count);
        addSuppliesToList(Pencil.class,count);
        addSuppliesToList(CalendarBook.class,count);
        addSuppliesToList(PencilWithEraser.class,count);
        addSuppliesToList(Copybook.class,count);

    }
    private void addSuppliesToList(Class <? extends OfficeSupplies> c, int count) throws IllegalAccessException, InstantiationException {
        for (int i=0;i<count;i++){
            officeSuppliesList.add(c.newInstance());
        }
    }

    @Override
    public String toString() {
        return "StarterKit{" +
                "officeSuppliesList=" + officeSuppliesList +
                '}';
    }
}
