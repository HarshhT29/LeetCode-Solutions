class Solution {
    public int findNumbers(int[] nums) {
        int cnt = 0;
        for(int num:nums) {
            if(digitCount(num)%2==0) {
                cnt++;
            }
        }
        return cnt;
    }
    private int digitCount(int n) {
        int cnt = 0;
        while(n>0) {
            cnt++;
            n/=10;
        }
        return cnt;
    }
}