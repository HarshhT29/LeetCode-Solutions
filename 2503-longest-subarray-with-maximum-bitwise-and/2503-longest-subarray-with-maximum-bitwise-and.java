class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, res = 0;
        int temp = 0;

        for(int x:nums) {
            if(max<x) {
                max = x;
                res = temp = 0;
            }
            temp = max==x?temp+1:0;
            res = Math.max(res, temp);
        }
        return res;
    }
}