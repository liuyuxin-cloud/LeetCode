package twenty24;

//水果成篮

public class July7_2 {
}

class Solution7_7_2 {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) return 1;
        int res = 2;
        int j = 0;
        int f1 = fruits[0];
        int f2 = fruits[1];
        for (int i = 2; i < fruits.length; i++) {
            if (fruits[i] == f1 || fruits[i] == f2) continue;
            f1 = fruits[i];
            f2 = fruits[i-1];
            while (fruits[j] != f1 && fruits[j] != f2) {
                res = Math.max(res, i - j + 1);
                j++;
            }
        }
        return res;
    }
}