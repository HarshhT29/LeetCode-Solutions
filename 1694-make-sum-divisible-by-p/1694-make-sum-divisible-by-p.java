class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Long, Integer> map = new HashMap<>();
        long target = 0L;
        for(int num:nums) {
            target=(target+num)%p;
        }
        if(target%p==0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        long sum = 0L;
        for(int i=0;i<nums.length;i++) {
            sum=(sum+nums[i])%p;
            long rem = (sum+p-target)%p;

            if(map.containsKey(rem)) {
                res = Math.min(res, i-map.get(rem));
            }
            map.put(sum%p, i);
        }
        return res!=Integer.MAX_VALUE?res:-1;
    }
}