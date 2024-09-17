class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String combined = s1 + " " + s2;
        String[] words = combined.split(" ");
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        List<String> uncommonWords = new ArrayList<>();
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) == 1) {
                uncommonWords.add(word);
            }
        }
        
        return uncommonWords.toArray(new String[0]);
    }
}