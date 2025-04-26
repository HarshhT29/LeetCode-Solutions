class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int i=0;
        int a=-1, b=-1, c=-1;
        long cnt = 0L;
        while(i<nums.length) {
            a = nums[i]==minK?i:a;
            b = nums[i]==maxK?i:b;
            c = (nums[i]>maxK || nums[i]<minK)?i:c;

            cnt += Math.max(Math.min(a,b)-c, 0);
            i++;
        }
        return cnt;
    }
}