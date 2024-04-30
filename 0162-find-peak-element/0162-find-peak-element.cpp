class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        
        // Binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            // If the middle element is smaller than its right neighbor,
            // there must be a peak on the right side
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } 
            // If the middle element is larger than its right neighbor,
            // there must be a peak on the left side (or the middle element itself is a peak)
            else {
                right = mid;
            }
        }
        
        // At the end of the binary search, 'left' and 'right' will be equal,
        // and they will point to a peak element
        return left;
    }
};
