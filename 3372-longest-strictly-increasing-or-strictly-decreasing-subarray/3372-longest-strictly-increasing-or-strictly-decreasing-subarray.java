class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 0;
        int inCnt = 0, deCnt = 0;

        for(int i=1;i<nums.length;i++) {
            if(nums[i]>nums[i-1]) {
                inCnt++;
                deCnt = 0;
            } else if(nums[i-1]>nums[i]) {
                deCnt++;
                inCnt = 0;
            } else {
                inCnt = 0;
                deCnt = 0;
            }
            max = Math.max(max, Math.max(inCnt, deCnt));
        }
        return max+1;
    }
}