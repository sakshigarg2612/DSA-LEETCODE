class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] => true if s[0..i-1] matches p[0..j-1]
        boolean[][] dp = new boolean[n + 1][m + 1];

        // empty string matches empty pattern
        dp[0][0] = true;

        // Fill first row: empty string with pattern
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' can match empty (dp[i][j-1]) or one more char (dp[i-1][j])
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }
}

        // MEMOIZATION
        //     for(int[] row : dp) Arrays.fill(row,-1);
        //     return helper(n-1, m-1, s,p,dp);
        // }

        // boolean helper(int i, int j,String s, String p,int[][] dp) {
        //     if(j <0 && i<0) return true;
        //     if(j<0 && i >=0) return false;
        //     if(i<0 && j >=0) {
        //         for(int k =0; k <=j;k++) {
        //             if(p.charAt(k)!='*') return false;
        //         }
        //         return true;
        //     }
        //     if(dp[i][j] !=-1) return dp[i][j]==1 ?true : false;
        //     if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
        //         dp[i][j] = helper(i-1,j-1,s,p,dp) ? 1:0;
        //         return helper(i-1,j-1,s,p,dp);
        //     }
        //     if(p.charAt(j) =='*') {
        //         dp[i][j] = helper(i-1,j,s,p,dp) || helper(i,j-1,s,p,dp) ? 1 :0;
        //         return helper(i-1,j,s,p,dp) || helper(i,j-1,s,p,dp);
        //     }
        //     dp[i][j] =0;
        //     return false;