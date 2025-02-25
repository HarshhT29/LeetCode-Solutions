class Solution {
    private final int MOD = 1000000007;
    public int numOfSubarrays(int[] arr) {
        int cnt = 0;
        int even = 1, odd = 0;
        int sum = 0;

        for(int x:arr) {
            sum+=x;
            if((sum&1)==0) {
                cnt = (odd+cnt)%MOD;
                even++;
            } else {
                cnt = (cnt+even)%MOD;
                odd++;
            }
            cnt = (cnt)%MOD;
        }
        return cnt;
    }
}