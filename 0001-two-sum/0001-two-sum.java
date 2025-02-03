class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++) {
            int diff = target-nums[i];
            if(m.containsKey(diff))
                return new int[] {m.get(diff),i};
            m.put(nums[i],i);
        }
        return new int[]{};
    }
}