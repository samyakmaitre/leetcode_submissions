class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // Split the text into words
        String[] words = text.split(" ");
        // Create a set of broken letters for quick lookup
        Set<Character> brokenSet = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            brokenSet.add(c);
        }

        int count = 0;

        // Iterate through each word
        for (String word : words) {
            boolean canType = true;
            // Check if the word contains any broken letter
            for (char c : word.toCharArray()) {
                if (brokenSet.contains(c)) {
                    canType = false;
                    break;
                }
            }
            // If the word can be typed, increment the count
            if (canType) {
                count += 1;
            }
        }

        return count;
    }
}
