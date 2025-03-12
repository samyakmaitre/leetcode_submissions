class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for(int x : nums){
            if(x>0) pos++;
            if(x<0) neg++;
        }

        return Math.max(pos, neg);
    }
}