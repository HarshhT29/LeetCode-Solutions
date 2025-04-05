class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums,0,0);
    }
    private int helper(int[] nums,int xor,int i) {
        if(i==nums.length)
            return xor;
        return helper(nums,xor,i+1)+helper(nums,xor^nums[i],i+1);
    }
}