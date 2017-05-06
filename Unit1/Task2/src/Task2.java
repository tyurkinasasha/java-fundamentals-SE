/**
 * Created by hp on 24.04.2017.
 */
public class Task2 {
    private static final float eps = 1E-6f;
    private static final int n = 2000;

    public static void main(String[] args) {
        System.out.println((float) 1 / ((n + 1) * (n + 1)));
        for (int i = 1; i <= n; i++) {
            if ((float) 1 / ((i + 1) * (i + 1)) < eps) {
                System.out.println("min n: (1/(n+1)^2<" + eps + ") = " + i);
                for (int k = i; k <= n; k++) {
                    System.out.println("a(" + k + "): (a(n)<" + eps + ") = "
                            + (float) 1 / ((k + 1) * (k + 1)) + ",");
                }
                break;
            }
        }
    }
}
