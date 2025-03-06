class Solution {
    public long coloredCells(int n) {
        long result = 1;
        for(long i=0; i<n; i++){
            result = result + (4*i);
        }
        return result;
    }
}