class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (seen.contains(sum)) {
                return false; // Cycle detected
            }
            seen.add(sum);
            n = sum;
        }
        
        return true; // Number is happy
    }
}