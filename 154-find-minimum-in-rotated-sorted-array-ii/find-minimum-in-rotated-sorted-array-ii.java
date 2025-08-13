class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low < high) {
            int mid= low+ (high-low)/2;
            min=Math.min(nums[mid],min);
            if(nums[low]==nums[mid]) {
                while(nums[low]==nums[mid] && low<=mid) low++;
            } else if(nums[high]==nums[mid]) {
                 while(nums[high]==nums[mid] && high>=mid) high--;
            } else if(nums[mid]<nums[high]) {
                high =mid-1;
            } else  {
                low =mid+1;
            }
        }
        return nums[low]>min?min:nums[low];
    }
}