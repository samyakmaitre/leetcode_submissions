class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        for (String recipe : recipes) {
            indegree.put(recipe, 0);
            graph.put(recipe, new ArrayList<>());
        }

        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!available.contains(ingredient)) {
                    graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipes[i]);
                    indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0) + 1);
                }
            }
        }

        for (String recipe : recipes) {
            if (indegree.get(recipe) == 0) {
                queue.add(recipe);
            }
        }

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(curr);
            available.add(curr);

            if (graph.containsKey(curr)) {
                for (String next : graph.get(curr)) {
                    indegree.put(next, indegree.get(next) - 1);
                    if (indegree.get(next) == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return result;
    }
}