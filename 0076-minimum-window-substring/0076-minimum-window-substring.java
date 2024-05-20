class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> targetCharCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCharCount.put(c, targetCharCount.getOrDefault(c, 0) + 1);
        }

        int required = targetCharCount.size();
        int formed = 0;

        Map<Character, Integer> windowCharCount = new HashMap<>();
        int start = 0, end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            windowCharCount.put(c, windowCharCount.getOrDefault(c, 0) + 1);

            if (targetCharCount.containsKey(c) && 
                windowCharCount.get(c).intValue() == targetCharCount.get(c).intValue()) {
                formed++;
            }

            while (start <= end && formed == required) {
                c = s.charAt(start);

                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }

                windowCharCount.put(c, windowCharCount.get(c) - 1);
                if (targetCharCount.containsKey(c) && 
                    windowCharCount.get(c).intValue() < targetCharCount.get(c).intValue()) {
                    formed--;
                }

                start++;
            }

            end++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}