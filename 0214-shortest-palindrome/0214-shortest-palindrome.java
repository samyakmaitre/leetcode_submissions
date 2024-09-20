class Solution {
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev_s;
        int[] lps = new int[combined.length()];
        int j = 0;
        for (int i = 1; i < combined.length(); i++) {
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        int prefixLen = lps[combined.length() - 1];
        String prefix = rev_s.substring(0, rev_s.length() - prefixLen);
        return prefix + s;
    }
}