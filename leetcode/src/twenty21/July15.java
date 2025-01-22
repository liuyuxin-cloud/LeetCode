package twenty21;

/**
 * 罗马数字包含以下七种字符:I.V，X，L，C，D和M。p
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 */
public class July15 {
    public static void main(String[] args){
        Solution7_15 s = new Solution7_15();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}

class Solution7_15 {
    public int romanToInt(String s) {
        char[] rec = s.toCharArray();
        int n = s.length();
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            switch (rec[i]) {
                case 'M':
                    ans += 1000;
                    break;
                case 'D':
                    ans += 500;
                    break;
                case 'C':
                    if (i + 1 < n && rec[i + 1] == 'D') {
                        ans += 400;
                        i++;
                    } else if (i + 1 < n && rec[i + 1] == 'M') {
                        ans += 900;
                        i++;
                    } else {
                        ans += 100;
                    }
                    break;
                case 'L':
                    ans += 50;
                    break;
                case 'X':
                    if (i + 1 < n && rec[i + 1] == 'L') {
                        ans += 40;
                        i++;
                    } else if (i + 1 < n && rec[i + 1] == 'C') {
                        ans += 90;
                        i++;
                    } else {
                        ans += 10;
                    }
                    break;
                case 'V':
                    ans += 5;
                    break;
                case 'I':
                    if (i + 1 < n && rec[i + 1] == 'V') {
                        ans += 4;
                        i++;
                    } else if (i + 1 < n && rec[i + 1] == 'X') {
                        ans += 9;
                        i++;
                    } else {
                        ans += 1;
                    }
                    break;
            }
        }
        return ans;
    }
}