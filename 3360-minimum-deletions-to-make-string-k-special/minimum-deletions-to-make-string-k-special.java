class Solution {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Integer> freqs = new ArrayList<>(freqMap.values());
        Collections.sort(freqs);

        int n = freqs.size();
        int[] prefixSum = new int[n];
        prefixSum[0] = freqs.get(0);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + freqs.get(i);
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int base = freqs.get(i);
            int hi = base + k;

            // All frequencies < base are deleted completely → prefixSum[i - 1]
            int delLow = (i > 0) ? prefixSum[i - 1] : 0;

            // All frequencies > hi are reduced to hi
            int delHigh = 0;
            for (int j = i + 1; j < n; j++) {
                if (freqs.get(j) > hi) {
                    delHigh += freqs.get(j) - hi;
                }
            }

            result = Math.min(result, delLow + delHigh);
        }

        return result;
    }
}
