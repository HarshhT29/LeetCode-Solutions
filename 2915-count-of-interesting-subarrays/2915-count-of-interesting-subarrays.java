class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] cnt = new int[nums.size()];
        for(int i=0;i<cnt.length;i++) {
            cnt[i] = (nums.get(i) % modulo)==k?1:0;
        }
        Map<Long, Long> map = new HashMap<>();
        long sum = 0L;
        long res = 0L;
        for(int c:cnt) {
            sum+=c;
            long r1 = sum % modulo;
            long r2 = (r1 - k + modulo) % modulo;
            if(r2==0) {
                res++;
            }
            if(map.containsKey(r2)) {
                res+=map.get(r2);
            }
            map.put(r1, map.getOrDefault(r1, 0L)+1L);
        }
        return res;
    }
}