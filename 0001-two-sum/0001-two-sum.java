class Solution {
    public int[] twoSum(int[] nums, int target){
        //create a hashmap to store the the diff of target and current number
        Map<Integer, Integer> map = new HashMap<>();
        
        //Interate over the array
        for (int i=0; i<nums.length; i++){
    
            //if the complement is in the map, we found the solution
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]),i};
            }
            //Otherwise, add the current number and its index to the map
            map.put(nums[i],i);
        }
        
        //in case of no solution
        throw new IllegalArgumentException("No solution");
    }
}