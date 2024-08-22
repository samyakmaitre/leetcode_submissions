class Solution {
    public int findComplement(int num) {
        // Step 1: Calculate the number of bits in the binary representation of num
        int bitLength = Integer.toBinaryString(num).length();
        
        // Step 2: Create a bitmask with all bits set to 1 of the same length as num's binary representation
        int bitmask = (1 << bitLength) - 1;
        
        // Step 3: XOR num with the bitmask to get the complement
        return num ^ bitmask;
    }
}
