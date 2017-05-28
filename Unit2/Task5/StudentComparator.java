package Unit2.Task5;

import java.util.Comparator;

/**
 * Created by Tyurkina Alexandra on 5/28/2017.
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverage(),o2.getAverage());
    }
}
