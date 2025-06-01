class Solution {
    public int distributeCandies(int n, int limit) {
        int min = Math.max(0, n-(2*limit));
        int max = Math.min(n, limit);
        int cnt = 0;
        for(int i=min;i<=max;i++) {
            cnt += (Math.min(n-i, limit) - Math.max(0, n-limit-i))+1;
        }
        return cnt;
    }
}