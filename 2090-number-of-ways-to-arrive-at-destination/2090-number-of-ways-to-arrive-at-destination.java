class Solution {
    private final int MOD = 1000000007;
    public int countPaths(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        long[] distance = new long[n];
        boolean[] visited = new boolean[n];
        int[] dp = new int[n];

        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        dp[0] = 1;

        for(int[] road:roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }
        
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x->x[0]));
        pq.add(new long[]{0L, 0L});

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();
            long dist = curr[0];
            int u = (int) curr[1];

            if(visited[u]) { continue; }
            visited[u] = true;
            
            for(int v=0;v<n;v++) {
                if(graph[u][v]>0) {
                    if(distance[v] > distance[u] + graph[u][v]) {
                        distance[v] = distance[u] + graph[u][v];
                        dp[v] = dp[u];
                        pq.offer(new long[]{distance[v], v});
                    } else if(distance[v] == distance[u] + graph[u][v]) {
                        dp[v] = (dp[v] + dp[u]) % MOD;
                    }
                }
            }
        }
        return dp[n-1];
    }
}