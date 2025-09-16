class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,1);
        int result= 1;
        for(int index=0;index<nums.length;index++) {
            for(int prev=0; prev <index;prev++) {
                if(nums[prev] < nums[index]) {
                    dp[index]= Math.max(dp[index], 1+dp[prev]);
                }
            }
            result= Math.max(result,dp[index]);
        }
        return result;
    }

}
