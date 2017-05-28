package Unit2.Task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tyurkina Alexandra on 5/28/2017.
 */
public class Group {
    public List<Student> getStudents() {
        return students;
    }

    private List<Student> students = new ArrayList<>();

    public Group(int number) {
        createGroup(number);
    }

    private void createGroup(int number) {
        for (int i = 0; i < number; i++) {
            students.add(new Student("Student", "" + (i + 1)));
        }
    }

    public void addStudent(String name, String surname) {
        students.add(new Student(name, surname));
    }
    public void showTop5(){
        StudentComparator sc=new StudentComparator();
        Collections.sort(students,sc);
        Collections.reverse(students);
        System.out.println("Top 5 students: ");
        for (int i=0; i<5;i++){
            System.out.print((i+1)+". ");
            students.get(i).displayMarksList();
            System.out.println("Average: "+students.get(i).getAverage());
        }
    }
}
