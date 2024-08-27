class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Create the graph
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair<>(v, prob));
            graph.get(v).add(new Pair<>(u, prob));
        }
        
        // Priority queue to get the maximum probability path
        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>((a, b) -> Double.compare(b.getKey(), a.getKey()));
        pq.offer(new Pair<>(1.0, start_node));
        
        // Array to store the max probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        while (!pq.isEmpty()) {
            Pair<Double, Integer> current = pq.poll();
            double currProb = current.getKey();
            int node = current.getValue();
            
            // If we reached the end_node, return the probability
            if (node == end_node) {
                return currProb;
            }
            
            // Explore neighbors
            for (Pair<Integer, Double> neighbor : graph.get(node)) {
                int nextNode = neighbor.getKey();
                double edgeProb = neighbor.getValue();
                double newProb = currProb * edgeProb;
                
                // If newProb is greater than the previously recorded probability for nextNode
                if (newProb > maxProb[nextNode]) {
                    maxProb[nextNode] = newProb;
                    pq.offer(new Pair<>(newProb, nextNode));
                }
            }
        }
        
        // If the end_node is not reachable, return 0
        return 0.0;
    }
}

// Helper class to store pairs of values (like in C++)
class Pair<K, V> {
    private K key;
    private V value;
    
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey() {
        return key;
    }
    
    public V getValue() {
        return value;
    }
}