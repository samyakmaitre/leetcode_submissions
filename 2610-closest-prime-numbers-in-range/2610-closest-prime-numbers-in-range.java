class Solution {
    public int[] closestPrimes(int left, int right) {
        int num1 = -1, num2 = -1;
        int[] result = {-1, -1};

        for (int i = left; i <= right; i++) {
            if (checkPrime(i)) {
                num1 = num2;
                num2 = i;
                
                if (num1 != -1) { // Ensure we have two primes before comparison
                    if (result[0] == -1 || num2 - num1 < result[1] - result[0]) {
                        result[0] = num1;
                        result[1] = num2;
                    }
                }
            }
        }
        return result;
    }

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;  // Fixed to include all values <=1
        for (int i = 2; i * i <= n; i++) {  // More efficient loop
            if (n % i == 0) return false;
        }
        return true;
    }
}