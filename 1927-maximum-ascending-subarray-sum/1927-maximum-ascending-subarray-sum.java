class Solution {
    public int maxAscendingSum(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
            curr+=nums[i];
            if(nums[i-1]>=nums[i]) {
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}