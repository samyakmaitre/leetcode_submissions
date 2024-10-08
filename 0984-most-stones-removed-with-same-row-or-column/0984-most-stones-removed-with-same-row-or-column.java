class Solution {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        // Union each stone's row and column.
        for (int[] stone : stones) {
            uf.union(stone[0], ~stone[1]);  
        }
        return stones.length - uf.getCount();
    }
}
class UnionFind {
    private Map<Integer, Integer> parent;
    private int count; 

    public UnionFind() {
        parent = new HashMap<>();
        count = 0;
    }

    public int find(int x) {
        if (parent.putIfAbsent(x, x) == null) {
            count++;  // New component
        }
        if (x != parent.get(x)) {
            parent.put(x, find(parent.get(x)));  // Path compression
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent.put(rootX, rootY);
            count--;  // Reduce component count since two are merged
        }
    }

    public int getCount() {
        return count;
    }
}
