package twenty22;


import java.util.Arrays;
import java.util.Random;

public class experiment {
    public static void main(String[] args) {
        Test t = new Test();
        t.generate(256);
    }
}

class Test {
    public void generate(int n) {
        Random r = new Random();
        int[][] x = new int[n][n];
        int[][] y = new int[n][1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = r.nextInt(1000);
            }
        }

        for (int i = 0; i < n; i++) {
            y[i][0] = r.nextInt(1000);
        }

        ColCalculate(x, y, n);
        RowCalculate(x, y, n);
    }

    public void ColCalculate(int[][] x, int[][] y, int n) {
        int[][] res = new int[n][1];
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            res[i][0] = sum1(i, x, y, n);
        }
        long endTime = System.nanoTime();
        double usedTime = endTime - startTime;
        System.out.println("col" + usedTime / 100000 + "ms");
    }

    public void RowCalculate(int[][] x, int[][] y, int n) {
        int[][] res = new int[n][1];
        long startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][0] += x[i][j] * y[j][0];
            }
        }
        long endTime = System.nanoTime();
        double usedTime = endTime - startTime;
        System.out.println("row" + usedTime / 100000 + "ms");
    }

    public int sum1(int i, int[][] x, int[][] y, int n) {
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += x[j][i] * y[i][0];
        }
        return sum;
    }
}
