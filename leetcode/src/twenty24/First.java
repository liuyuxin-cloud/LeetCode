package twenty24;


import java.util.Scanner;

public class First {
    public static void main (String[] args) {
        System.out.println(new solution1().printMax());
    }
}
class solution1{
    public int printMax () {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] nums = new int[number];
        for (int i = 0; i < number; i++) {
            nums[i] = input.nextInt();
        }
        int[] max1 = new int[nums.length + 1];
        max1[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max1[i + 1] = max1[i] > 0 ? max1[i] + nums[i] : nums[i];
        }
        int res = max1[0];
        for (int i: max1) {
            res = Math.max(res, i);
        }
        return res;
    }
}

