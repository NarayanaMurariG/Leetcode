package arraysAndStrings;


//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//All testcases passed
public class BuyAndSellStockII {

    public static void main(String[] args){
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i] > max){
                max = prices[i];
            }
            if(prices[i] < min){
                min = prices[i];
                max = 0;
            }
            if(max - min > 0){
                maxProfit = maxProfit + max - min;
                min = prices[i];
                max = 0;
            }
        }

        return maxProfit;
    }
}
