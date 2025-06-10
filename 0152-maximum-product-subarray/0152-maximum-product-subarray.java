class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++) {
            if(prefix==0) {
                prefix = 1;
            }
            if(suffix==0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[nums.length-1-i];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}