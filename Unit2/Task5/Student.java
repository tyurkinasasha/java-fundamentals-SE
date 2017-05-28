package Unit2.Task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Tyurkina Alexandra on 5/28/2017.
 */
public class Student {
    private String name;
    private double average;
    private Map<Disciplines, Integer> marksList = new HashMap<>();



    private enum Disciplines {MATHS, PHYSICS, BIOLOGY, GEOGRAPHY, HISTORY;}
    public Student(String name, String surname) {
        this.name = name + " " + surname;
        this.setRandomMarks();
        this.average=countAverage();

    }

    public void displayMarksList() {
        System.out.println(name+":\n"+marksList);
    }

    public String getName() {
        return name;
    }

    private void setRandomMarks() {
        Random rand = new Random();
        for (Disciplines disc : Disciplines.values()) {
            marksList.put(disc, rand.nextInt(11));
        }
    }

    private double countAverage(){
        int tmp=0;
        for (Integer i: marksList.values()){
            tmp+=i;
        }
        return (double)tmp/Disciplines.values().length;
    }
    @Override
    public String toString() {
        return "Name: " + name +
                "\nMarksList: " + marksList +
                '\n';
    }
    public double getAverage() {
        return average;
    }

}
