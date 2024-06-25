class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Convert jewels to a set for O(1) lookups
        Set<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }
        
        // Initialize the counter for jewels in stones
        int count = 0;
        
        // Iterate through stones and count jewels
        for (char stone : stones.toCharArray()) {
            if (jewelSet.contains(stone)) {
                count++;
            }
        }
        
        // Return the final count
        return count;
    }
}
