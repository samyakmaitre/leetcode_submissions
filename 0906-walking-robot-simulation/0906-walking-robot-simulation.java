class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Direction vectors: North, East, South, West
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirIndex = 0;  // Start facing North
        
        // Convert obstacles array to a set of strings for O(1) lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0;  // Starting position
        int maxDistSquared = 0;
        
        for (int command : commands) {
            if (command == -1) {  // Turn right
                dirIndex = (dirIndex + 1) % 4;
            } else if (command == -2) {  // Turn left
                dirIndex = (dirIndex + 3) % 4;
            } else {
                // Move forward 'command' steps in the current direction
                int dx = directions[dirIndex][0];
                int dy = directions[dirIndex][1];
                
                for (int i = 0; i < command; i++) {
                    int nextX = x + dx;
                    int nextY = y + dy;
                    
                    // Check for obstacle
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;  // Stop if there's an obstacle
                    }
                    
                    // Move to the next position
                    x = nextX;
                    y = nextY;
                    
                    // Calculate distance squared from the origin
                    maxDistSquared = Math.max(maxDistSquared, x * x + y * y);
                }
            }
        }
        
        return maxDistSquared;
    }
}