class Solution{
    public int[] minOperations(String boxes){
        int n = boxes.length();
        int[] result = new int[n];
        int count = 0;
        int moves = 0;

        for(int i=0; i<n; i++){
            result[i] += moves;
            count += boxes.charAt(i) - '0';
            moves += count;
        }

        count = 0;
        moves = 0;

        for(int i=n-1; i>=0; i--){
            result[i] += moves;
            count += boxes.charAt(i) - '0';
            moves += count;
        }

        return result;
    }
}