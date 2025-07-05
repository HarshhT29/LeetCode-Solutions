class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501];
        for(int a:arr) {
            freq[a]++;
        }
        int ans = -1;
        for(int i=1;i<501;i++) {
            if(freq[i]==i) {
                ans = Math.max(ans, i);
            }
        }
        return ans;
    }
}