class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        
        long[] candidates = new long[5];
        
        candidates[0] = getMirroredPalindrome(n);
        
        candidates[1] = (long)Math.pow(10, len - 1) - 1;
        
        candidates[2] = (long)Math.pow(10, len) + 1;
        
        long firstHalf = Long.parseLong(n.substring(0, (len + 1) / 2));
        
        candidates[3] = getMirroredPalindrome(String.valueOf(firstHalf - 1) + n.substring((len + 1) / 2));
        candidates[4] = getMirroredPalindrome(String.valueOf(firstHalf + 1) + n.substring((len + 1) / 2));
        
        long closest = -1;
        for (long candidate : candidates) {
            if (candidate != num) {
                if (closest == -1 || Math.abs(candidate - num) < Math.abs(closest - num) || 
                    (Math.abs(candidate - num) == Math.abs(closest - num) && candidate < closest)) {
                    closest = candidate;
                }
            }
        }
        
        return String.valueOf(closest);
    }
    
    private long getMirroredPalindrome(String s) {
        int len = s.length();
        String left = s.substring(0, (len + 1) / 2);
        String mirrored = new StringBuilder(left).reverse().substring(len % 2);
        return Long.parseLong(left + mirrored);
    }
}
