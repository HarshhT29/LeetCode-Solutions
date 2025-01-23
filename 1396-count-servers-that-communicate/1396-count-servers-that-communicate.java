class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] row = new int[m];
        int[] col = new int[n];
        int cnt = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    row[j]++;
                    col[i]++;
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    if(row[j]>1 || col[i]>1) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}