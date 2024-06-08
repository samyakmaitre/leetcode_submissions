import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];
            
            // Check if the complement is in the hash map
            if (map.containsKey(complement)) {
                // If found, return the indices of the current element and the complement
                return new int[] { map.get(complement), i };
            }
            
            // If not found, add the current element and its index to the hash map
            map.put(nums[i], i);
        }
        
        // In case no solution is found (though the problem states there will be one solution)
        throw new IllegalArgumentException("No two sum solution");
    }
}
