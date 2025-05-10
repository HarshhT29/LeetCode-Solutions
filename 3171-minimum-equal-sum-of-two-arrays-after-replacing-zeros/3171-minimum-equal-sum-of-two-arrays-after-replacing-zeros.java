class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0L, sum2 = 0L;
        int cntZero1 = 0, cntZero2 = 0;

        for(int num:nums1) {
            if(num==0) {
                sum1++;
                cntZero1++;
            } else {
                sum1+=num;
            }
        }
        for(int num:nums2) {
            if(num==0) {
                sum2++;
                cntZero2++;
            } else {
                sum2+=num;
            }
        }
        if((cntZero1==0 && sum2>sum1) || (cntZero2==0 && sum1>sum2)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}