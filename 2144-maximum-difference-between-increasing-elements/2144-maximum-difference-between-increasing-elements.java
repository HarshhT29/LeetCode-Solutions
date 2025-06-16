class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = 0;
        int minSoFar = nums[0];
        for(int num:nums) {
            minSoFar = Math.min(minSoFar, num);
            maxDiff = Math.max(maxDiff, num-minSoFar);
        }
        return maxDiff!=0?maxDiff:-1;
    }
}