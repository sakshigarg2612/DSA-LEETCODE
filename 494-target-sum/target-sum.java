class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        target = Math.abs(target);
        int totalSum =0;
        for(int num :nums) {
            totalSum+=num;
        }
        int d=(totalSum+target)/2;
        if ((target + totalSum) % 2 != 0 || (target + totalSum) < 0) return 0;
        int dp[][] = new int[nums.length][d+1];
        for(int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return helper(nums,d,nums.length-1,dp);
    }

    int helper(int[] nums, int target,int index, int [][]dp) {
        if(index==0) {
            if(target==0 && nums[0]==0) return 2;
            if(target==nums[index]) return 1;
            if(target==0) return 1;
            return 0;
        } 
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake = helper(nums,target,index-1,dp);
                int take =0;
        if(nums[index]<=target) {
            take = helper(nums,target-nums[index],index-1,dp);
        }
        return dp[index][target]=take+notTake;
    }
}