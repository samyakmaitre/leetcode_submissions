class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxElement = nums[i];

            // Check if the subarray nums[i..i+k-1] is consecutive and sorted
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] != nums[j - 1] + 1) {
                    isConsecutive = false;
                    break;
                }
                maxElement = Math.max(maxElement, nums[j]);
            }

            // Assign power based on the condition
            results[i] = isConsecutive ? maxElement : -1;
        }

        return results;
    }
}
