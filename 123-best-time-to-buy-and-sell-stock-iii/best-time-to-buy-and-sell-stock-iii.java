class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][]= new int[prices.length][2][3];
        for(int i=0;i <prices.length;i++) {
            for(int j=0;j<2;j++) {
                for(int k=0;k<3;k++) {
                    dp[i][j][k] =-1;
                }
            }
        }
        return profit(0,1,2,prices,dp);
    }

    int profit(int index, int buy , int cap,int[] prices,int[][][] dp) {
        if(cap==0) return 0;
        if(index==prices.length) return 0;
        if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
        if(buy == 1) {
            return dp[index][buy][cap]=Math.max(-prices[index]+profit(index+1,0,cap,prices,dp) , profit(index+1,1,cap,prices,dp));
        } else {
            return  dp[index][buy][cap]=Math.max(prices[index]+profit(index+1,1,cap-1,prices,dp) , profit(index+1,0,cap,prices,dp));
        }
    }
}