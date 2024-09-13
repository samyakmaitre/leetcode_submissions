class Solution {

    public static int getXOR(int a, int b) {
        return a ^ b;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXOR = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixXOR[i + 1] = prefixXOR[i] ^ arr[i];
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int leftIdx = queries[i][0];
            int rightIdx = queries[i][1];
            result[i] = getXOR(prefixXOR[rightIdx + 1], prefixXOR[leftIdx]);
        }

        return result;
    }
}
