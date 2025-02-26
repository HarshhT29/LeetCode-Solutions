class Solution {
    public int maxAbsoluteSum(int[] nums) {
        return Math.max(kadaneAlgo(nums, "max"), -kadaneAlgo(nums, "min"));
    }
    private int kadaneAlgo(int[] nums, String minMax) {
        int limit = minMax.equals("max")?Integer.MIN_VALUE:Integer.MAX_VALUE;
        int currSum = 0;
        if(minMax.equals("min")) {
            for(int num:nums) {
                currSum += num;
                limit = Math.min(limit, currSum);
                if(currSum>0) {
                    currSum = 0;
                }
            }
            return limit;
        }
        for(int num:nums) {
            currSum += num;
            limit = Math.max(limit, currSum);
            if(currSum<0) {
                currSum = 0;
            }
        }
        return limit;
    }
}