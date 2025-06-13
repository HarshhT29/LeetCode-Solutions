class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n+1];
        gaps[0] = startTime[0];
        for(int i=1;i<n;i++) {
            gaps[i] = startTime[i] - endTime[i-1];
        }
        gaps[n] = eventTime - endTime[n-1];

        int[] prefixMax = new int[n+1];
        prefixMax[0] = gaps[0];
        for(int i=1;i<=n;i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], gaps[i]);
        }
        int[] suffixMax = new int[n+1];
        suffixMax[n] = gaps[n];
        for(int i=n-1;i>=0;i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], gaps[i]);
        }

        int res = 0;
        for(int i=1;i<=n;i++) {
            int mt = endTime[i-1] - startTime[i-1];
            int leftMax = (i - 2 >= 0) ? prefixMax[i - 2] : 0;
            int rightMax = (i + 1 <= n) ? suffixMax[i + 1] : 0;
            if(mt <= Math.max(leftMax, rightMax)) {
                res = Math.max(res, gaps[i-1]+gaps[i]+mt);
            }
            res = Math.max(res, gaps[i-1]+gaps[i]);
        }
        return res;
    }
}