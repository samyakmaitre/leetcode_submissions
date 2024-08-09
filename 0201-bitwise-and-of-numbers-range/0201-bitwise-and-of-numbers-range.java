class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        // Find the common prefix
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        
        // Return the result after shifting the common prefix back to the left
        return left << shift;
    }
}
