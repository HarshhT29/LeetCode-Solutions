class Solution {
    public long maximumOr(int[] nums, int k) {
        long[] pre = new long[nums.length];
        long[] suf = new long[nums.length];
        pre[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            pre[i] = pre[i-1]|nums[i];
        }
        suf[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) {
            suf[i] = suf[i+1]|nums[i];
        }
        long maxOr = 0L;
        for(int i=0;i<nums.length;i++) {
            long shift = 1L*nums[i] << k;
            long preVal = i>0?pre[i-1]:0;
            long sufVal = i<nums.length-1?suf[i+1]:0;

            maxOr = Math.max(maxOr, shift|preVal|sufVal);
        }
        return maxOr;
    }
}