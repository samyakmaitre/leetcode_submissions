class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mPlusn = rolls.length + n;
        int mSum = 0;
        for (int i = 0; i < rolls.length; i++) {
            mSum += rolls[i];
        }
        
        int mnSum = mean * mPlusn;
        int nSum = mnSum - mSum;

        if (nSum < n || nSum > 6 * n) {
            return new int[0];
        }
        
        int[] result = new int[n];
        int avg = nSum / n;
        int remainder = nSum % n;

        for (int i = 0; i < n; i++) {
            result[i] = avg;
            if (i < remainder) {
                result[i]++;
            }
        }

        return result;
    }
}
