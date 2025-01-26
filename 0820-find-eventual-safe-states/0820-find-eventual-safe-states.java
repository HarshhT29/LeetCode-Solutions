class Solution {
    //Agar node part of the cycle hai, ya cycle se connected hai 
    //toh vo unsafe hai

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n]; // 0:unvisited, 1:visiting, 2:safe
        List<Integer> safe = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(visited[i]==2 || dfs(graph, visited, i)) {
                safe.add(i);
            }
        }
        return safe;
    }
    private boolean dfs(int[][] graph, int[] visited, int src) {
        visited[src]=1;
        for(int node:graph[src]) {
            if(visited[node]==2) {
                continue; //safe!! skip
            }
            if(visited[node]==1 || !dfs(graph, visited, node)) {
                return false; //cycle or unsafe
            }
        }
        visited[src]=2; //safe
        return true;
    }
}