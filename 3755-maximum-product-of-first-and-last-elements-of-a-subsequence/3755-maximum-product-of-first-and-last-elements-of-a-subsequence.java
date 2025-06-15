class Solution {
    public long maximumProduct(int[] nums, int m) {
        long ans = Long.MIN_VALUE;
        if(m==1) {
            for(int num:nums) {
                ans = Math.max(ans, 1L*num*num);
            }
            return ans;
        }
        long maxSoFar = Long.MIN_VALUE;
        long minSoFar = Long.MAX_VALUE;

        int i = m-1;
        while(i<nums.length) {
            int j = i-m+1;
            maxSoFar = Math.max(maxSoFar, nums[j]);
            minSoFar = Math.min(minSoFar, nums[j]);

            ans = Math.max(ans, Math.max(maxSoFar*nums[i], minSoFar*nums[i]));
            i++;
        }
        return ans;
    }
}