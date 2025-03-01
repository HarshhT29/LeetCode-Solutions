class Solution {
    public int[] applyOperations(int[] nums) {
        int[] res = new int[nums.length];
        int zero=0;
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i]==nums[i+1] && nums[i]!=0) {
                nums[i]*=2;
                nums[i+1] = 0;
            }
        }
        for(int num:nums) {
            if(num!=0) {
                res[zero++] = num; 
            }
        }
        while(zero<nums.length) {
            res[zero++]=0;
        }
        return res;
    }
}