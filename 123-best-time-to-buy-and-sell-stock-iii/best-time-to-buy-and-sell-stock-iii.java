class Solution {
    public int maxProfit(int[] prices) {
    int dp[][] = new int[prices.length][4];
    for(int [] row : dp) {
        Arrays.fill(row,-1);
    }
        return profit(0,0,prices,dp);
    }

    int profit(int index, int trans, int[] prices,int[][] dp) {
        if(trans==4) return 0;
        if(index== prices.length) return 0;
        if(dp[index][trans]!=-1) return dp[index][trans];
        if(trans%2 ==0) {
            return dp[index][trans]=Math.max(-prices[index]+profit(index+1,trans+1,prices,dp) , profit(index+1,trans,prices,dp));
        } 
        return dp[index][trans]=Math.max(prices[index]+profit(index+1,trans+1,prices,dp),profit(index+1,trans,prices,dp));
    }
}

        // int after[][] = new int[2][3];
        // int [][] curr = new int[2][3];
        // for (int i = prices.length-1; i>=0;i--) {
        //     for (int j = 0; j < 2; j++) {
        //         for (int k = 1; k < 3; k++) {
        //             if (j == 1) {
        //                 curr[j][k] = Math.max(-prices[i] + after[0][k],
        //                         after[1][k]);
        //             } else {
        //                curr[j][k] = Math.max(prices[i] + after[1][k-1],
        //                        after[0][k] );
        //             }
        //         }
        //         after= curr;
        //     }
        // }
        // return after[1][2];