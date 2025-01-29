class Solution {
    private int[] parent;
    private int[] rank;
    
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];

        for(int[] edge:edges) {
            if(!union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if(x==y) {
            return false;
        }

        if(rank[x]>rank[y]) {
            parent[y] = x;
        } else if(rank[x]<rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            rank[x]++;
        }

        return true;
    }

    private int find(int x) {
        if(parent[x]==0) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}