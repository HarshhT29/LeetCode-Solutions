class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        long sum = prefix[nums.length-1];
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++) {
            if(prefix[i]>=(sum-prefix[i])) {
                cnt++;
            }
        }
        return cnt;
    }
}