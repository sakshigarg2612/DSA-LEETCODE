class Solution {
    public int maxSubArray(int[] nums) {
        int maxE = nums[0];
        int maxS =nums[0];
        for(int i=1;i <nums.length;i++) {
            maxE = Math.max(maxE +nums[i],nums[i]);
            if(maxE > maxS) {
                maxS= maxE;
            } 
        }
        return maxS;
    }
}