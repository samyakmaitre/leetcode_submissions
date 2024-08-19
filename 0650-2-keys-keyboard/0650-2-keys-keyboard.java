class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0; // No operations needed for 1 'A'
        
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i; // Maximum steps needed is i (all Paste operations)
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    // If j is a divisor, we can reach i by copying j and pasting (i/j) times
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                    
                    // i/j is also a divisor, do the same check
                    dp[i] = Math.min(dp[i], dp[i / j] + j);
                }
            }
        }
        return dp[n];
    }
}
