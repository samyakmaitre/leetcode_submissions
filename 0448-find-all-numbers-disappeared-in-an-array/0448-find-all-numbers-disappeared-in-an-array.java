class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1] ;
        List<Integer> ans = new ArrayList<>(); 
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        for(int i=1;i<=n;i++){
            if(freq[i] == 0)
                ans.add(i);
        }
        return ans;
    }
}