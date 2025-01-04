class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];
        int right[] = new int[26];

        for(char c : s.toCharArray()){
            right[c-'a']++;
        }

        Set<String> uniquePalindromes = new HashSet<>();

        for(int i=0; i<n; i++){
            char middle = s.charAt(i);
            right[middle - 'a']--;

            for(int c = 0; c<26; c++){
                if(left[c] > 0 && right[c] > 0){
                    uniquePalindromes.add((char)(c + 'a') + "" + middle + (char)(c + 'a'));
                }
            }

            left[middle - 'a']++;
        }
        return uniquePalindromes.size();
    }
}