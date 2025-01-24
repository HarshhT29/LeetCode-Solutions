class Solution {
    private boolean[] safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        safe = new boolean[graph.length];
        int[] visited = new int[safe.length];
        for(int i=0;i<graph.length;i++) {
            if(visited[i]==0) {
                dfs(graph, visited, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<safe.length;i++) {
            if(safe[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    private boolean dfs(int[][] graph, int[] visited, int src) {
        visited[src] = 1;
        boolean isSafe = true;

        for(int x:graph[src]) {
            if(visited[x]==0) {
                isSafe&=dfs(graph, visited, x);
            } else if(visited[x]==0) {
                return safe[src]=false;
            } else {
                isSafe&=safe[x];
            }
        }
        visited[src]=2;
        return safe[src]=isSafe;
    }
}