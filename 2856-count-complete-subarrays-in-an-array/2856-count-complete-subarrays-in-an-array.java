class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {
            distinct.add(num);
        }
        int i=0,j=0;
        int complete=0;
        while(j<nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
            while(i<nums.length && map.size()==distinct.size()) {
                complete+=(nums.length-j);
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i])==0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return complete;
    }
}