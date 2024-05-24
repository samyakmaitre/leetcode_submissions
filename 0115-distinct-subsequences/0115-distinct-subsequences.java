class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // Create a 2D dp array
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize dp[i][0] to 1 for all i, since an empty t is a subsequence of any prefix of s
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Fill the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // The answer is in dp[m][n]
        return dp[m][n];
    }
}
