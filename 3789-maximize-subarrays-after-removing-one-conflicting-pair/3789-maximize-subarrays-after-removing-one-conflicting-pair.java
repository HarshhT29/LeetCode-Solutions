class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new List[n + 1];
        for(int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }        
        for(int[] pair : conflictingPairs) {
            right[Math.max(pair[0], pair[1])].add(Math.min(pair[0], pair[1]));
        }        
        long ans = 0;
        int[] left = {0, 0};
        long[] bonus = new long[n + 1];
        for (int r=0;r<=n;r++) {
            for (int l:right[r]) {
                if (l > left[0]) {
                    left[1] = left[0];
                    left[0] = l;
                } else if (l > left[1]) {
                    left[1] = l;
                }
            }            
            ans += r - left[0];
            if (left[0] > 0) {
                bonus[left[0]] += left[0] - left[1];
            }
        }        
        long maxBonus = 0;
        for (long b : bonus) {
            maxBonus = Math.max(maxBonus, b);
        }       
        return ans + maxBonus;
    }
}