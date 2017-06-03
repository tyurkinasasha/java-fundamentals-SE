package homework.Unit2.Task4;

import homework.Unit2.Task3.implementations.StarterKit;

import java.util.Collections;

/**
 * Created by TyurkinaAlexandra on 5/23/2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        StarterKit sk = new StarterKit();
        NameComparator nc = new NameComparator();
        PriceComparator pc = new PriceComparator();
        NameAndPriceComparator npc = new NameAndPriceComparator(nc, pc);

        Collections.sort(sk.officeSuppliesList, nc);
        System.out.println("Sorted by name:\n" + sk.officeSuppliesList);
        Collections.sort(sk.officeSuppliesList, pc);
        System.out.println("Sorted by price:\n" + sk.officeSuppliesList);
        Collections.sort(sk.officeSuppliesList, npc);
        System.out.println("Sorted by name & price:\n" + sk.officeSuppliesList);
    }
}
