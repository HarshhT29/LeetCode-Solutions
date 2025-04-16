class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int i=0, j=0, cnt = 0;
        long res = 0L;
        while(j<nums.length) {
            while(i<nums.length && cnt<k) {
                cnt+=map.getOrDefault(nums[i], 0);
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
                i++;
            }
            if(cnt>=k) {
                res+=nums.length-i+1;
            }
            map.put(nums[j], map.getOrDefault(nums[j], 0)-1);
            cnt-=map.getOrDefault(nums[j], 0);
            j++;
        }
        return res;
    }
}