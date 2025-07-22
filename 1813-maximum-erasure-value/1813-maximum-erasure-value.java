class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, j=0;
        int sum = 0;
        int maxSum = 0;
        while(j<nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            sum+=nums[j];
            while(i<j && map.size()<(j-i+1)) {
                map.put(nums[i], map.get(nums[i])-1);
                sum-=nums[i];
                if(map.get(nums[i])==0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            maxSum = Math.max(maxSum, sum);
            j++;
        }
        return maxSum;
    }
}