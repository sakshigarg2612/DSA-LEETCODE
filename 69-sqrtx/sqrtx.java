class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int high = x/2;
        int low = 1;
        int result = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid  > x/mid) {
                high = mid - 1;
            } else{
                low = mid + 1;
                result = mid;
            } 
        }
        return result;
    }
}