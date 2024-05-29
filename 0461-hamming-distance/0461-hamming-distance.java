class Solution {
    public int hammingDistance(int x, int y) {
        // Step 1: XOR x and y
        int xor = x ^ y;
        
        // Step 2: Count the number of 1s in the result
        int count = 0;
        while (xor != 0) {
            count += xor & 1; // Check the least significant bit
            xor >>= 1;        // Right shift to check the next bit
        }
        
        return count;
    }
}
