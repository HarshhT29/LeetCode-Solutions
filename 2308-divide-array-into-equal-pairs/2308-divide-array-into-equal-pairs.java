class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501];
        for(int num:nums) {
            freq[num]++;
        }
        for(int i:freq) {
            if((i&1)!=0) {
                return false;
            }
        }
        return true;
    }
}