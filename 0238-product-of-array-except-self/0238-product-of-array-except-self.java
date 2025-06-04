class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1, zero = 0;
        for(int num:nums) {
            if(num!=0) {
                prod*=num;
            } else {
                zero++;
            }
        }
        if(zero==nums.length) {
            prod = 0;
        }
        int[] ans = new int[nums.length];
        for(int i=0;i<ans.length;i++) {
            if(nums[i]==0) {
                ans[i] = prod;
            } else if(zero>0) {
                ans[i] = 0;
            } else {
                ans[i] = prod/nums[i];
            }
        }
        return ans;
    }
}