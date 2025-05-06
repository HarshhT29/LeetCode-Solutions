class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int i=0, j=n, idx=0;
        while(idx<nums.length) {
            ans[idx++] = nums[i++];
            ans[idx++] = nums[j++];
        }
        return ans;
    }
}