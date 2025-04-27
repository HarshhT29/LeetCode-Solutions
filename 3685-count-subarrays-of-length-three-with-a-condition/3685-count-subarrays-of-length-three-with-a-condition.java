class Solution {
    public int countSubarrays(int[] nums) {
        int cnt=0;
        int i=0,j=2;
        while(i<nums.length-1 && j<nums.length) {
            if((double)(nums[i]+nums[j])==(nums[i+1]/2.0)) {
                cnt++;
            }
            i++;
            j++;
        }
        return cnt;
    }
}