package twenty21;

import java.util.*;

public class July7{
    public static void main(String args[]){
        Solution7_7 s = new Solution7_7();
        List<List<Integer>> answer = new ArrayList<>();
        answer = s.generate(2);
        System.out.println(answer);
    }

}
class Solution7_7 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        if(numRows == 1){
            temp.add(1);
            answer.add(temp);
            return answer;
        }
        if(numRows == 2){
            temp.add(1);
            answer.add(temp);
            temp1.add(1);
            temp1.add(1);
            answer.add(temp1);
            return answer;
        }
        if(numRows >= 2){
            temp.add(1);
            answer.add(temp);
            temp1.add(1);
            temp1.add(1);
            answer.add(temp1);

            for(int i=2 ; i<numRows ; i++){
                List<Integer> newList = new ArrayList<>();
                for(int j=0 ; j<i+1 ; j++){
                    if( j==0 ){
                        newList.add(1);
                    }else if( j==i) {
                        newList.add(1);
                    }else {
                        newList.add(answer.get(i - 1).get(j - 1) + answer.get(i - 1).get(j));
                    }
                }
                answer.add(newList);
            }
        }
        return answer;
    }
}
