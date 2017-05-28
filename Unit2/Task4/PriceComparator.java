package Unit2.Task4;

import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/24/2017.
 */
public class PriceComparator implements Comparator<OfficeSupplies> {
    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        return Integer.compare(o1.getPrice(),o2.getPrice());
    }

}
