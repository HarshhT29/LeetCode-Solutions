class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        int i=0;
        while(i <= n-2) {
            ans[i] = i+1;
            ans[i+1] = -(i+1);
            i+=2;
        }
        return ans;
    }
}