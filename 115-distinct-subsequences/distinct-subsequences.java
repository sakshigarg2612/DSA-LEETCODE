class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int j = 1; j < n; j++) {
            if (s.charAt(j) == t.charAt(0))
                dp[j][0] = dp[j - 1][0] + 1;
            else
                dp[j][0] = dp[j - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int take = 0;
                if (s.charAt(i) == t.charAt(j)) {
                    take = dp[i - 1][j - 1];
                }
                int notTake = dp[i - 1][j];
                dp[i][j] = take + notTake;
            }
        }
        return dp[n - 1][m - 1];
    }
}