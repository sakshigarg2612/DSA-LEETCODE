class Solution {
    public int findMin(int[] nums) {
        // int low=0;
        // int high = nums.length-1;
        // while(low < high) {
        //     int mid = low + (high-low)/2;
        //     if(nums[low]<nums[mid] ) {
        //         if(nums[low] <nums[high]) return nums[low];
        //         if(nums[low]>=nums[high]) {
        //             low = mid+1;
        //         }
        //     } else if(nums[low]==nums[mid]) {
        //         low = mid;
        //     }
        // }
        Arrays.sort(nums);
        return nums[0];
    }
}