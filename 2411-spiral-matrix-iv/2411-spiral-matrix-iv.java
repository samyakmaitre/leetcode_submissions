/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] row : matrix) {
            Arrays.fill(row, -1);
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        
        int row = 0, col = 0;
        int totalCells = m * n;
        
        ListNode current = head;
        
        for (int i = 0; i < totalCells && current != null; i++) {
            matrix[row][col] = current.val;
            current = current.next;
            
            int newRow = row + directions[directionIndex][0];
            int newCol = col + directions[directionIndex][1];
            
            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || matrix[newRow][newCol] != -1) {
                directionIndex = (directionIndex + 1) % 4;
                newRow = row + directions[directionIndex][0];
                newCol = col + directions[directionIndex][1];
            }
            
            row = newRow;
            col = newCol;
        }
        
        return matrix;
    }
}
