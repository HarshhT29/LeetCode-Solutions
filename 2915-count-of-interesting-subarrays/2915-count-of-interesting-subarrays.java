class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Long, Long> map = new HashMap<>();
        long sum = 0L;
        long res = 0L;
        for(int num:nums) {
            sum+=(num % modulo)==k?1:0;
            long sRem = sum % modulo;
            long rem = (sRem - k + modulo) % modulo;
            if(rem==0) {
                res++;
            }
            if(map.containsKey(rem)) {
                res+=map.get(rem);
            }
            map.put(sRem, map.getOrDefault(sRem, 0L)+1L);
        }
        return res;
    }
}