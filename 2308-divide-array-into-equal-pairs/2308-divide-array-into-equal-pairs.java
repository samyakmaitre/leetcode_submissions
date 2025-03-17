class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(Integer x : map.keySet()){
            System.out.println(x);
            if(map.get(x) % 2 != 0) return false;
        } 

        return true;
        
    }
}