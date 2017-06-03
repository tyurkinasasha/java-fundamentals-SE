package homework.Unit1.Task4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by hp on 25.04.2017.
 */
public class Task4 {
    private static final int rangeMin = -100;
    private static final int rangeMax = 100;
    private static final int n = 23;
    private static float[] values;
    private static float max = Long.MIN_VALUE;
    private static int index1;
    private static int index2;

    public static void main(String[] args) {
        values = createAndFill(n);
        System.out.println("Sequence:"+Arrays.toString(values));
        if (n % 2 == 0) {
            System.out.println("max(a1+a2,a3+a4+..) = " + maxCoupleEven(values) + "(a" + index1 + "+a" + index2 + ")");
        } else {
            System.out.println("max(a1+a2,a3+a4+..) = " + maxCoupleOdd(values) + "(a" + index1 + "+a" + index2 + ")");
        }
    }

    /**
     * Creating array of random float numbers in range (-100;100)
     *
     * @param n array size
     * @return float [] array
     */

    public static float[] createAndFill(int n) {
        Random rand = new Random();
        float[] array = new float[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rangeMin + rand.nextFloat() * (rangeMax - rangeMin);
        }
        return array;
    }

    public static float maxCoupleEven(float[] array) {
        for (int i = 0; i < array.length - 1; i += 2) {
            if (array[i] + array[i + 1] > max) {
                max = array[i] + array[i + 1];
                index1 = i + 1;
                index2 = i + 2;
            }
        }
        return max;
    }

    public static float maxCoupleOdd(float[] array) {
        for (int i = 0; i < array.length - 2; i += 2) {
            if (array[i] + array[i + 1] > max) {
                max = array[i] + array[i + 1];
                index1 = i + 1;
                index2 = i + 2;
            }
        }
        if (array[array.length - 1] > max) {
            max = array[array.length - 1];
            index1 = array.length - 1;
            index2 = array.length - 1;
        }
        return max;
    }
}
