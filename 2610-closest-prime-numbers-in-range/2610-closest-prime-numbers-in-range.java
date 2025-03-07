class Solution {
    public int[] closestPrimes(int left, int right) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int i = left; i <= right; i++) {
            if (checkPrime(i)) arr.add(i);
        }

        if (arr.size() < 2) return new int[]{-1, -1}; // No valid prime pair found

        int min = Integer.MAX_VALUE;
        int r = -1;

        for (int i = 0; i < arr.size() - 1; i++) {
            int diff = arr.get(i + 1) - arr.get(i);
            if (diff < min) {
                min = diff;
                r = i;
            }
        }

        return new int[]{arr.get(r), arr.get(r + 1)};
    }

    public static boolean checkPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
