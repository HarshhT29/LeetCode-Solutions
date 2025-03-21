class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for(String s:supplies) {
            set.add(s);
        }
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(String s:recipes) {
            adjList.put(s, new ArrayList<>());
            indegree.put(s, 0);
        }

        for(int i=0;i<recipes.length;i++) {
            // List<String> ingredient = ;
            for(String ingredient:ingredients.get(i)) {
                if(!set.contains(ingredient)) {
                    indegree.put(recipes[i], indegree.get(recipes[i])+1);
                    adjList.computeIfAbsent(ingredient, a -> new ArrayList<>()).add(recipes[i]);
                }
            }
        }

        Queue<String> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        for(String s:recipes) {
            if(indegree.get(s)==0) {
                q.offer(s);
            }
        }

        while(!q.isEmpty()) {
            String curr = q.poll();
            ans.add(curr);
            for(String s:adjList.get(curr)) {
                indegree.put(s, indegree.get(s)-1);
                if(indegree.get(s)==0) {
                    q.add(s);
                }
            }
        }

        // printGraph(adjList, indegree);

        return ans;
    }
    private void printGraph(Map<String, List<String>> adjList, Map<String, Integer> indegree) {
    System.out.println("Adjacency List:");
    for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }

    System.out.println("\nIn-degree Map:");
    for (Map.Entry<String, Integer> entry : indegree.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue());
    }
}

}