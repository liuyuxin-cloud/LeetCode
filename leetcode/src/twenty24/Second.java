package twenty24;

import java.util.*;

public class Second {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map1 = new HashMap<>(), map2 = new HashMap();
        HashMap<Integer, Integer> res1 = new HashMap<>(), res2 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        for (int i = 0; i < num1*2; i += 2) {
            int xi = scanner.nextInt();
            int zhi = scanner.nextInt();
            map1.put(zhi, xi);
        }
        int num2 = scanner.nextInt();
        for (int i = 0; i < num2*2; i += 2) {
            int xi = scanner.nextInt();
            int zhi = scanner.nextInt();
            map2.put(zhi, xi);
        }
        for (HashMap.Entry<Integer, Integer> i : map1.entrySet()) {
            if (map2.containsKey(i.getKey())) {
                map2.replace(i.getKey(), map2.get(i.getKey()), map2.get(i.getKey()) + map1.get(i.getKey()));
            }else {
                map2.put(i.getKey(), i.getValue());

            }
        }
        ArrayList<Integer> list= new ArrayList<>(map2.keySet());
        //调用sort方法并重写比较器进行升/降序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1<o2?1:-1;
            }
        });
        int flag = 1;
        Iterator<Integer> iterator = list.iterator();
        //迭代排序后的key的list
        while ((iterator.hasNext())){
            Integer key = iterator.next();
            int value = map2.get(key);
            if (flag == 1) {
                System.out.print(key+" "+value);
                flag = 0;
                continue;
            }
            System.out.print(" "+value+" "+key);
        }
    }
}
