class Solution {
    public int maxProfit(int[] prices) {
        int after[][] = new int[2][3];
        int [][] curr = new int[2][3];
        for (int i = prices.length-1; i>=0;i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    if (j == 1) {
                        curr[j][k] = Math.max(-prices[i] + after[0][k],
                                after[1][k]);
                    } else {
                       curr[j][k] = Math.max(prices[i] + after[1][k-1],
                               after[0][k] );
                    }
                }
                after= curr;
            }
        }
        return after[1][2];
    }

}