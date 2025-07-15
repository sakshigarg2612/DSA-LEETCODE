class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        
        // Future states
        int aheadBuy = 0;
        int aheadSell = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currBuy = Math.max(
                -prices[i] - fee + aheadSell,  // Buy and pay fee
                aheadBuy                       // Skip
            );

            int currSell = Math.max(
                prices[i] + aheadBuy,          // Sell
                aheadSell                      // Skip
            );

            aheadBuy = currBuy;
            aheadSell = currSell;
        }

        return aheadBuy;  // Start at day 0 with option to buy
    }
}
