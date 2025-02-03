class Solution {
    public int majorityElement(int[] nums) {
        int cnt=1;
        int res=0;
        for(int i=1;i<nums.length;i++) {
            if(nums[res]==nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
            if(cnt==0) {
                res=i;
                cnt=1;
            }
        }
        return nums[res];
    }
}