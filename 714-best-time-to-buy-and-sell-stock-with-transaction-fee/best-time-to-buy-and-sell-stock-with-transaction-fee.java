class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        // Extra padding to safely access index + 2
        int[][] dp = new int[n + 2][2];

        for (int index = n - 1; index >= 0; index--) {
            // Buy state: either buy now (-price) or skip
            dp[index][0] = Math.max(
                -prices[index] + dp[index + 1][1]-fee,  // buy
                dp[index + 1][0]                    // skip
            );

            // Sell state: either sell now (+price) or skip
            dp[index][1] = Math.max(
                prices[index] + dp[index + 1][0],   // sell + cooldown
                dp[index + 1][1]                    // skip
            );
        }

        return dp[0][0];  // start at day 0 with buy allowed
    }
}
