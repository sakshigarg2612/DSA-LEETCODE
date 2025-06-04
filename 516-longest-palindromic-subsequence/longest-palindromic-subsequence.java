class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len][len];
        dp[0][0] = s.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = s.charAt(i) == s2.charAt(0) ? 1 : dp[i - 1][0];
            dp[0][i] = s.charAt(0) == s2.charAt(i) ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (s.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len - 1][len - 1];
    }
}