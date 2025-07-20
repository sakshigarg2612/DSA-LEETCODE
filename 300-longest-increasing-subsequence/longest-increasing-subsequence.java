class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        return helper(0,nums,-1,dp);
    }

    int helper(int index, int[] nums, int prev,int[][] dp) { 
        if( index == nums.length) {
            return 0;
        }
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int notTake = helper(index+1,nums,prev,dp);
        // take
        int take =0;
        if(prev==-1 || (prev !=-1 && nums[prev]<nums[index])) {
            take = helper(index+1,nums,index,dp)+1;
        } 
        return dp[index][prev+1]=Math.max(take, notTake);
    }
}
