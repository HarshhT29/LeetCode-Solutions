class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int i=0,j=0;
        long sum = 0;
        long max = 0;
        while(j<nums.length) {
            if(!set.contains(nums[j])) {
                sum+=nums[j];
                set.add(nums[j]);
                j++;
                if(j-i==k) {
                    max = Math.max(max, sum);
                    sum-=nums[i];
                    set.remove(nums[i]);
                    i++;
                }
            } else {
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }  
        }
        return max;
    }
}