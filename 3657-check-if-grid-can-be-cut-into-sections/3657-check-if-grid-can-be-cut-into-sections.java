class Solution {

    public boolean checkValidCuts(int n, int[][] rectangles) {
        // Try both horizontal and vertical cuts
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    // Check if valid cuts can be made in a specific dimension
    private boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;

        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[dim], b[dim]));

        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            if (furthestEnd <= rect[dim]) {
                gapCount++;
            }

            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        return gapCount >= 2;
    }
}