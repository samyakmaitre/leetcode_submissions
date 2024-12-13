import java.util.PriorityQueue;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        boolean[] marked = new boolean[n]; // Tracks marked elements
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // Tie-breaker: smaller index
            return a[0] - b[0]; // Smaller value first
        });
        
        // Add all elements with their indices to the min-heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }
        
        long score = 0;

        // Process elements until all are marked
        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int value = current[0];
            int index = current[1];

            // Skip if already marked
            if (marked[index]) continue;

            // Add value to score
            score += value;

            // Mark the current element and its adjacent elements
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < n - 1) marked[index + 1] = true;
        }

        return score;
    }
}

