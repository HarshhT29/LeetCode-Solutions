class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> safe = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(dfs(graph, visited, i)) {
                safe.add(i);
            }
        }
        return safe;
    }
    private boolean dfs(int[][] graph, int[] visited, int src) {
        if(visited[src]==1) {
            return false;
        }
        visited[src]=1;
        for(int node:graph[src]) {
            if(visited[node]==2) {
                continue;
            }
            if(visited[node]==1 || !dfs(graph, visited, node)) {
                return false;
            }
        }
        visited[src]=2;
        return true;
    }
}