class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int leftZeros = 0;
        int rightOnes = 0;

        for(char ch : s.toCharArray()){
            if(ch == '1') totalOnes++;
        }

        int maxScore = 0;

        for(int i =0; i< s.length() - 1; i++){
            if(s.charAt(i) == '0'){
                leftZeros++;
            } else {
                totalOnes--;
            }

            int score = leftZeros + totalOnes;
            maxScore = Math.max(maxScore, score);
        }

        return maxScore;
    }
}