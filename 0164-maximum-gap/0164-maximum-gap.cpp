class Solution {
public:
    int maximumGap(std::vector<int>& nums) {
        int n = nums.size();
        
        if (n < 2) return 0; // Return 0 if the array contains less than 2 elements
        
        // Find the maximum element in the array
        int maxElement = *max_element(nums.begin(), nums.end());
        
        // Perform Radix Sort
        int exp = 1;
        std::vector<int> temp(n), count(10);
        
        while (maxElement / exp > 0) {
            // Count the occurrences of digits
            std::fill(count.begin(), count.end(), 0);
            for (int i = 0; i < n; ++i)
                count[(nums[i] / exp) % 10]++;
            
            // Calculate cumulative count
            for (int i = 1; i < 10; ++i)
                count[i] += count[i - 1];
            
            // Build the sorted array
            for (int i = n - 1; i >= 0; --i) {
                temp[count[(nums[i] / exp) % 10] - 1] = nums[i];
                count[(nums[i] / exp) % 10]--;
            }
            
            // Copy the sorted array to nums
            for (int i = 0; i < n; ++i)
                nums[i] = temp[i];
            
            // Move to the next digit
            exp *= 10;
        }
        
        // Calculate the maximum difference between two successive elements
        int maxDiff = 0;
        for (int i = 1; i < n; ++i) {
            maxDiff = std::max(maxDiff, nums[i] - nums[i - 1]);
        }
        
        return maxDiff;
    }
};