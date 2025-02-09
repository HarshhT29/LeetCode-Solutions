class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long bad = 0L, good = 0L;
        for(int i=0;i<nums.length;i++) {
            good = map.getOrDefault(i-nums[i], 0L);
            map.put(i-nums[i], good+1);
            bad += i-good;
        }
        return bad;
    }
}