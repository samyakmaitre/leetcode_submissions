class Solution {
    public int waysToSplitArray(int[] nums) {
        
        long tSum = 0, lSum = 0, rSum = 0, count = 0;

        for(int x : nums){
            tSum += x;
        }

        for(int i = 0; i<nums.length-1; i++){
            lSum += nums[i];
            rSum = tSum - lSum;
            
            if(lSum >= rSum) {
                count++;
            }
        }

        return (int)count;
    }
}