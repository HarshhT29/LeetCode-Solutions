class Solution {
    public int minSubarray(int[] nums, int p) {
        Map<Long, Integer> map = new HashMap<>();
        long target = 0L;
        for(int num:nums) {
            target=(target+num)%p;
        }
        if(target==0) {
            return 0;
        }

        int res = nums.length;
        long sum = 0L;

        for(int i=0;i<nums.length;i++) {
            sum=(sum+nums[i])%p;
            long rem = (sum+p-target)%p;
            if(rem==0) {
                res = Math.min(res, i+1);
            }
            if(map.containsKey(rem)) {
                res = Math.min(res, i-map.get(rem));
            }
            map.put(sum, i);
        }
        
        return res!=nums.length?res:-1;
    }
}