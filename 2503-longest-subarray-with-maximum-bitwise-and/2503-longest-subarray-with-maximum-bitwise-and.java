public class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        
        // Step 1: Find the maximum element in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        
        // Step 2: Find the longest subarray where all elements are equal to maxVal
        int maxLength = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 0;
            }
        }
        
        return maxLength;
    }
}