class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        // Edge case: if target is greater than the last character in the array
        if (target >= letters[right]) {
            return letters[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // At this point, left points to the smallest character greater than target
        return letters[left];
    }
}
