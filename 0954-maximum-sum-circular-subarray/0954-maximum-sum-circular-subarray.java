class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int normalMax = maxSubSum(nums);
        if(normalMax < 0) {
            return normalMax;
        }
        int min = nums[0];
        int minSoFar = nums[0];
        int totalSum = nums[0];
        for(int i=1;i<nums.length;i++) {
            minSoFar = Math.min(minSoFar+nums[i], nums[i]);
            min = Math.min(min, minSoFar);
            totalSum+=nums[i];
        }
        return Math.max(normalMax, (totalSum-min));
    }
    private int maxSubSum(int[] nums) {
        int max = nums[0];
        int maxSoFar = nums[0];
        for(int i=1;i<nums.length;i++) {
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}