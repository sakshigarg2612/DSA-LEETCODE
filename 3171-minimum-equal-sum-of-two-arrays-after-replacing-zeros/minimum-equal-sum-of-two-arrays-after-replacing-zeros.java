class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long zero1 = 0;
        long zero2 = 0;
        long sum1 = 0;
        long sum2 = 0;
        for (int i : nums1) {
            if (i == 0) {
                zero1++;
            } else {
                sum1 = sum1 + i;
            }
        }

        for (int i : nums2) {
            if (i == 0) {
                zero2++;
            } else {
                sum2 = sum2 + i;
            }
        }
        sum1 = sum1 + zero1;
        sum2 = sum2 + zero2;
        if (sum1 > sum2) {
            if (zero2 == 0) {
                return -1;
            } else {
                return sum1;
            }
        } else if (sum1 < sum2) {
            if (zero1 == 0) {
                return -1;
            } else {
                return sum2;
            }
        } else {
            return sum1;
        }

    }
}