package Unit2.Task4;


import Unit2.Task3.interfaces.OfficeSupplies;

import java.util.Comparator;

/**
 * Created by TyurkinaAlexandra on 5/24/2017.
 */
public class NameAndPriceComparator implements Comparator<OfficeSupplies> {
    private final Comparator<OfficeSupplies> com1;
    private final Comparator<OfficeSupplies> com2;

    public NameAndPriceComparator(Comparator<OfficeSupplies> com1, Comparator<OfficeSupplies> com2) {
        this.com1 = com1;
        this.com2 = com2;
    }

    @Override
    public int compare(OfficeSupplies o1, OfficeSupplies o2) {
        int res = com1.compare(o1, o2);
        if (res == 0) {
            return com2.compare(o1, o2);
        }
        return res;
    }
    }
