class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] netShifts = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            netShifts[start] += (direction == 1 ? 1 : -1);
            netShifts[end + 1] -= (direction == 1 ? 1 : -1);
        }

        int shiftEffect = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            shiftEffect += netShifts[i];
            int newChar = ((result[i] - 'a' + shiftEffect) % 26 + 26) % 26;
            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }
}