class Solution {
    public boolean check(int[] nums) {
        int cnt=0;;
        for(int i=1;i<nums.length;i++) {
            if(nums[i]<nums[i-1]) {
                cnt++;
            }
        }
        if(nums[0]<nums[nums.length-1]) {
            cnt++;
        }
        return cnt<2;
    }
}