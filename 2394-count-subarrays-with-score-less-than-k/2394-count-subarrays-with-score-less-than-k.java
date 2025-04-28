class Solution {
    public long countSubarrays(int[] nums, long k) {
        long cnt = 0L;
        long sum = 0L;
        int i=0,j=0;

        while(j<nums.length) {
            sum+=nums[j];
            while(i<=j && sum*(j-i+1)>=k) {
                sum-=nums[i];
                i++;
            }
            cnt+=(j-i+1);
            j++;
        }
        return cnt;
    }
}