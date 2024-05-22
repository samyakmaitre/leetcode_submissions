class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Step 1: Create a count map for the licensePlate letters
        Map<Character, Integer> licenseMap = new HashMap<>();
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                licenseMap.put(c, licenseMap.getOrDefault(c, 0) + 1);
            }
        }

        // Step 2: Iterate over words to find the shortest completing word
        String result = null;
        for (String word : words) {
            if (isCompletingWord(word, licenseMap)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    private boolean isCompletingWord(String word, Map<Character, Integer> licenseMap) {
        Map<Character, Integer> wordMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            c = Character.toLowerCase(c);
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : licenseMap.entrySet()) {
            if (wordMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}