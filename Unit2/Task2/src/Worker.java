import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Worker {
    private String name, surname;
    private int penCount, copybookCount, eraserCount;
    private List<OfficeSupplies> officeSuppliesList = new ArrayList<>();
    private Iterator<OfficeSupplies> iter;

    public Worker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addPens(int penCount) throws InstantiationException, IllegalAccessException {
        addSupply(penCount, Pen.class);
        this.penCount += penCount;
        System.out.println("" + penCount + " pens added!");
    }

    public void addCopybooks(int copybookCount) throws InstantiationException, IllegalAccessException {
        addSupply(copybookCount, Copybook.class);
        this.copybookCount += copybookCount;
        System.out.println("" + copybookCount + " copybooks added!");
    }


    public void addErasers(int eraserCount) throws InstantiationException, IllegalAccessException {
        addSupply(eraserCount, Eraser.class);
        this.eraserCount += eraserCount;
        System.out.println("" + eraserCount + " erasers added!");
    }

    public void removePens(int penToRemoveCount) {
        for (int i = 0; i < penToRemoveCount; i++) {
            remove(Pen.class.getName());
        }
        penCount -= penToRemoveCount;
        System.out.println("" + penToRemoveCount + " pens removed!");

    }

    public void removeCopybooks(int copybookToRemoveCount) {
        for (int i = 0; i < copybookToRemoveCount; i++) {
            remove(Copybook.class.getName());
        }
        copybookCount -= copybookToRemoveCount;
        System.out.println("" + copybookToRemoveCount + " copybooks removed!");

    }

    public void removeErasers(int eraserToRemoveCount) {
        for (int i = 0; i < eraserToRemoveCount; i++) {
            remove(Eraser.class.getName());
        }
        eraserCount -= eraserToRemoveCount;
        System.out.println("" + eraserToRemoveCount + " erasers removed!");

    }

    public void showOfficeSuppliesPrice() {
        float overallPrice = 0;
        for (OfficeSupplies i : officeSuppliesList
                ) {
            overallPrice += i.getPrice();
        }
        sep();
        System.out.println("Overall price of supplies that " + this.name + " has: " + overallPrice);
        sep();

    }

    public void displayOfficeSuppliesList() {
        sep();
        System.out.println("Office supplies that " + this.name + " has:");
        sep();
        System.out.printf("%s\n%s\n%s\n",
                "Pens: " + penCount,
                "Copybooks: " + copybookCount,
                "Erasers: " + eraserCount);
    }

    private void addSupply(int count, Class <? extends OfficeSupplies>c) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < count; i++) {
            officeSuppliesList.add(c.newInstance());
        }
    }

    private void remove(String className) {
        iter = officeSuppliesList.iterator(); //getting java.util.ConcurrentModificationException if out of this method (why?)
        while (iter.hasNext()) {
            String name = iter.next().getClass().getName();
            if (name.equals(className)) {
                iter.remove();
                break;
            }
        }
    }

    private void sep() {
        System.out.println("==============================");
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "{" +
                name +
                " " +
                surname +
                '}';
    }
}
