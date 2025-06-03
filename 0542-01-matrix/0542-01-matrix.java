class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        for(int[] dist:distance) {
            Arrays.fill(dist, -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==0) {
                    q.offer(new int[]{i, j, 0});
                    distance[i][j] = 0;
                }
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                for(int d=0;d<4;d++) {
                    int newR = curr[0]+dir[d][0];
                    int newC = curr[1]+dir[d][1];

                    if(newR>=0 && newC>=0 && newR<mat.length && newC<mat[0].length && distance[newR][newC]==-1) {
                        distance[newR][newC] = distance[curr[0]][curr[1]]+1;
                        q.offer(new int[]{newR, newC, distance[newR][newC]});
                    }
                }
            }
        }
        return distance;
    }
}