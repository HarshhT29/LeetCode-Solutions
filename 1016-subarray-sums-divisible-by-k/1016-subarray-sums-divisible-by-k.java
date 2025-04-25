class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int num:nums) {
            sum+=num;
            int rem = ((sum%k)+k)%k; //(sum%k)+k -ve ko handle karne ke liye hai
            if(rem==0) {
                res++;
            }
            if(map.containsKey(rem)) {
                res+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        return res;
    }
}