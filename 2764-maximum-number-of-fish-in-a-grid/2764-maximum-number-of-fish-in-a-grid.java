class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && grid[i][j]!=0) {
                    max = Math.max(max, helper(grid, visited, i, j));
                }
            }
        }

        return max;
    }
    private int helper(int[][] grid, boolean[][] visited, int i, int j) {
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0) {
            return 0;
        }
        if(grid[i][j]==0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        
        int c = helper(grid, visited, i, j+1);
        c+= helper(grid, visited, i, j-1);
        c+= helper(grid, visited, i+1, j);
        c+= helper(grid, visited, i-1, j);

        return c+grid[i][j];
    }
}