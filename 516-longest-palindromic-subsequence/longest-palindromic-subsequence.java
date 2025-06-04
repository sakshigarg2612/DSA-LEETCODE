class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        String s2 = new StringBuilder(s).reverse().toString();
        int[] prev = new int[len];
        prev[0] = s.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len; i++) {
            prev[i] = s.charAt(0) == s2.charAt(i) ? 1 : prev[i - 1];
        }
        for (int i = 1; i < len; i++) {
            int[] curr = new int[len];
             curr[0] = s.charAt(i) == s2.charAt(0) ? 1 : prev[0];
            for (int j = 1; j < len; j++) {
                if (s.charAt(i) == s2.charAt(j)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }
        return prev[len - 1];
    }
}