class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0,val=0,ans=0;
        for(int x:nums) {
            prefix+=x;
            val=prefix-k;
            if(prefix==k)
                ans++;
            if(map.containsKey(val))
                ans+=map.get(val);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return ans;
    }
}