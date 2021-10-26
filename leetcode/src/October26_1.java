import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */

public class October26_1 {
    public static void main(String[] args){
        System.out.println(new Solution10_26_1().getRow(0));
    }
}

class Solution10_26_1 {
    public List<Integer> getRow(int rowIndex) {
        int k = 0;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        while(k <= rowIndex){
            List<Integer> cur = new ArrayList<>(pre);
            pre.clear();
            int j = 0;
            while(j <= k){
                if(j == 0 || j == k){
                    pre.add(1);
                }else{
                    pre.add(cur.get(j-1) + cur.get(j));
                }
                j++;
            }
            k++;
        }
        return pre;
    }
}
