public class July22 {
    public static void main(String[] args){
        Solution7_22 s = new Solution7_22();
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}
class Solution7_22 {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int price : prices) {
            if (price < minprice) {
                minprice = price;
            } else if (price - minprice > maxprofit) {
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }
}