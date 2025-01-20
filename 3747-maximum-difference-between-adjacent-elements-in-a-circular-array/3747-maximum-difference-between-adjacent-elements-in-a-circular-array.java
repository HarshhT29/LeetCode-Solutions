class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            int index = (i+1)%(nums.length);
            max = Math.max(max, Math.abs(nums[index]-nums[i]));
        }
        return max;
    }
}