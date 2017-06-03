package homework.Unit1.Task3;

import static java.lang.StrictMath.tan;
import static java.lang.StrictMath.toRadians;

/**
 * Created by hp on 24.04.2017.
 */
public class Task3 {
    public static final int a = 5;
    public static final int b = 30;
    public static final int h = 2;

    public static void main(String[] args) {
        for (int i = a; i <= b; i += h) {
            System.out.println("x = " + i + " tg(2x)-3 = " + f(i));
        }
    }

    public static double f(int x) {
        return tan(toRadians((2 * x))) - 3;
    }
}
