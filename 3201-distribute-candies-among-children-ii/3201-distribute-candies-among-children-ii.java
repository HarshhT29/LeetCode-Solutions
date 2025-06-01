class Solution {
    public long distributeCandies(int n, int limit) {
        long min = Math.max(0, n-(2*limit));
        long max = Math.min(n, limit);
        long cnt = 0;
        for(long i=min;i<=max;i++) {
            cnt += (Math.min(n-i, limit) - Math.max(0, n-limit-i))+1L;
        }
        return cnt;
    }
}