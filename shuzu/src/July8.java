import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.StrictMath.abs;

public class July8 {
    public static void main(String[] args){
        Solution7_8 s = new Solution7_8();
        List<List<String>> answer = new ArrayList<>();
        answer = s.solveNQueens(8);
        System.out.println(answer);
    }
}

class Solution7_8 {
    int k;
    public List<List<String>> solveNQueens(int n) {
        int[] temp = new int[n];
        int i=0;
        Arrays.fill(temp,0);
        List<String> solution= new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();
        answer = solve(temp,solution,answer,n,0);
        return answer;
    }

    public List<List<String>> solve(int[] temp,List<String> s,List<List<String>> mList,int n,int i){
        int j;
        if( i==n-1 ){
            for(k=0 ; k<n ; k++){
                int m=temp[k];
                char[] row = new char[n];
                Arrays.fill(row,'.');
                row[m] = 'Q';
                s.add(new String(row));

            }
            mList.add(s);
            Arrays.fill(temp,0);
        }
        for(j=0 ; j<n ; j++){
            for( k = 0 ; k < n ; k++ ) {
                if (temp[k] == j || abs(temp[k] - j) == abs(k - i)) {
                    break;
                }
            }
            if(k == n){
                temp[n-1] = j;
                solve(temp,s,mList,n,i+1);
                temp[n-1] = 0;
            }
        }
        return mList;
    }
}
/*TODO  此题未完成  待编辑*/