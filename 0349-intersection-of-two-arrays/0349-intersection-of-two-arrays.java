class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //convert arrays to set
        Set<Integer> set1 = new HashSet<>();
        for(int x : nums1){
            set1.add(x);
        }

        Set<Integer> set2 = new HashSet<>();
        for(int x : nums2){
            set2.add(x);
        }

        //retain common values
        set1.retainAll(set2);

        //set to array
        int[] result =new int[set1.size()];
        int i=0;
        for(int num : set1){
            result[i++] = num;
        }

        return result;
    }

}