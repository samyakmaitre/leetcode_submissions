class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        // Iterate through each character in the column title
        for (int i = 0; i < columnTitle.length(); i++) {
            // Calculate the value of the current character
            int value = columnTitle.charAt(i) - 'A' + 1;
            // Update the result by multiplying it by 26 and adding the value of the current character
            result = result * 26 + value;
        }
        return result;
    }
}
