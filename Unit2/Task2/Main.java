package Unit2.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Worker[] workers =new Worker[]{
                new Worker("James","Anderson"),
                new Worker("Martin","Luther"),
                new Worker("Liza","Simpson")
        };
        List <Worker> workerList =new ArrayList<>();
        Collections.addAll(workerList, workers);
        System.out.println(workerList);
        workerList.get(0).addCopybooks(5);
        workerList.get(0).addErasers(4);
        workerList.get(0).addPens(3);
        //workerList.get(0).displayOfficeStuffList();
        workerList.get(0).removePens(2);
        workerList.get(0).addPens(10);
        workerList.get(0).removePens(6);
        workerList.get(0).removeErasers(1);
        workerList.get(0).displayOfficeSuppliesList();
        workerList.get(0).showOfficeSuppliesPrice();
    }
}
