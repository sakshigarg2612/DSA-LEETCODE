class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int index = nums.length - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                int take = 0;
                if (prev == -1 || nums[prev] < nums[index]) {
                    take = 1 + dp[index + 1][index+1];
                }
                int notTake = dp[index + 1][prev+1];
                dp[index][prev + 1] = Math.max(notTake, take);
            }
        }
        return dp[0][0];
    }

}
