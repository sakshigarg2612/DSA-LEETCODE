class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        // Always let word2 be the shorter one to minimize space
        if (n > m) return minDistance(word2, word1);

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }

        return n+m-2*dp[n];
    }
}