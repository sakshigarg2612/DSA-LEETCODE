class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==1 && target==nums[0]) return new int[]{0,0};
        int result[] = { -1, -1 };
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid - 1;
                high = mid + 1;
                while (low >= 0 && nums[low] == target)
                    low--;
                result[0] = low + 1;
                while (high < nums.length && nums[high] == target)
                    high++;
                result[1] = high - 1;
                return result;
            } else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return result;
    }
}
