class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask
        HashMap<Integer, Integer> bitmaskToIndex = new HashMap<>();
        // Initial condition: bitmask 0 is seen at index -1 (before the start of the string)
        bitmaskToIndex.put(0, -1);
        
        int bitmask = 0;  // Bitmask to track even/odd counts of vowels
        int maxLength = 0;  // To store the maximum length of the substring
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Update the bitmask based on the current character
            switch (ch) {
                case 'a': bitmask ^= (1 << 0); break;
                case 'e': bitmask ^= (1 << 1); break;
                case 'i': bitmask ^= (1 << 2); break;
                case 'o': bitmask ^= (1 << 3); break;
                case 'u': bitmask ^= (1 << 4); break;
            }
            
            // If this bitmask has been seen before, calculate the length of the substring
            if (bitmaskToIndex.containsKey(bitmask)) {
                maxLength = Math.max(maxLength, i - bitmaskToIndex.get(bitmask));
            } else {
                // Store the first occurrence of this bitmask
                bitmaskToIndex.put(bitmask, i);
            }
        }
        
        return maxLength;
    }
}