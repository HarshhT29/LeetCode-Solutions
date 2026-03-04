class Solution {
    public int numSpecial(int[][] mat) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1) {
                    rows.put(i, rows.getOrDefault(i, 0)+1);
                    cols.put(j, cols.getOrDefault(j, 0)+1);
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1 && rows.get(i)<=1 && cols.get(j)<=1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}