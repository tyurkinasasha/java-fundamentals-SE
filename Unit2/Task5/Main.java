package Unit2.Task5;

/**
 * Created by Tyurkina Alexandra on 5/28/2017.
 */
public class Main {
    public static void main(String[] args) {
        Group group=new Group(10);
        group.addStudent("Jeff","Anderson");
        System.out.println(group.getStudents());
        group.showTop5();
    }
}
