class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        
        // Hash maps to store mappings from s to t and t to s
        Map<Character, Character> mapStoT = new HashMap<>();
        Map<Character, Character> mapTtoS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Check if there is already a mapping from charS to charT
            if (mapStoT.containsKey(charS)) {
                if (mapStoT.get(charS) != charT) return false; // Mismatch in mapping
            } else {
                mapStoT.put(charS, charT);
            }
            
            // Check if there is already a reverse mapping from charT to charS
            if (mapTtoS.containsKey(charT)) {
                if (mapTtoS.get(charT) != charS) return false; // Mismatch in reverse mapping
            } else {
                mapTtoS.put(charT, charS);
            }
        }
        
        return true;
    }
}
