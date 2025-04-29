class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for(int num:nums) {
            max = Math.max(max, num);
        }
        int i=0, j=0;
        int cnt = 0;
        long res = 0;

        while(j<nums.length) {
            if(nums[j]==max) {
                cnt++;
            }
            while(i<=j && cnt>=k) {
                if(nums[i]==max) {
                    cnt--;
                }
                i++;
                res+=(nums.length-j);
            }
            j++;
        }
        return res;
    }
}