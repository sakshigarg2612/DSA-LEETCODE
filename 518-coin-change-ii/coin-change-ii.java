class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int [coins.length][amount + 1];
        for(int[] row : dp) {
        Arrays.fill(row, -1);
        }
        return helper(coins.length - 1, amount, coins, dp);
    }

    int helper(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            if (target % coins[index] == 0)
                return 1;
            return 0;
        }
        if (dp[index][target] != -1)
            return dp[index][target];
        int notTake = helper(index - 1, target, coins, dp);
        int take = 0;
        if (coins[index] <= target) {
            take = helper(index, target - coins[index], coins, dp);
        }
        return dp[index][target] = take + notTake;
    }
}