class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int[] rightMax = new int[nums.length];
        rightMax[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--) {
            rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        }
        for(int i=0;i<nums.length;i++) {
            if(rightMax[i]!=nums[i]) {
                maxDiff = Math.max(maxDiff, rightMax[i]-nums[i]);
            }
        }
        return maxDiff!=Integer.MIN_VALUE?maxDiff:-1;
    }
}