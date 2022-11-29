package twenty22;

public class November29 {
    public static void main(String[] args) {
        Solution11_29 s = new Solution11_29();
        System.out.println(s.minOperations("01"));
    }
}
class Solution11_29 {
    public int minOperations(String s) {
        int len = s.length();
        int cnt = 0;
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0 && s.charAt(i) != 0 || i % 2 == 1 && s.charAt(i) != 1) {
                cnt++;
            }
        }
        return Math.min(cnt, len - cnt);
    }
}