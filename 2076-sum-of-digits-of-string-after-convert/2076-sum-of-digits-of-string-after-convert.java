class Solution {
    public int getLucky(String s, int k) {
        // Convert string to number
        StringBuilder numStr = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int digit = s.charAt(i) - 'a' + 1;
            numStr.append(digit);
        }
        
        // Convert the number string to an integer and perform the transformations
        int num = 0;
        for(int i = 0; i < numStr.length(); i++) {
            num += Character.getNumericValue(numStr.charAt(i));
        }
        
        // Transform the number k times
        for(int i = 1; i < k; i++) {
            num = summ(num);
        }

        return num;
    }

    // Method to sum the digits of a number
    private int summ(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
