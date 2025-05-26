class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        char[] colorsArr = colors.toCharArray();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge:edges) {
            graph.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
        }
        
        int[][] dp = new int[26][colorsArr.length];
        int[] visited = new int[colorsArr.length];

        int max = 0;
        for(int i=0;i<colorsArr.length;i++) {
            int res = dfs(graph, visited, i, colorsArr, dp);
            if(res==Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, res);
        }
        return max;
    }
    private int dfs(Map<Integer, List<Integer>> graph, int[] visited, int curr, char[] colors, int[][] dp) {
        if(visited[curr]==1) {
            return Integer.MAX_VALUE;
        }
        if(visited[curr]==0) {
            visited[curr] = 1;
            for(int node:graph.getOrDefault(curr, Collections.emptyList())) {
                int res = dfs(graph, visited, node, colors, dp);
                if(res == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for(int i=0;i<26;i++) {
                    dp[i][curr] = Math.max(dp[i][curr], dp[i][node]);
                }
            }
            dp[colors[curr]-'a'][curr]++;
            visited[curr] = 2; 
        }
        return dp[colors[curr]-'a'][curr];
    }
}