class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0L;
        int[] diff = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            diff[i] =  (nums[i]^k) - nums[i];
            sum+=nums[i];
        }
        Arrays.sort(diff);
        for(int i=diff.length-1;i>=1;i-=2) {
            if((sum+diff[i]+diff[i-1]) > sum) {
                sum += (diff[i] + diff[i-1]);
            }
        }
        return sum;
    }
}