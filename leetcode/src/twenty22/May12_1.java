package twenty22;
//超级丑数
public class May12_1 {
    public static void main(String[] args){
        Solution5_12_1 s = new Solution5_12_1();
        int[] primes = new int[]{2,7,13,19};
        s.nthSuperUglyNumber(12, primes);
    }
}
class Solution5_12_1{
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int len = primes.length;
        int[] p = new int[len];
        for(int i = 0; i < len; i++){
            p[i] = 1;
        }
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            int[] num = new int[len];
            for(int j = 0; j < len; j++){
                num[j] = dp[p[j]] * primes[j];
            }
            for(int j = 0; j < len; j++){
                min = min < num[j] ? min : num[j];
            }
            dp[i] = min;
            for(int j = 0; j < len; j++){
                if(num[j] == min){
                    p[j]++;
                }
            }
        }
        return dp[n];
    }
}
