class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        long pairs = 0L;

        while(i<j) {
            if(nums[i]+nums[j]<=upper) {
                pairs+=(j-i);
                i++;
            } else {
                j--;
            }
        }

        i=0; j=nums.length-1;
        while(i<j) {
            if(nums[i]+nums[j]<lower) {
                pairs-=(j-i);
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }
}