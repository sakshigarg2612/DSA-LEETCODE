class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(m - 1, n - 1, text1, text2, dp);
    }

    int helper(int i, int j, String text1, String text2,int[][]dp) {
        if(i <0 || j<0) {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return helper(i - 1, j - 1, text1, text2,dp) + 1;
        }
        // if (i == 0 && j != 0) {
        //     return helper(i, j - 1, text1, text2,dp);
        // }
        // if (i != 0 && j == 0) {
        //     return helper(i-1, j, text1, text2,dp);
        // }
        int move1 = helper(i - 1, j, text1, text2,dp);
        int move2 = helper(i, j - 1, text1, text2,dp);
        return dp[i][j] = Math.max(move1, move2);
    }
}
