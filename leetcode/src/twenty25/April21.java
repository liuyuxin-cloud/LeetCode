package twenty25;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class April21 {
}
class RandomizedSet {


    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            map.put(val, list.size()-1);
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            int index = map.get(val); //得到要删除元素的下标
            int last = list.size()-1;
            map.replace(list.get(last), index); //将map中数组最后一个元素对应的下标更改
            list.set(index, list.get(last)); //将list中数组最后一个元素附到删除位置
            list.remove(list.size()-1);
            map.remove(val); //map中删除元素
            return true;
        }
    }

    public int getRandom() {
        int ran = new Random().nextInt(list.size());
        return list.get(ran);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */