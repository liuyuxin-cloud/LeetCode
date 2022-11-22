package twenty22;

public class November22 {
}
class Solution11_22 {
    public int nthMagicalNumber(int n, int a, int b) {
        if(a % b == 0) return nthMagicalNumber(n, b);
        if(b % a == 0) return nthMagicalNumber(n, a);

        int p = a, i = 1;
        while(p * i % b != 0) i++;
        p = p * i;

        long l = 1, r = (long) n * Math.min(a, b);
        while(l <= r) {
            long m = (l + r) / 2;
            if(m / a + m / b - m / p >= n) r = m - 1;
            else l = m + 1;
        }
        return (int)(l % 1000000007)
    }

    public int nthMagicalNumber(int n, int a){
        return (int)((long)n * a % 1000000007);
    }
}
