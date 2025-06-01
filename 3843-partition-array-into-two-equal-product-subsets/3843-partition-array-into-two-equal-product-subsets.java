class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        for(int num:nums) {
            if(target % num !=0) {
                return false;
            }
        }
        return true;
    }
}
/*
Kash contest mei maan ki sunnke try kar leta
ye solution
 */