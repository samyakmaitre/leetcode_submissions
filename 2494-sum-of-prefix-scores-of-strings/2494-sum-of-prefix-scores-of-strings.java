class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;

        TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
                current.count++;
            }
        }

        int getScore(String word) {
            TrieNode current = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                current = current.children[index];
                score += current.count;
            }
            return score;
        }
    }

    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
        }
        
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getScore(words[i]);
        }
        
        return result;
    }
}
