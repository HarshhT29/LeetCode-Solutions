class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int m = edges1.length+1;
        int n = edges2.length+1;

        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        for(int[] edge:edges1) {
            graph1.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph1.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        for(int[] edge:edges2) {
            graph2.computeIfAbsent(edge[0], e -> new ArrayList<>()).add(edge[1]);
            graph2.computeIfAbsent(edge[1], e -> new ArrayList<>()).add(edge[0]);
        }

        int max = 0;
        for(int i=0;i<n;i++) {
            max = Math.max(max, bfs(graph2, i, k-1));
        }

        int[] res = new int[m];
        for(int i=0;i<m;i++) {
            res[i] = max + bfs(graph1, i, k);
        }
        return res;
    }
    private int bfs(Map<Integer, List<Integer>> graph, int start, int k) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(start, -1));
        int cnt = 0;
        while(!q.isEmpty() && k>=0) {
            int size = q.size();
            cnt+=size;
            for(int i=0;i<size;i++) {
                Pair<Integer,Integer> curr = q.poll();
                int u = curr.getKey();
                int p = curr.getValue();

                for(int v:graph.getOrDefault(u, Collections.emptyList())) {
                    if(v!=p) {
                        q.offer(new Pair<>(v, u));
                    }
                }
            }
            k--;
        }
        return cnt;
    }
}