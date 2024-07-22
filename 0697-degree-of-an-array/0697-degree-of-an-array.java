class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstOcc = new HashMap<>();
        Map<Integer, Integer> lastOcc = new HashMap<>();

        int degree = 0; 

        for (int i=0; i<nums.length; i++){
            int num = nums[i];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            if(!firstOcc.containsKey(num)){
                firstOcc.put(num,i);
            }
            lastOcc.put(num,i);
            degree = Math.max(degree, freqMap.get(num));
        }

        int minLength = nums.length;

        for(int num : freqMap.keySet()){
            if(freqMap.get(num)==degree){
                minLength = Math.min(minLength, lastOcc.get(num)-firstOcc.get(num)+1);
            }
        }

        return minLength;
    }
}