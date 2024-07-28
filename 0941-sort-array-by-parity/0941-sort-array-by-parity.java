class Solution {
    public int[] sortArrayByParity(int[] nums) 
    {
        int e = 0;
        int o = nums.length-1;

        while(e<o)
        {
            while(e<o && nums[e]%2==0){
                e++;
            }
            while(e<o && nums[o]%2!=0){
                o--;
            }
            //swap
            if(e<o){
                int temp = nums[e];
                nums[e] = nums[o];
                nums[o] = temp;
                e++;
                o--;
            }
            
        }
        return nums;
    }
}