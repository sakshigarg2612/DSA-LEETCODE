class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 10000000);
        dp[0] =0;
        for(int i=1; i <=amount ;i++) {
        for(int j=0;j<=coins.length-1;j++) {
            if(i>=coins[j]) {
            dp[i] = Math.min(dp[i] , dp[i-coins[j]]+1);
            }
        }
        }
        return dp[amount]!= 10000000 ? dp[amount] :-1;
    }
}
