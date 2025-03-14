class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandy = 0;
        long totalCandies = 0;

        for(int c : candies){
            maxCandy = Math.max(maxCandy, c);
            totalCandies += c;
        }

        if(totalCandies < k) return 0;
        int low = 1, high = maxCandy, result =0;
        while(low<=high){
            int mid = low + (high - low) /2;

            long count = 0;
            for(int c : candies){
                count += c/mid;
            }
            if(count >= k){
                result = mid;
                low = mid +1;
            } else {
                high = mid -1;
            }
        }

        return result;
    }
}