class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return backTrack(0, nums, -1,dp);
    }

    int backTrack(int index, int[] nums, int prev,int[][] dp) {
        if (index == nums.length)
            return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int take = 0;
        if (prev == -1 || nums[prev] < nums[index]) {
            take = 1 + backTrack(index + 1, nums, index,dp);
        }
        int notTake = backTrack(index + 1, nums, prev,dp);
        return dp[index][prev+1]=Math.max(notTake, take);
    }
}
