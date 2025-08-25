class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            set.add(arr[i]);
        }
        int n = arr.length;
        if ((max - min) % (n - 1) != 0)
            return false;
        int diff = (max - min) / (n - 1);
        if (diff == 0)
            return true;
        for (int i = 0; i < n; i++) {
            int val = min + i * diff;
            if (!set.contains(val))
                return false;
        }
        return true;
    }
}