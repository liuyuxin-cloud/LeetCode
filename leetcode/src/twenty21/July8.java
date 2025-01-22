package twenty21;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 */
public class July8 {
    public static void main(String[] args){
        Solution7_8_1 s = new Solution7_8_1();
        List<String> answer = s.readBinaryWatch(5);
        System.out.println(answer);
    }
}



/*暴力解法*/
class Solution7_8_1 {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<String>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    ans.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ans;
    }
}
/**
 * 为了方便计算，分别设置了小时数组和分钟数组
 * 递归的四个参数分别代表：剩余需要点亮的灯数量，从索引index开始往后点亮灯，当前小时数，当前分钟数
 * 每次进入递归后，先判断当前小时数和分钟数是否符合要求，不符合直接return
 * for循环枚举点亮灯的情况，从index枚举到10，每次枚举，
 */
class Solution7_8_2 {
    int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    public void backtrack(int num, int index, int hour, int minute){
        if(hour > 11 || minute > 59)
            return;
        if(num == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());
            return;
        }
        for(int i = index; i < 10; i++){
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}