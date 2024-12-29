class Solution {
    public int numWays(String[] words, String target) {
        int mod = 1_000_000_007;
        int m = target.length();
        int n = words[0].length();
        
        // Step 1: Precompute frequency of each character at each position
        int[][] freq = new int[n][26];
        for (String word : words) {
            for (int j = 0; j < n; j++) {
                freq[j][word.charAt(j) - 'a']++;
            }
        }
        
        // Step 2: Dynamic Programming
        long[] dp = new long[m + 1];
        dp[0] = 1; // Base case: one way to form an empty target
        
        for (int j = 0; j < n; j++) {
            // Traverse target from back to front to avoid overwriting dp values
            for (int i = m - 1; i >= 0; i--) {
                char targetChar = target.charAt(i);
                dp[i + 1] += dp[i] * freq[j][targetChar - 'a'] % mod;
                dp[i + 1] %= mod;
            }
        }
        
        return (int) dp[m];
    }
}
