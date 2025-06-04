class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int i = 0;
        while(i<nums.length) {
            if(nums[i]%2==0 && nums[i]<=threshold) {
                int j = i;
                while(j<nums.length && nums[j]<=threshold && (j==i || nums[j]%2!=nums[j-1]%2)) {
                    j++;
                }
                maxLen = Math.max(maxLen, j-i);
                i = j;
            } else {
                i++;
            }
        }
        return maxLen;
    }
}