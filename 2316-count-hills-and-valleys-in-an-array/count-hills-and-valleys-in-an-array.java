class Solution {
    public int countHillValley(int[] nums) {
        int result = 0;
        int i = 0;
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            while (j<nums.length && nums[i] == nums[j]) {
                j++;
            }
            if ((i - 1) >= 0 && j < nums.length) {
                if ((nums[i - 1] < nums[i] && nums[j] < nums[i]) || (nums[i - 1] > nums[i] && nums[j] >nums[i])) {
                    result++;
                }
            }
            i = j;
            j = i + 1;
        }
        return result;
    }
}