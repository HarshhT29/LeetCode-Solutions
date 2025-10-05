class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        Queue<int[]> q1 = new LinkedList<>();
        Queue<int[]> q2 = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {       
            q1.offer(new int[]{i, 0});
            p[i][0] = true;
        }
        for (int j = 0; j < n; j++) {       
            q1.offer(new int[]{0, j});
            p[0][j] = true;
        }
        for (int i = 0; i < m; i++) {       
            q2.offer(new int[]{i, n - 1});
            a[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {       
            q2.offer(new int[]{m - 1, j});
            a[m - 1][j] = true;
        }
        
        bfs(heights, q1, p);
        bfs(heights, q2, a);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p[i][j] && a[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];
            for (int[] d : dir) {
                int nrow = row + d[0], ncol = col + d[1];
                if (nrow >= 0 && ncol >= 0 && nrow < heights.length && ncol < heights[0].length
                    && !visited[nrow][ncol] && heights[nrow][ncol] >= heights[row][col]) {
                    visited[nrow][ncol] = true;
                    q.offer(new int[]{nrow, ncol});
                }
            }
        }
    }
}