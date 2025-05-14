class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 10000;
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    continue;
                }
                if (j == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    continue;
                }
                dp[i][j] = matrix[i][j] + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i - 1][j + 1]);
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n ; i++) {
            minSum = Math.min(minSum, dp[n - 1][i]);
        }
        return minSum;
    }
}