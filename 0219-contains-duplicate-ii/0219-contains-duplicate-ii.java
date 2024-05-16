class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                int prevIndex = indexMap.get(nums[i]);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            indexMap.put(nums[i], i);
        }
        
        return false;
    }
}