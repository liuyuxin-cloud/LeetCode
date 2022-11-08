package twenty22;

import java.util.ArrayList;
import java.util.List;

public class November8_1 {
}
class Solution11_8_1 {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1); //保留数字部分
        for(int i = 1; i < s.length(); i++) {
            for(String x: genNums(s.substring(0, i))){ //x坐标通过小数点分割出合法数字
                for(String y: genNums(s.substring(i))) {//y同理
                    result.add(new StringBuilder("(").append(x).append(",").append(y).append(")").toString());
                }
            }
        }
        return result;
    }

    private List<String> genNums(String num) {
        List<String> list = new ArrayList<>();
        int i = 1;
        String left, right;
        while(i <= num.length()) {
            left = num .substring(0, i);
            right = num.substring(i++);
            if ((!left.equals("0") && left.charAt(0) == '0') || //整数不允许以0开头，除非是0本身
                    (!right.isEmpty() && right.charAt(right.length() - 1) == '0')) //小数不允许以0结尾
            {
                continue;
            }
            if(right.isEmpty()) list.add(left);
            else list.add(new StringBuilder(left).append(".").append(right).toString());
        }
        return list;
    }
}