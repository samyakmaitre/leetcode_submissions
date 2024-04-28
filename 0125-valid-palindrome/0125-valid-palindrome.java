class Solution {
    public boolean isPalindrome(String s) {
        // Convert to lowercase
        s = s.toLowerCase();
        
        // Remove non-alphanumeric characters
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String filteredString = sb.toString();
        
        // Check if the filtered string is a palindrome
        int left = 0, right = filteredString.length() - 1;
        while (left < right) {
            if (filteredString.charAt(left) != filteredString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
