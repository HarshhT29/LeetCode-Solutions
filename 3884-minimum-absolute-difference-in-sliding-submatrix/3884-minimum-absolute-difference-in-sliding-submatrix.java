class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n-k+1][m-k+1];

        for(int i=0;i<=n-k;i++) {
            for(int j=0;j<=m-k;j++) {
                Set<Integer> distinct = new HashSet<>();
                for(int x=i;x<(i+k);x++) {
                    for(int y=j;y<(j+k);y++) {
                        distinct.add(grid[x][y]);
                    }
                }
                int size = distinct.size();
                if(size<2) {
                    res[i][j] = 0;
                } else {
                    List<Integer> list = new ArrayList<>(distinct);
                    Collections.sort(list);
                    int min = Integer.MAX_VALUE;
                    for(int it=1;it<size;it++) {
                        min = Math.min(min, (list.get(it)-list.get(it-1)));
                    }
                    res[i][j] = min;
                }
            }
        }
        return res;
    }
}