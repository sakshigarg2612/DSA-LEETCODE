import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            // Normalize the domino as "min,max" to handle [1,2] ≡ [2,1]
            String key = (a < b ? a + "," + b : b + "," + a);

            count += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }
}
