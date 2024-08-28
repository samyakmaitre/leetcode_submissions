class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int cols = grid2[0].length;
        int subIslandCount = 0;
        
        // Perform DFS on each cell in grid2
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If we find a land cell in grid2, check if it's a sub-island
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        subIslandCount++;
                    }
                }
            }
        }
        return subIslandCount;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Boundary check
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length) {
            return true;
        }
        
        // If the cell is water or already visited, stop the DFS
        if (grid2[i][j] == 0) {
            return true;
        }
        
        // If the current cell in grid2 is land but in grid1 it is water, it's not a sub-island
        boolean isSubIsland = grid1[i][j] == 1;
        
        // Mark the current cell as visited in grid2 by setting it to 0
        grid2[i][j] = 0;
        
        // Explore in all 4 directions
        isSubIsland &= dfs(grid1, grid2, i + 1, j);
        isSubIsland &= dfs(grid1, grid2, i - 1, j);
        isSubIsland &= dfs(grid1, grid2, i, j + 1);
        isSubIsland &= dfs(grid1, grid2, i, j - 1);
        
        return isSubIsland;
    }
}
