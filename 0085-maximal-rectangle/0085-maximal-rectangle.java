class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        
        for (int i = 0; i < rows; i++) {
            // Update the histogram heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            
            // Calculate the maximum rectangle in this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] stack = new int[heights.length + 1];
        int stackIndex = -1;
        
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while (stackIndex != -1 && currentHeight < heights[stack[stackIndex]]) {
                int height = heights[stack[stackIndex--]];
                int width = (stackIndex == -1) ? i : i - stack[stackIndex] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack[++stackIndex] = i;
        }
        
        return maxArea;
    }
}
