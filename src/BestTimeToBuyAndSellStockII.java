
public class BestTimeToBuyAndSellStockII {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;        
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
    
    /** 
     * Learning Points:
     * 
     * Instead of buying at the lowest point and selling at highest point,
     * the overall return of buying and selling (whenever a positive profit
     * can be made) is higher.
     * 
     * Instead of tracking the lowest and highest point as you traverse the array, 
     * use differences between array[i] and array[i - 1]. If there is a positive 
     * difference, add it into profit. 
     */
}
