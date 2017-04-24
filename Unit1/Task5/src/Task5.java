import java.util.Arrays;

/**
 * Created by hp on 25.04.2017.
 */
public class Task5 {
    private static final int n = 20;

    public static void main(String[] args) {
        int[][] matrix = new int[n][n];
        matrix = setOnesDiag(matrix);
        displayMatrix(matrix);
        System.out.println("======================");
        matrix = setOnesDiag(getRotatedMatrix(matrix));
        displayMatrix(matrix);
    }

    public static int[][] setOnesDiag(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                }
            }
        }
        return matrix;
    }

    public static int[][] getRotatedMatrix(int[][] matrix) {
        int tmp;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
