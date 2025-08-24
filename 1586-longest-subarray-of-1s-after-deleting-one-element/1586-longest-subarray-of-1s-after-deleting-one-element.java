class Solution {
    public int longestSubarray(int[] nums) {
        int i=0, j=0;
        int zero = 0;
        int max_size = 0;
        while(j<nums.length) {
            zero = nums[j]==0?zero+1:zero;
            while(zero>1) {
                zero = nums[i]==0?zero-1:zero;
                i++;
            }
            max_size = Math.max(max_size, j-i);
            j++;
        }
        return max_size;
    }
}