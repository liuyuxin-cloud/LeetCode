/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
import java.util.Stack;

public class October9 {
    public static void main(String[] args){
        Solution8_14 s = new Solution8_14();
        System.out.println(s.isValid("(])"));
    }
}

class Solution8_14 {
    public boolean isValid(String s) {
        int len = s.length();
        Stack stack = new Stack();
        for(int i = 0 ; i < len ; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.size() == 0){
                    return false;
                }
                else if(c == ')' && stack.peek().equals('(') || c == ']' && stack.peek().equals('[') || c == '}' && stack.peek().equals('{')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}