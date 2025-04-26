class Solution {
    private boolean[] rows;
    private boolean[] d1;
    private boolean[] d2;
    private int cnt;

    public int totalNQueens(int n) {
        rows = new boolean[n];
        d1 = new boolean[2*n];
        d2 = new boolean[2*n];
        cnt = 0;
        backtrack(n, 0);
        return cnt;
    }
    private void backtrack(int n, int col) {
        if(col==n) {
            cnt++;
            return ; 
        }
        for(int i=0;i<n;i++) {
            if(rows[i] || d1[i-col+n] || d2[i+col]) {
                continue;
            }
            rows[i] = true;
            d1[i-col+n] = true;
            d2[i+col] = true;

            backtrack(n, col+1);

            rows[i] = false;
            d1[i-col+n] = false;
            d2[i+col] = false;
        }
    }
}