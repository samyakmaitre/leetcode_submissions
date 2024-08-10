class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        double result = 0;
        ArrayList<Integer> arr = new ArrayList<>();        
        for(int i =0; i<n; i++){
            arr.add(nums1[i]);
        }
        for(int i =0; i<m; i++){
            arr.add(nums2[i]);
        }
        Collections.sort(arr);

        if((n+m)%2==0){
            result = (arr.get((n+m)/2) + arr.get(((n+m)/2)-1))/2f;
            return result*1f;
        }else{
            result = arr.get((n+m)/2);
            return result*1f;
        }
    }
}