class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        Set<Character> allowedSet = new HashSet<>();
        
        for(char ch : allowed.toCharArray()){
            allowedSet.add(ch);
        }

        int count = 0;
        for(int i=0; i<words.length; i++){
            
            String word = words[i];
            int n = (word.length())-1;
            boolean match = true;
            while(n>=0){
                if (!allowedSet.contains(word.charAt(n)))
                {
                    match = false;
                }
                n -= 1;
            }
            if(match){
                count++;
            }
        }

        return count;
    }
}