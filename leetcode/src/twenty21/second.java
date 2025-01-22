package twenty21;

/**
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
class second {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int tmp[] = new int[501];
        for ( int e : arr ) tmp[e]++;
        for ( int i = 500 ; i > 0 ; i-- ){
            if ( i == tmp[i] )
                return i;
        }
        return -1;

    }
}
