class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;

        Set<Integer> set1 = new HashSet<>();
        for(int x : nums){
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for( int x= 1; x<=len; x++){
            set2.add(x);
        }

        set2.removeAll(set1);

        ArrayList<Integer> result = new ArrayList<>();
        int i=0;
        for(int x : set2){
            result.add(x);
        }
        return result;
    }
}