import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Graph representation
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Build the graph
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);
            
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Find the starting point for the Eulerian path
        int startNode = pairs[0][0]; // Default start
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        // Perform Hierholzer's algorithm
        LinkedList<int[]> result = new LinkedList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).pop());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.addFirst(new int[]{stack.peek(), node});
                }
            }
        }

        // Convert result to array
        int[][] output = new int[result.size()][2];
        int index = 0;
        for (int[] pair : result) {
            output[index++] = pair;
        }
        return output;
    }
}
