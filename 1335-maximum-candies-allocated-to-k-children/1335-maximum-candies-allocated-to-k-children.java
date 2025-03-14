class Solution {
    public int maximumCandies(int[] candies, long k) {
        // long sum = 0L;
        int start = 1;
        int end = 0;
        for(int candy:candies) {
            end = Math.max(end, candy);
        }
        while(start<=end) {
            int mid = (start+end)/2;
            if(helper(candies, mid, k)) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return start-1;
    }
    private boolean helper(int[] nums, long n, long k) {
        long sum = 0L;
        for(int num:nums) {
            sum+=(num/n);
            if(sum>=k) {
                return true;
            }
        }
        return false;
    }
}