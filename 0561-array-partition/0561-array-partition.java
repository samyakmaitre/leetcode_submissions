class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for(int i =0; i<nums.length-1;i++){
            if(i%2==0)
            maxSum += nums[i];
        }
        return maxSum;
    }
}