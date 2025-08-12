class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length][nums.length+1];
     return lis(0,nums,-1,dp);
    }

    int lis(int index, int[] nums,int prev,Integer[][] dp) {
        if(index == nums.length) {
            return 0;
        }
        if(dp[index][prev+1]!=null) return dp[index][prev+1];
        int notTake = lis(index+1,nums,prev,dp);
        int take =0;
        if(prev==-1 || nums[index]>nums[prev]) {
           take= lis(index+1,nums, index,dp)+1;
        }
        return dp[index][prev+1]=Math.max(take,notTake);
    }

}
