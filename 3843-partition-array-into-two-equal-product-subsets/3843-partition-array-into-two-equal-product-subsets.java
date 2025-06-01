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