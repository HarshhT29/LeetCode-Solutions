class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0,res = 0;
        for(int num:nums) {
            sum+=num;
            if(sum==k) {
                res++;
            }
            if(map.containsKey(sum-k)) {
                res+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}