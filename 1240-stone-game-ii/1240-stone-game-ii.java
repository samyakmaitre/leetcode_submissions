class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        // prefix sums to help calculate the sum of piles[i] to the end
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // dp[i][M] represents the maximum stones Alice can get starting from pile i with M
        int[][] dp = new int[n][n + 1];

        // Fill the dp array from the last pile backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int M = 1; M <= n; M++) {
                if (i + 2 * M >= n) {
                    // If Alice can take all the remaining piles
                    dp[i][M] = suffixSum[i];
                } else {
                    for (int X = 1; X <= 2 * M; X++) {
                        dp[i][M] = Math.max(dp[i][M], suffixSum[i] - dp[i + X][Math.max(M, X)]);
                    }
                }
            }
        }

        return dp[0][1];
    }
}
