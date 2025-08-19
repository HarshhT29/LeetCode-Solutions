class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0L;
        long con_zero_cnt = 0L;
        for(int num:nums) {
            con_zero_cnt = num==0?(con_zero_cnt+1):0;
            cnt += con_zero_cnt;
        }
        return cnt;
    }
}