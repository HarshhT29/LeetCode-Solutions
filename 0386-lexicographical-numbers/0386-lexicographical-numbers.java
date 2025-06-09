class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++) {
            dfs(n, i, res);
        }
        return res;
    }
    private void dfs(int n, int num, List<Integer> res) {
        if(num > n) {
            return ;
        }
        res.add(num);
        num*=10;
        for(int i=0;i<10;i++) {
            dfs(n, num+i, res);
        }
    }
}