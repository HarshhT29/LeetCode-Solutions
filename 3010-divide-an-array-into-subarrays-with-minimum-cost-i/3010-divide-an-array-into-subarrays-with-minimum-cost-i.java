class Solution {
    public int minimumCost(int[] nums) {
        int[] proxyNums = new int[nums.length-1];
        for(int i=1;i<nums.length;i++) {
            proxyNums[i-1] = nums[i];
        }
        Arrays.sort(proxyNums);
        return nums[0]+proxyNums[0]+proxyNums[1];
    }
}