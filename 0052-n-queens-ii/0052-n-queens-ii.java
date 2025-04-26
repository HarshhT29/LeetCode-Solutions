class Solution {
    private List<List<String>> res;
    public int totalNQueens(int n) {
        res = new ArrayList<>();
        solve(n, 0, new ArrayList<>());

        return res.size();
    }
    private void solve(int n, int col, List<String> li) {
        if(col==n) {
            res.add(new ArrayList<>(li));
            return ;
        }
        for(int i=0;i<n;i++) {
            if(isSafe(li, i, col)) {
                li.add(generateRow(n, i));
                solve(n, col+1, li);
                li.remove(li.size()-1);
            }
        }
    }
    private boolean isSafe(List<String> board, int row, int col) {
        for(int i=0;i<board.size();i++) {
            int rowQ = board.get(i).indexOf('Q');
            if(rowQ==row) {
                return false;
            }
            if(Math.abs(col-i)==Math.abs(row-rowQ)) {
                return false;
            }
        }
        return true;
    }
    private String generateRow(int n, int pos) {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<n;i++) {
            s.append(i==pos?'Q':'.');
        }
        return s.toString();
    }
}