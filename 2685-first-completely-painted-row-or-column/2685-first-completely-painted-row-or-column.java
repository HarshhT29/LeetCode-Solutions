class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map.put(mat[i][j], new int[] {i, j});
            }
        }
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i=0;i<m*n;i++) {
            int[] loc  = map.get(arr[i]);
            row[loc[0]]++;
            col[loc[1]]++;

            if(row[loc[0]]==m || col[loc[1]]==n) {
                return i;
            }
        }
        return -1;
    }
}